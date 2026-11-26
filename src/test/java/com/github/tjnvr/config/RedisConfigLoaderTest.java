package com.github.tjnvr.config;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;


class RedisConfigLoaderTest {

    @Test
    void shouldLoadConfig() {
        // given
        String path = "src/test/resources/redis.conf";
        val absPath = new File(path).getAbsolutePath();

        // setup
        val loader = new RedisConfigLoader(absPath, new DefaultLineParser());

        // test
        val config = loader.load();

        // expect
        assertThat(config.Port()).isEqualTo(6379);
    }
}