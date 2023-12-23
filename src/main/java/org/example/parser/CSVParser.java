package org.example.parser;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.entities.Group;
import org.example.entities.Subject;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParser {
    private static final String folderPath
            = "D:\\Programming\\Projects\\IdeaProjects\\Hackathons\\Schedule-XMAS-FAF\\src\\main\\java\\org\\example\\ExampleData\\";
    private final String groupsFilePath
            = folderPath + "Groups and Subjects (FAF Hack) - Grupe.csv";
    private final String professorsFilePath
            = folderPath + "Groups and Subjects (FAF Hack) - Profesori.csv";
    private final String subjectsFilePath
            = folderPath + "Groups and Subjects (FAF Hack) - Subiecte.csv";
    private final String cabinetsFilePath
            = folderPath + "Groups and Subjects (FAF Hack) - Cabinete.csv";

    public List<Group> readGroupsData() {
        try {
            FileReader filereader = new FileReader(this.groupsFilePath);

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<Group> allData = new ArrayList<>();

            String[] headers = {"id", "speciality", "language", "nrPersons", "subjectIds"};

            List<String[]> rows = csvReader.readAll();
            for (String[] row : rows) {
                System.out.println(Arrays.stream(row).toList());
                Group group = new Group();
                for (int i = 0; i < headers.length; i++) {
                    String header = headers[i];
                    switch (header) {
                        case "id" -> group.setId(Integer.parseInt(row[i]));
                        case "speciality" -> group.setSpeciality(row[i]);
                        case "language" -> group.setLanguage(row[i]);
                        case "nrPersons" -> group.setNrPersons(Integer.parseInt(row[i]));
                        case "subjectIds" -> {
                            String[] subjectIds = row[i].split(",");
                            List<Integer> subjectIdList = new ArrayList<>();
                            for (String subjectId : subjectIds) {
                                subjectIdList.add(Integer.parseInt(subjectId));
                            }
                            group.setSubjectIds(subjectIdList);
                        }
                        default -> {}
                    }
                }
                allData.add(group);
            }

            filereader.close();
            return allData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Subject> readSubjectsData() {
        try {
            FileReader filereader = new FileReader(this.subjectsFilePath);

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<Subject> allData = new ArrayList<>();

            String[] headers = {"id", "unitate_curs", "teorie", "practica", "lab", "TOTAL", "anul", "semestru"};

            List<String[]> rows = csvReader.readAll();
            for (String[] row : rows) {
                System.out.println(Arrays.stream(row).toList());
                Subject subject = new Subject();
                for (int i = 0; i < headers.length; i++) {
                    String header = headers[i];
                    switch (header) {
                        case "id" -> subject.setId(Integer.parseInt(row[i]));
                        case "unitate_curs" -> subject.setUnitateCurs(row[i]);
                        case "teorie" -> subject.setTeorie(Integer.parseInt(row[i]));
                        case "practica" -> subject.setPractica(Integer.parseInt(row[i]));
                        case "lab" -> subject.setLab(Integer.parseInt(row[i]));
                        case "TOTAL" -> {
                            try {
                                subject.setTotal(Integer.parseInt(row[i]));
                            }
                            catch (NumberFormatException numberFormatException) {
                                subject.setTotal(0);
                            }
                        }
                        case "anul" -> subject.setAnul(Integer.parseInt(row[i]));
                        case "semestru" -> {
                            int[] years = Arrays.stream(row[i].split(","))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
                            subject.setSemestru(years);
                        }
                        default -> {}
                    }
                }
                allData.add(subject);
            }

            filereader.close();
            return allData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String[]> readCabinetsData() {
        try {
            FileReader filereader = new FileReader(this.cabinetsFilePath);

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
            filereader.close();
            return allData;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String[]> readProfessorsData() {
        try {
            FileReader filereader = new FileReader(this.professorsFilePath);

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
            filereader.close();
            return allData;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
