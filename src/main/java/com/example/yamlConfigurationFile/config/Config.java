package com.example.yamlConfigurationFile.config;

import com.example.yamlConfigurationFile.config.exampleList.ExampleList;
import com.example.yamlConfigurationFile.config.exampleValues.ExampleValues;

public class Config {
    private ExampleValues exampleValues;
    private ExampleList exampleList;

    public ExampleValues getExampleValues() {
        return exampleValues;
    }

    public ExampleList getExampleList() {
        return exampleList;
    }
}