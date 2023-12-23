package org.example.groups;


import jakarta.persistence.*;
import org.example.courses.Course;

@Entity
@Table(name = "group_course")
public class GroupCourse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group_id;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course_id;


}
