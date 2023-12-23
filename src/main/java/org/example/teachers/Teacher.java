package org.example.teachers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String course;
    String type;
    @Transient
    boolean[][] availability;
    @Column(name = "availability")
    String availabilityJson;

    public void setAvailability(boolean[][] availability) {
        this.availability = availability;
        try{
            this.availabilityJson = new ObjectMapper().writeValueAsString(availability);
        } catch (JsonProcessingException e) {
            this.availabilityJson = "[]";
        }
    }

    @PostLoad
    private void postLoad(){
        try{
            this.availability = new ObjectMapper().readValue(this.availabilityJson, boolean[][].class);
        } catch (JsonProcessingException e) {
            this.availability = new boolean[0][0];
        }
    }
}
