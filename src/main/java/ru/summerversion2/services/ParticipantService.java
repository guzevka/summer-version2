package ru.summerversion2.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.summerversion2.models.Participant;
import ru.summerversion2.models.Team;
import ru.summerversion2.models.User;
import ru.summerversion2.repositories.ParticipantRepository;
import ru.summerversion2.repositories.TeamRepository;
import ru.summerversion2.repositories.UserRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParticipantService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final ParticipantRepository participantRepository;
    public void addParticipantToTeam(Participant participant){
        Participant existingParticipant = participantRepository.findParticipantByTeamIdAndUserId(participant.getTeam().getId(),participant.getUser().getId());

        if(existingParticipant == null){

            participant.setTeam(teamRepository.getTeamById(participant.getTeam().getId()));
            participant.setUser(userRepository.findById(participant.getUser().getId()).orElse(null));

            participantRepository.save(participant);

        } else {
            throw new IllegalArgumentException("error");
        }
    }

    public List<Participant> getParticipantsByTeamId(Long teamId) {
        return participantRepository.findByTeamId(teamId);
    }

}
