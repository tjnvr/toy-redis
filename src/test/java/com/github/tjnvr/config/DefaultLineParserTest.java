package com.github.tjnvr.config;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultLineParserTest {

    @Test
    void shouldReturnNullWhenNoKeyWords() {
        // given
        var line = "# this is a beautiful comment";

        // setup
        val parser = new DefaultLineParser();

        // test
        val configEntry = parser.parse(line);

        // expect
        assertThat(configEntry).isNull();
    }

    @Test
    void shouldParseAnyNumberOfArguments() {
        // given
        val keyWord = UUID.randomUUID().toString();
        val numberArguments = ThreadLocalRandom.current().nextInt(1, 10);
        String[] arguments = new String[numberArguments];
        for (var i = 0; i < numberArguments; i++) {
            arguments[i] = UUID.randomUUID().toString();
        }
        val line = String.join(" ", keyWord, String.join(" ", arguments));

        // given
        val parser = new DefaultLineParser();

        // test
        val configEntry = parser.parse(line);

        // expect
        assertThat(configEntry.keyWord()).isEqualTo(keyWord);
        assertThat(configEntry.arguments()).hasSameElementsAs(Arrays.asList(arguments));
    }

    @Test
    void shouldIgnoreLineWithNoArguments(){
        // given
        val line = UUID.randomUUID().toString();

        // setup
        val parser = new DefaultLineParser();

        // test
        val configEntry = parser.parse(line);

        // expect
        assertThat(configEntry).isNull();
    }
}