package org.example.classrooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping
    public ResponseEntity<List<Classroom>> getAllClassrooms() {
        return new ResponseEntity<>(classroomService.getAllClassrooms(), HttpStatus.OK);
    }
}
