package org.example.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    private Map<TimeSlot, ScheduleEntry> scheduleEntries;

    public void addScheduleEntry(TimeSlot timeSlot, ScheduleEntry scheduleEntry) {
        scheduleEntries.put(timeSlot, scheduleEntry);
    }

}
