package com.mouse;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InterpreterTest {

    @Test
    public void should_read_word_list_from_file_correctly() throws IOException {
        assertThat(new Interpreter().readWordList("wordlist.txt").size(), is(1633));
    }

}