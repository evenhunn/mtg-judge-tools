package no.mtgjudgetool.penalty;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.mtgjudgetool.penalty.domain.Penalty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by hanseeve on 22.08.2018.
 */
@Service
public class PenaltyService {

    @Autowired
    private PenaltyRepository penaltyRepository;

    public List<Penalty> getAllPenalties(Long tournamentId) {
        List<Penalty> penaltyList = penaltyRepository.findAllByTournamentId(tournamentId);
        return penaltyList;
    }

    public void add(Long tournamentId, Penalty penalty) throws IOException {
        penalty.setTournamentId(tournamentId);
        penaltyRepository.save(penalty);
    }
}
