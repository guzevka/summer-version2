package ru.summerversion2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.summerversion2.models.Training;
import ru.summerversion2.repositories.TrainingRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public Training getTrainingById(Long id){
        return trainingRepository.getById(id);
    }



}
