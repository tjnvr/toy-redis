package com.github.tjnvr.config;

import lombok.RequiredArgsConstructor;
import lombok.val;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RequiredArgsConstructor
public class RedisConfigLoader {

    private final String absoluteConfigurationPath;
    private final LineParser lineParser;

    public Config load() {
        try {
            val configBuilder = Config.builder();
            Files.readAllLines(Path.of(absoluteConfigurationPath)).forEach(line -> populate(line, configBuilder));
            return configBuilder.build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void populate(String line, Config.ConfigBuilder configBuilder) {
        val configEntry = lineParser.parse(line);
        if (configEntry == null) {
            return;
        }
        if (configEntry.keyWord().equals("port")) {
            if (configEntry.arguments().size() != 1) {
                throw new IllegalArgumentException("Expected one single argument for port got %d: %s".formatted(configEntry.arguments().size(), String.join("", configEntry.arguments())));
            }

            configBuilder.Port(Integer.parseInt(configEntry.arguments().getFirst()));
        }
    }
}
