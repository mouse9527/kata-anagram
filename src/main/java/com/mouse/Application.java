package com.mouse;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Interpreter interpreter = new Interpreter();
        List<String> wordList = interpreter.readWordList("wordlist.txt");
        List<Pair<String, String>> solution = interpreter.puzzle(wordList);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        solution.forEach(System.out::println);
    }
}
