package org.example.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/timetable")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping()
    public List<Class> getFilteredClasses(
            @RequestParam(name = "group", required = false) String group,
            @RequestParam(name = "professor", required = false) String professor,
            @RequestParam(name = "classroom", required = false) String classroom) {
        return classService.getFilteredClasses(group, professor, classroom);
    }
    @PatchMapping("/{id}")
    public Map<String, String> updateClass(@RequestBody Class updatedClass) {
        return classService.updateClass(updatedClass);
    }
}
