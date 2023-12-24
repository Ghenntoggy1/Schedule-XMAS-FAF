package org.example.groups;


import jakarta.persistence.*;
import org.example.courses.Course;

@Entity
@Table(name = "GroupCourse")
public class GroupCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
     Group group_id;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
     Course course_id;


}
