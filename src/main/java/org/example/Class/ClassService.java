package org.example.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
    public void save(Class c){
        classRepository.save(c);
    }
    public List<Class> getFilteredClasses(String group, String professor, String classroom) {
        return classRepository.findByGroupAndProfessorAndClassroom(group, professor, classroom);
    }
    public Map<String, String> updateClass(Class updatedClass) {
        // Rule 1: Check if the new teacher is available at the specified day and period
        Map<String, String> response = new HashMap<>();
        response.put("status","");
        response.put("message","");
        if(validateTeacherAvailability(updatedClass)){
            response.put("status", "error");
            response.put("message", response.get("status") + "Teacher is not available at the specified day and period");
        }
        else if(validateClassroomAvailability(updatedClass)){
            response.put("status", "error");
            response.put("message", response.get("status") + "Class Room is not available at the specified day and period");
        }
        // Rule 3: Check if the new day and period are available for the group and teacher
        else if(validateDayAndPeriodAvailability(updatedClass)){
            response.put("status", "error");
            response.put("message", response.get("status") + "Day and period are not available for student and teacher");
        }
        else{
            response.put("status", "success");
            response.put("message", "success");
        }
        return response;
        // If all validations pass, update the class

    }

    private boolean validateTeacherAvailability(Class updatedClass) {
        // Your logic to check if the new teacher has other lessons at the same day and period
        List<Class> teacherSchedule = classRepository.findByProfessorAndDayOfWeekAndPeriod(
                updatedClass.getProfessor(),
                updatedClass.getDayOfWeek(),
                updatedClass.getPeriod());

        // Check if the teacher has other lessons at the same day and period
        teacherSchedule.removeIf(c -> c.getClassId().equals(updatedClass.getClassId()));
        return teacherSchedule.isEmpty();
    }

    private boolean validateClassroomAvailability(Class updatedClass) {
        // Your logic to check if the new classroom is available at the same day and period
        List<Class> classroomSchedule = classRepository.findByClassroomAndDayOfWeekAndPeriod(
                updatedClass.getClassroom(),
                updatedClass.getDayOfWeek(),
                updatedClass.getPeriod());

        // Check if the classroom is used at the same day and period
        classroomSchedule.removeIf(c -> c.getClassId().equals(updatedClass.getClassId()));
        return classroomSchedule.isEmpty();
    }

    private boolean validateDayAndPeriodAvailability(Class updatedClass) {
        // Your logic to check if the new day and period are available for the group and teacher
        List<Class> groupAndTeacherSchedule = classRepository.findByGroupAndProfessorAndDayOfWeekAndPeriod(
                updatedClass.getGroup(),
                updatedClass.getProfessor(),
                updatedClass.getDayOfWeek(),
                updatedClass.getPeriod());

        // Check if the group and teacher have other lessons at the same day and period
        groupAndTeacherSchedule.removeIf(c -> c.getClassId().equals(updatedClass.getClassId()));
        return groupAndTeacherSchedule.isEmpty();
    }
}
