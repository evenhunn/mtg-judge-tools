package no.mtgjudgetool.penalty.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * Created by hanseeve on 22.08.2018.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Penalty {

    @Id
    private Long id;

    private Long tournamentId;
    private Integer round;
    private String player;
    private String opponent;
    private InfractionType infractionType;
    private InfractionSubType infractionSubType;
    private String judge;
}
