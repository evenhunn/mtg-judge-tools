package no.mtgjudgetool.tournament.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by hanseeve on 25.08.2018.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {
    private Long id;
    private List<String> judgeList;
    private List<String> playerList;
}
