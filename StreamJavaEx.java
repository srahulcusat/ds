package com.test;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamJavaEx {
    public static void main(String[] args) {

        /*
        //TODO: Find the first distinct character from string

        String input = "aabccdeff";
        Character firstUnique = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

        System.out.println(firstUnique);
        */


        /*
        //TODO: Find the count of consonants and vowels in string

        String countVowelAndConsonants = "interview";
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        long counts = countVowelAndConsonants.chars()
                .mapToObj(c -> (char) c)
                .filter(vowels::contains)
                .count();


        System.out.println(countVowelAndConsonants.length() - counts);
        */

        /*
        //TODO: Reverse the words in a sentence without reversing the words themselves.
        //Main point convertion to list then to revers using collections and then join using Collectors

        String input = "Java is fun"; //output should be "fun is Java"
        List<String> list = Arrays.asList(input.split(" "));
        Collections.reverse(list);

        String output = list.stream().collect(Collectors.joining(" "));

        System.out.println(output);
        */

        /*
        //TODO: Determine if two strings are anagrams
        //Main points use of Arrays.equals & chars.sorted().toArray

        String s1 = "listen";
        String s2 = "silent";

        boolean isAnagram = Arrays.equals(s1.chars().sorted().toArray(),s2.chars().sorted().toArray());
        System.out.println(isAnagram);
        */

        //TODO: Find the most frequent character in a string.

        String input = "aabccdefff";

        Character mostFrequent =  input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);


        System.out.println(mostFrequent);



    }
}