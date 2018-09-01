package no.mtgjudgetool.tournament;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.mtgjudgetool.tournament.domain.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by hanseeve on 22.08.2018.
 */
@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Long createTournament(String tournamentJson) throws IOException {
        Tournament tournament = objectMapper.readValue(tournamentJson, Tournament.class);
        tournament.setId(1L);
        tournamentRepository.save(tournament);
        return tournament.getId();
    }
}
