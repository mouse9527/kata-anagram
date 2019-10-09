package com.mouse;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.primitives.Chars;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Anagram {
    private static final String ANAGRAM_WORD = "documenting";
    private static final Set<Character> TARGETS = Sets.newHashSet('d', 'o', 'c', 'u', 'm', 'e', 'n', 't', 'i', 'g');
    private static final List<Character> SORTED_ANAGRAM_CHARS = Lists.charactersOf(ANAGRAM_WORD).stream().sorted().collect(Collectors.toList());

    List<String> filter(List<String> wordList) {
        return wordList.stream()
                .filter(this::allCharsInTarget)
                .collect(Collectors.toList());
    }

    private boolean allCharsInTarget(String word) {
        return Chars.asList(word.toLowerCase().toCharArray()).stream().distinct().allMatch(TARGETS::contains);
    }

    boolean match(String word1, String word2) {
        List<Character> current = Lists.charactersOf(String.format("%s%s", word1, word2).toLowerCase())
                .stream().sorted().collect(Collectors.toList());
        return SORTED_ANAGRAM_CHARS.equals(current);
    }
}