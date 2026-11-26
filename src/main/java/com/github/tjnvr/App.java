package com.github.tjnvr;

import com.github.tjnvr.config.DefaultLineParser;
import com.github.tjnvr.config.RedisConfigLoader;
import lombok.extern.log4j.Log4j2;
import lombok.val;

import java.io.File;

@Log4j2
public class App {
    public static void main(String[] args) {
        val unused = new RedisConfigLoader(
                new File("src/main/resources/redis.conf").getAbsolutePath(),
                new DefaultLineParser()
        ).load();
        log.info("configuration loaded");
    }
}
