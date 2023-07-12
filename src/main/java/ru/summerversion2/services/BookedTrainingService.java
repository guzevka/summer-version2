package ru.summerversion2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.summerversion2.models.BookedTraining;
import ru.summerversion2.repositories.BookedTrainingRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookedTrainingService {
    private final BookedTrainingRepository bookedTrainingRepository;
    public BookedTraining findById(Long id){
        return bookedTrainingRepository.findById(id).orElse(null);
    }
    public void save(BookedTraining bookedTraining){
        bookedTrainingRepository.save(bookedTraining);
    }
}
