package com.example.yamlConfigurationFile;

import com.example.yamlConfigurationFile.config.Config;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Config config = null;
        try {
            config = new ObjectMapper(new YAMLFactory()).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).readValue(new File(args[0]), Config.class);
            System.out.println("Config loaded");
        } catch (IOException err) {
            System.out.println("An error has occurred during configuration file loading");
        }

        if (config != null) {
            System.out.println(config.getExampleValues().getValueOne()); // I am value ONE
            System.out.println(config.getExampleValues().getValueTwo()); // I am value TWO
            System.out.println(config.getExampleList().getFirstOne().get(0).getElement()); // I am element ONE from firstOne list
            System.out.println(config.getExampleList().getFirstOne().get(1).getElement()); // I am element TWO from firstOne list
            System.out.println(config.getExampleList().getSecondOne().get(0).getElement()); // I am element ONE from secondOne list
        }
    }
}