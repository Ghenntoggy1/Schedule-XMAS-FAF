package org.example;

import org.example.entities.Cabinet;
import org.example.entities.Group;
import org.example.entities.Subject;
import org.example.entities.Teacher;
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
        List<Cabinet> cabinetData = csvParser.readCabinetsData();
        for (Cabinet cabinet : cabinetData) {
            System.out.println(cabinet);
        }
        List<Teacher> teacherData = csvParser.readProfessorsData();
        for (Teacher teacher : teacherData) {
            System.out.println(teacher);
        }
    }
}