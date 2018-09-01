package no.mtgjudgetool.penalty.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * Created by hanseeve on 22.08.2018.
 */
@AllArgsConstructor
public enum InfractionType {
    GAME_PLAY_ERROR("Game play error", "GPE"),
    TOURNAMENT_ERROR("Tournament error", "TE"),
    UNSPORTING_CONDUCT("Unsporting conduct", "USC");

    @JsonCreator
    public static InfractionType getByShortName(String shortName) {
        return Arrays.stream(InfractionType.values())
                .filter(ist -> shortName.equalsIgnoreCase(ist.shortName))
                .findFirst()
                .orElse(null);
    }

    @JsonValue
    public String getName() {
        return name;
    }

    private String name;
    private String shortName;
}
