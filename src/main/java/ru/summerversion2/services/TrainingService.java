package ru.summerversion2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.summerversion2.models.Training;
import ru.summerversion2.repositories.TrainingRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrainingService {
  /*  private final TrainingRepository trainingRepository;

    public Training findTrainingById(Long id){
        return trainingRepository.getById(id);
    }

    public List<Training> findAll() {
        return trainingRepository.findAll();
    }

    public void save(Training training){
        trainingRepository.save(training);
        log.info("saving new {}", training);
    }

    public void delete(Long id){
        trainingRepository.deleteById(id);
    }*/
}
