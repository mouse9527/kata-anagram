package com.mouse;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnagramTest {

    @Test
    public void should_filter_word_list_correctly() {
        assertThat(new Anagram().filter(getWorkList()), is(Collections.singletonList("docume")));
    }

    private List<String> getWorkList() {
        return Lists.newArrayList("docume", "documendfting");
    }

    @Test
    public void should_match_words_correctly() {
        assertThat(new Anagram().match("uetnno", "cdmgi"), is(true));
        assertThat(new Anagram().match("uetno", "cdmig"), is(false));
        assertThat(new Anagram().match("uetnnoo", "cdmgi"), is(false));
    }
}
