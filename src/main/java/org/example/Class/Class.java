package org.example.Class;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


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
    private Integer dayOfWeek;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Class aClass)) return false;
        return Objects.equals(getClassId(), aClass.getClassId()) && Objects.equals(getDayOfWeek(), aClass.getDayOfWeek()) && Objects.equals(getPeriod(), aClass.getPeriod()) && Objects.equals(getCourseName(), aClass.getCourseName()) && Objects.equals(getGroup(), aClass.getGroup()) && Objects.equals(getType(), aClass.getType()) && Objects.equals(getClassroom(), aClass.getClassroom()) && Objects.equals(getProfessor(), aClass.getProfessor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClassId(), getDayOfWeek(), getPeriod(), getCourseName(), getGroup(), getType(), getClassroom(), getProfessor());
    }
}
