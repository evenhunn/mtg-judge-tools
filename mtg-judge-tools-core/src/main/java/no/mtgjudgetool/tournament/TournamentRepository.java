package no.mtgjudgetool.tournament;

import no.mtgjudgetool.tournament.domain.Tournament;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by hanseeve on 25.08.2018.
 */
public interface TournamentRepository extends MongoRepository<Tournament, String> {
}
