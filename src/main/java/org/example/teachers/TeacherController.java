package org.example.teachers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private  TeacherService teacherService;

    @GetMapping("")
    public ResponseEntity<List<Teacher>> getTeachers(){
        return new ResponseEntity<>(teacherService.getTeacher(), HttpStatus.OK);
    }
}
