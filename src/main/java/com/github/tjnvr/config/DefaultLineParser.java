package com.github.tjnvr.config;

import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class DefaultLineParser implements LineParser {

    @Override
    public ConfigEntry parse(String line) {
        if (line.startsWith("#")) {
            return null;
        }

        var split = line.split(" ");
        if (split.length < 2) {
            return null;
        }

        return new ConfigEntry(split[0], List.of(Arrays.copyOfRange(split, 1, split.length)));
    }
}
