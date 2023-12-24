package org.example.Class;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {
    List<Class> findByGroupAndProfessorAndClassroom(String group, String professor, String classroom);
    List<Class> findByProfessorAndDayOfWeekAndPeriod(String professor, Integer dayOfWeek, Integer period);

    List<Class> findByClassroomAndDayOfWeekAndPeriod(String classroom, Integer dayOfWeek, Integer period);

    List<Class> findByGroupAndProfessorAndDayOfWeekAndPeriod(String studentGroup, String professor, Integer dayOfWeek, Integer period);
}
