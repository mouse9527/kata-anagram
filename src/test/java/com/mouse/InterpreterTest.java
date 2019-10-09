package com.mouse;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InterpreterTest {

    @Test
    public void should_read_word_list_from_file_correctly() {
        assertThat(new Interpreter().readWordList("wordlist.txt").size(), is(1633));
    }

    @Test
    public void should_puzzle_correctly() {
        assertThat(new Interpreter().puzzle(getWordList()), is(getExpected()));
    }

    private ArrayList<Pair<String, String>> getExpected() {
        return Lists.newArrayList(Pair.of("uetnno", "cdmgi"),
                Pair.of("uetnno", "cdmig"),
                Pair.of("uetnno", "dcmgi"));
    }

    private List<String> getWordList() {
        return Lists.newArrayList("uetnno", "cdmgi", "cdmig", "uetno", "uetnnoo", "dcmgi");
    }
}