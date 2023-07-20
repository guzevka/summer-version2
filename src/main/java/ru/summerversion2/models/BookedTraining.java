package ru.summerversion2.models;

import jakarta.persistence.*;
import lombok.Data;
// Бронирование свободного окна на тренировку
@Entity
@Table(name = "booked_trainings")
@Data
public class BookedTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "\"user\"")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "training")
    private Training training;
}
