package org.example.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Subject {
    int id;
    String unitateCurs;
    int teorie;
    int practica;
    int lab;
    int total;
    int anul;
    int semestru;
}
