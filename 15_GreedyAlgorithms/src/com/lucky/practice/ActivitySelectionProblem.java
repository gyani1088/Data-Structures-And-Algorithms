package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * We are provided with the start time and end time in a pair, and a list of such pairs. end time is always > start time.
 * What is the maximum numbers of such pairs(each pair defines an activity) i.e. activities be done in one go, such that
 * no two activities take a common space in the timeline i.e from the start of the first activity to the end time of the
 * activity finishing last.
 * */
public class ActivitySelectionProblem {
    public static void main(String[] args) {
        ArrayList<Pair> activities = new ArrayList<>(
                Arrays.asList(new Pair(3,8),new Pair(2,4),new Pair(1,3),new Pair(10,11)));
        System.out.println(activities);
        System.out.println(maxActivities(activities));
    }
    public static List<Pair> maxActivities(List<Pair> timeSlots){
        List<Pair> sortedTimeSlots = timeSlots.stream()
                .sorted((p1,p2)->p1.end-p2.end)
                .collect(Collectors.toList());
        List<Pair> res = new ArrayList<>();
        res.add(sortedTimeSlots.get(0));
        int j=0;
        for(int i=1;i<sortedTimeSlots.size();i++){
            if(sortedTimeSlots.get(i).start>=res.get(j).end){
                res.add(sortedTimeSlots.get(i));
                j++;
            }
        }
        return  res;
    }

    private static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" +
                    start + "," +
                    end +
                    ')';
        }
    }
}
