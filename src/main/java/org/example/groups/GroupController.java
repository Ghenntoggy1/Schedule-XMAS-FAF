package org.example.groups;

import org.example.courses.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping()
    public ResponseEntity<List<GroupDTO>> getGroups(){
        return new ResponseEntity<>(groupService.getGroupsDTO(), HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<List<Course>>> getCoursesByGroup() {
        List<List<Course>> courses = new ArrayList<>();
        List<Group> groups = groupService.getGroups();
        for (Group group : groups) {
            courses.add(group.getCourses());
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
