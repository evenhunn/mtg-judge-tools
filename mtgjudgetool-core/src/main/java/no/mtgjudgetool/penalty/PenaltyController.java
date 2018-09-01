package no.mtgjudgetool.penalty;

import no.mtgjudgetool.penalty.domain.Penalty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by hanseeve on 22.08.2018.
 */
@RestController
@RequestMapping("/penalty")
public class PenaltyController {

    @Autowired
    private PenaltyService penaltyService;

    @GetMapping("/all")
    public ResponseEntity<List<Penalty>> getAllPenalties(
            @RequestParam(value = "tournamentid") Long tournamentId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(penaltyService.getAllPenalties(tournamentId));
    }

    @PostMapping("/create")
    public ResponseEntity<String> addPenalty(
            @RequestParam(value = "tournamentid") Long tournamentId,
            @RequestBody Penalty penalty
    ) throws IOException {
        penaltyService.add(tournamentId, penalty);
        return ResponseEntity.status(HttpStatus.OK).body("created");
    }

}
