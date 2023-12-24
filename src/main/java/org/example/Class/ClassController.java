package org.example.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/api/timetable")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping()
    public List<ClassDTO> getFilteredClasses(
            @RequestParam(name = "key", required = false) String key,
            @RequestParam(name = "value", required = false) String value) {
        List<Class> classes = new ArrayList<>();
        if (key != null && value != null) {
            switch (key) {
                case "group":
                    classes =  classService.getFilteredClasses(value, null, null);
                    break;
                case "professor":
                    classes =  classService.getFilteredClasses(null, value, null);
                    break;
                case "classroom":
                    classes = classService.getFilteredClasses(null, null, value);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown key: " + key);
            }
            List<ClassDTO> response = new ArrayList<>();
            for(int i = 1; i <=6; i++){
                response.add(convertToClassDTO(classes, i));
            }
            return response;
        } else {
            // Handle the case when key or value is null
            throw new IllegalArgumentException("Both key and value must be provided.");
        }
    }
    private ClassDTO convertToClassDTO(List<Class> entity, Integer day) {
        ClassDTO classDTO = new ClassDTO();
        classDTO.setDay(day);
        for(Class c : entity){
           if(c.getDayOfWeek().equals(day)){
               classDTO.courses.add(c);
           }
        }
        return classDTO;
    }
    @PatchMapping("/{id}")
    public Map<String, String> updateClass(@RequestBody Class updatedClass) {
        return classService.updateClass(updatedClass);
    }

    @PatchMapping("/update/{id}")
    public void save(@RequestBody Class updatedClass) {
        classService.save(updatedClass);
    }
}
