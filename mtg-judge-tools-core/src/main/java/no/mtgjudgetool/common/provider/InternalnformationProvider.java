package no.mtgjudgetool.common.provider;

import no.mtgjudgetool.penalty.domain.InfractionType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanseeve on 01.09.2018.
 */
@RestController
@RequestMapping("/internal")
public class InternalnformationProvider {
    @GetMapping("/infractiontypes")
    InfractionType[] getInfractionTypes() {
        return InfractionType.values();
    }
}
