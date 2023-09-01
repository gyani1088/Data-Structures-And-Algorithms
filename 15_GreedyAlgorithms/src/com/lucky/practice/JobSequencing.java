package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given a list of jobs. A job takes 1 unit of time. each job has a certain deadline in units of time and an associated
 * profit. Our task is to maximize the cumulative profit by choosing jobs within their deadlines and one at a time.
 * */
public class JobSequencing {
    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>(Arrays.asList(
                new Job(4,70),
                new Job(1,80),
                new Job(1,30),
                new Job(1,100)
        ));
        System.out.println(maxProfit(jobs));

        jobs = new ArrayList<>(Arrays.asList(
                new Job(2,50),
                new Job(2,60),
                new Job(3,20),
                new Job(3,30)
        ));
        System.out.println(maxProfit(jobs));

        jobs = new ArrayList<>(Arrays.asList(
                new Job(2,100),
                new Job(1,50),
                new Job(2,10),
                new Job(1,20),
                new Job(3,30)
        ));
        System.out.println(maxProfit(jobs));
    }
    public static int maxProfit(List<Job> jobs){
        List<Job> sortedList = jobs.stream()
                .sorted((j1,j2)->{
                    if(j1.deadline==j2.deadline) return j2.profit-j1.profit;
                    else return j1.deadline-j2.deadline;
                }).collect(Collectors.toList());
        //System.out.println(jobs);
        //System.out.println(sortedList);
        int res = 0;
        int time = 0;
        for(int i=0;i<sortedList.size();i++){
            if(sortedList.get(i).deadline>time){
                res+=sortedList.get(i).profit;
                time++;
            }
        }
        return res;
    }

    private static class Job {
        int deadline;
        int profit;

        public Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job(" +
                    deadline +
                    "," + profit +
                    ')';
        }
    }
}
