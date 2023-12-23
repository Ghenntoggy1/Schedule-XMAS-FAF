package org.example;

import org.example.parser.CSVParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser();

        List<String[]> groupData = csvParser.readGroupsData();

    }
}