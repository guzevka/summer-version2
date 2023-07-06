package ru.summerversion2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.summerversion2.repositories.TournamentRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class TournamentService {
    TournamentRepository tournamentRepository;
}
