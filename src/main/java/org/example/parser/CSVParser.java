package org.example.parser;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.entities.Cabinet;
import org.example.entities.Group;
import org.example.entities.Subject;
import org.example.entities.Teacher;

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

    public List<Cabinet> readCabinetsData() {
        try {
            FileReader filereader = new FileReader(this.cabinetsFilePath);

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<Cabinet> allData = new ArrayList<>();

            String[] headers = {"id", "is_lab_cab", "nr_persons"};

            List<String[]> rows = csvReader.readAll();
            for (String[] row : rows) {
                System.out.println(Arrays.stream(row).toList());
                Cabinet cabinet = new Cabinet();
                for (int i = 0; i < headers.length; i++) {
                    String header = headers[i];
                    switch (header) {
                        case "id" -> cabinet.setId(row[i]);
                        case "is_lab_cab" -> cabinet.setLabCab(Boolean.parseBoolean(row[i]));
                        case "nr_persons" -> {
                            try {
                                cabinet.setNrPersons(Integer.parseInt(row[i]));
                            }
                            catch (NumberFormatException numberFormatException) {
                                cabinet.setNrPersons(25);
                            }
                        }
                        default -> {}
                    }
                }
                allData.add(cabinet);
            }

            filereader.close();
            return allData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Teacher> readProfessorsData() {
        try {
            FileReader filereader = new FileReader(this.professorsFilePath);

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<Teacher> allData = new ArrayList<>();

            String[] headers = {"id", "name", "subject", "type",
                    "mon_per_1", "mon_per_2", "mon_per_3", "mon_per_4", "mon_per_5", "mon_per_6", "mon_per_7",
                    "tue_per_1", "tue_per_2", "tue_per_3", "tue_per_4", "tue_per_5", "tue_per_6", "tue_per_7",
                    "wed_per_1", "wed_per_2", "wed_per_3", "wed_per_4", "wed_per_5", "wed_per_6", "wed_per_7",
                    "thu_per_1", "thu_per_2", "thu_per_3", "thu_per_4", "thu_per_5", "thu_per_6", "thu_per_7",
                    "fri_per_1", "fri_per_2", "fri_per_3", "fri_per_4", "fri_per_5", "fri_per_6", "fri_per_7",
                    "sat_per_1", "sat_per_2", "sat_per_3", "sat_per_4", "sat_per_5", "sat_per_6", "sat_per_7"};

            List<String[]> rows = csvReader.readAll();
            for (String[] row : rows) {
                Teacher teacher = new Teacher();
                for (int i = 0; i < headers.length; i++) {
                    String header = headers[i];
                    switch (header) {
                        case "id":
                            teacher.setId(Integer.parseInt(row[i]));
                            break;
                        case "name":
                            teacher.setName(row[i]);
                            break;
                        case "subject":
                            teacher.setSubject(row[i]);
                            break;
                        case "type":
                            teacher.setType(row[i]);
                            break;
                        default:
                            // Assuming the remaining headers are for availability
                            int dayIndex = i - 4; // Adjust the index based on the offset of "mon_per_1"
                            int perecheIndex = Integer.parseInt(header.split("_")[2]) - 1;
                            boolean isAvailable = Integer.parseInt(row[i]) == 1;
                            teacher.getAvailability()[dayIndex][perecheIndex] = isAvailable;
                            break;
                    }
                }
                allData.add(teacher);
            }

            filereader.close();
            return allData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
