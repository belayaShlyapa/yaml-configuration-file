package com.example.yamlConfigurationFile.config.exampleList;

import com.example.yamlConfigurationFile.config.exampleList.firstOne.FirstOne;
import com.example.yamlConfigurationFile.config.exampleList.secondOne.SecondOne;

import java.util.List;

public class ExampleList {
    private List<FirstOne> firstOne;
    private List<SecondOne> secondOne;

    public List<FirstOne> getFirstOne() {
        return firstOne;
    }

    public List<SecondOne> getSecondOne() {
        return secondOne;
    }
}