package ru.summerversion2.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "participants")
@Data
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="\"user\"")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Team team;
}
