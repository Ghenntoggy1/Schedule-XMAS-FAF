package org.example.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.Cabinet;
import org.example.entities.Group;
import org.example.entities.Subject;
import org.example.entities.Teacher;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleEntry {
    private Group group;
    private Subject subject;
    private Teacher teacher;
    private Cabinet cabinet;


}
