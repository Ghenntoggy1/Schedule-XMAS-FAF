package org.example.courses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.groups.Group;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    String name;
    Integer theoryNrLessons;
    Integer practiceNrLessons;
    Integer labNrLessons;
    Integer year;
    Integer semester;
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Group> groups;

}
