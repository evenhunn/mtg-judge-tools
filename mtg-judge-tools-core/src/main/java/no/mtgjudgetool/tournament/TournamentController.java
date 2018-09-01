package no.mtgjudgetool.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by hanseeve on 22.08.2018.
 */
@RestController
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @PostMapping("/create")
    public String createTournament(
            @RequestBody String tournamentJson
    ) {
        Long id = null;
        try
            id = tournamentService.createTournament(tournamentJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "tournament created with id: " + id;
    }
}
