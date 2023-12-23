package org.example.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot {
    private int day;  // e.g., Monday is 1, Tuesday is 2, etc.
    private int period;  // e.g., first period is 1, second period is 2, etc.
}
