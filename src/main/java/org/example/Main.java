package org.example;

import org.example.entities.Group;
import org.example.entities.Subject;
import org.example.parser.CSVParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser();

        List<Group> groupData = csvParser.readGroupsData();
        for (Group group : groupData) {
            System.out.println(group);
        }
        List<Subject> subjectData = csvParser.readSubjectsData();
        for (Subject subject : subjectData) {
            System.out.println(subject);
        }
    }
}