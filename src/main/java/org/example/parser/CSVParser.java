package org.example.parser;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

public class CSVParser {
    private static final String folderPath
            = "D:\\Programming\\Projects\\IdeaProjects\\fafXmas-Back\\src\\main\\java\\org\\example\\ExampleData\\";
    private final String groupsFilePath
            = folderPath + "Groups and Subjects (FAF Hack) - Grupe.csv";
    private final String professorsFilePath
            = folderPath + "Groups and Subjects (FAF Hack) - Profesori.csv";
    private final String subjectsFilePath
            = folderPath + "Groups and Subjects (FAF Hack) - Subiecte.csv";
    private final String cabinetsFilePath
            = folderPath + "Groups and Subjects (FAF Hack) - Cabinete.csv";

    public List<String[]> readGroupsData() {
        try {
            FileReader filereader = new FileReader(this.groupsFilePath);

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
