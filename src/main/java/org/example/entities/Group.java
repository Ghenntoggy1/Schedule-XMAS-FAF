package org.example.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    int id;
    String speciality;
    String language;
    int nrPersons;
    List<Integer> subjectIds;
}
