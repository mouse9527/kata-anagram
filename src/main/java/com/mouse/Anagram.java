package com.mouse;

import com.google.common.collect.Lists;
import com.google.common.primitives.Chars;

import java.util.List;
import java.util.stream.Collectors;

class Anagram {
    private static final String ANAGRAM_WORD = "documenting";
    private static final List<Character> TARGETS = Lists.newArrayList('d', 'o', 'c', 'u', 'm', 'e', 'n', 't', 'i', 'g');

    List<String> filter(List<String> wordList) {
        return wordList.stream()
                .filter(this::allCharsInTarget)
                .collect(Collectors.toList());
    }

    private boolean allCharsInTarget(String word) {
        return Chars.asList(word.toCharArray()).stream().distinct().allMatch(TARGETS::contains);
    }
}
