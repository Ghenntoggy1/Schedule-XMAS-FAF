package org.example.Class;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {
    @Query("SELECT c FROM Class c WHERE (:group IS NULL OR c.group = :group) AND (:professor IS NULL OR c.professor = :professor) AND (:classroom IS NULL OR c.classroom = :classroom)")
    List<Class> findByGroupAndProfessorAndClassroom(
            @Param("group") String group,
            @Param("professor") String professor,
            @Param("classroom") String classroom
    );
    List<Class> findByProfessorAndDayOfWeekAndPeriod(String professor, Integer dayOfWeek, Integer period);

    List<Class> findByClassroomAndDayOfWeekAndPeriod(String classroom, Integer dayOfWeek, Integer period);

    List<Class> findByGroupAndProfessorAndDayOfWeekAndPeriod(String studentGroup, String professor, Integer dayOfWeek, Integer period);
}
