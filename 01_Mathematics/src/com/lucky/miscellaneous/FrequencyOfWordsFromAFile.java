package com.lucky.miscellaneous;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencyOfWordsFromAFile {
	public static void main(String[] args) throws IOException {
		//File file = new File("sample.txt");
		//System.out.println("this....".matches("[A-za-z]+"));
		Map<String,Long> wordCounts = Files.lines(Paths.get("D:\\DSA\\Mathematics\\src\\com\\lucky\\miscellaneous\\sample.txt"))
			.flatMap(line -> Arrays.stream(line.split("\\s+")))
			.collect(Collectors.groupingBy(word->{
				
				return word.toLowerCase().replaceAll("(^[^A-Za-z]+)|([^A-Za-z]+$)","");//.replaceAll("([^A-Za-z]+$)", "");
				//return word;
			}
			//word.toLowerCase().replaceAll("[^A-Za-z]", "")
			,Collectors.counting()));
		System.out.println(wordCounts);
		
		Files.lines(Paths.get("D:\\DSA\\Mathematics\\src\\com\\lucky\\miscellaneous\\sample.txt"))
				.flatMap(line -> Arrays.stream(line.split("\\s+")))
				.mapToInt(word->word.chars().findFirst().getAsInt())
				.forEach(c->System.out.print((char)c));
		
		System.out.println();
		
		Files.lines(Paths.get("D:\\DSA\\Mathematics\\src\\com\\lucky\\miscellaneous\\sample.txt"))
		.flatMap(line -> Arrays.stream(line.split("\\s+")))
		.flatMapToInt(word->word.chars())
		.forEach(c->System.out.print((char)c));
		
		
				//.flatMapToInt(word->Arrays.stream(word.toCharArray()))
				//.forEach(c->System.out.println((char)c));
//		try(BufferedReader br = new BufferedReader(new FileReader(file))){
//			br.re
//		}
//		catch (Exception e) {
//
//		}
	}
}
