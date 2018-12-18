package no.mtgjudgetool.penalty.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * Created by hanseeve on 22.08.2018.
 */
@Getter
@AllArgsConstructor
public enum InfractionType {
    GAME_PLAY_ERROR(new Infraction("Game play error", "GPE")),
    TOURNAMENT_ERROR(new Infraction("Tournament error", "TE")),
    UNSPORTING_CONDUCT(new Infraction("Unsporting conduct", "USC"));

    @JsonCreator
    public static InfractionType getByShortName(String shortName) {
        return Arrays.stream(InfractionType.values())
                .filter(ist -> shortName.equalsIgnoreCase(ist.getInfraction().getShortName()))
                .findFirst()
                .orElse(null);
    }

    @JsonValue
    public Infraction toJsonValue() {
        return this.getInfraction();
    }

    private Infraction infraction;
}
