package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Teacher {
    int id;
    String name;
    String subject;
    String type;
    boolean[][] availability;
}
