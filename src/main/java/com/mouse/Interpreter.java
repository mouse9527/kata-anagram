package com.mouse;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.base.Charsets.UTF_8;

class Interpreter {
    @SuppressWarnings("UnstableApiUsage")
    List<String> readWordList(String resourceName) throws IOException {
        URL resource = Resources.getResource(resourceName);
        List<String> lines = Resources.readLines(resource, UTF_8);
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
}
