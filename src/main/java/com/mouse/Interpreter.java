package com.mouse;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.base.Charsets.UTF_8;

class Interpreter {
    @SuppressWarnings("UnstableApiUsage")
    List<String> readWordList(String resourceName) {
        URL resource = Resources.getResource(resourceName);
        List<String> lines;
        try {
            lines = Resources.readLines(resource, UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("读取文件出错！");
        }
        List<String> result = Lists.newArrayList();
        lines.forEach(x -> {
            String[] split = x.split(" ");
            for (String str : split) {
                String word = str.trim();
                if (StringUtils.isEmpty(word))
                    continue;
                result.add(word);
            }
        });
        return result;
    }

    List<Pair<String, String>> puzzle(List<String> wordList) {
        Anagram anagram = new Anagram();
        List<String> filteredWordList = anagram.filter(wordList);
        List<Pair<String, String>> result = Lists.newArrayList();
        int size = filteredWordList.size();
        for (int i = 0; i < size; i++) {
            for (int y = i + 1; y < size; y++) {
                String word1 = filteredWordList.get(i);
                String word2 = filteredWordList.get(y);
                if (anagram.match(word1, word2)) {
                    result.add(Pair.of(word1, word2));
                }
            }
        }
        return result;
    }
}
