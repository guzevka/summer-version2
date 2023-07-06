package ru.summerversion2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.summerversion2.repositories.TeamRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamService {
    TeamRepository teamRepository;
}
