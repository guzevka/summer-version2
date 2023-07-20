package ru.summerversion2.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "trainings")
@Data
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    // длительность тренировки (в часах)
    @Column(name = "duration")
    private String duration;
    @Column(name = "location")
    private String location;
}
