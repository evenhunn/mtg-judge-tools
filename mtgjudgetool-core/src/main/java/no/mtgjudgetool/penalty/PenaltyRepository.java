package no.mtgjudgetool.penalty;

import no.mtgjudgetool.penalty.domain.Penalty;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by hanseeve on 22.08.2018.
 */
public interface PenaltyRepository extends MongoRepository<Penalty, String> {
    List<Penalty> findAllByTournamentId(Long tournamentId);
}
