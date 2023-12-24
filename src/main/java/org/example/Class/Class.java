package org.example.Class;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClassID")
    private Integer classId;

    @Column(name = "DayOfWeek")
    private Integer day;

    @Column(name = "Period")
    private Integer period;

    @Column(name = "CourseName")
    private String courseName;
    @Column(name = "[Group]")
    private String group;

    @Column(name = "ClassType")
    private String type;

    @Column(name = "Classroom")
    private String classroom;

    @Column(name = "Professor")
    private String professor;
}
