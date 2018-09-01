package no.mtgjudgetool.penalty.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * Created by hanseeve on 22.08.2018.
 */
@AllArgsConstructor
public enum InfractionSubType {
    MISSED_TRIGGER("Missed Trigger", "MT", InfractionType.GAME_PLAY_ERROR),
    LOOKING_AT_EXTRA_CARDS("Looking at Extra Cards", "LAEC", InfractionType.GAME_PLAY_ERROR),
    HIDDEN_CARD_ERROR("Hidden Card Error", "HCE", InfractionType.GAME_PLAY_ERROR),
    MULLIGAN_PROCEDURE_ERROR("Mulligan Procedure Error", "MPE", InfractionType.GAME_PLAY_ERROR),
    GAME_RULE_VIOLATION("Game Rule Violation", "GRV", InfractionType.GAME_PLAY_ERROR),
    FAILURE_TO_MAINTAIN_GAME_STATE("Failure to Maintain Game State", "FTMGS", InfractionType.GAME_PLAY_ERROR),

    TARDINESS("Tardiness", "T", InfractionType.TOURNAMENT_ERROR),
    OUTSIDE_ASSISTANCE("Outside Assistance", "OA", InfractionType.TOURNAMENT_ERROR),
    SLOW_PLAY("Slow Play", "SP", InfractionType.TOURNAMENT_ERROR),
    DECKLIST_PROBLEM("Decklist Problem", "DLP", InfractionType.TOURNAMENT_ERROR),
    DECK_PROBLEM("Deck Problem", "DP", InfractionType.TOURNAMENT_ERROR),
    LIMITED_PROCEDURE_VIOLATION("Limited Procedure Violation", "LPV", InfractionType.TOURNAMENT_ERROR),
    COMMUNICATION_POLICY_VIOLATION("Communication Policy Violation", "CPV", InfractionType.TOURNAMENT_ERROR),
    MARKED_CARDS("Marked Cards", "MC", InfractionType.TOURNAMENT_ERROR),
    INSUFFICIENT_SHUFFLING("Insufficient Shuffling", "IS", InfractionType.TOURNAMENT_ERROR),

    MINOR("Minor", "Mi", InfractionType.UNSPORTING_CONDUCT),
    MAJOR("Major", "Ma", InfractionType.UNSPORTING_CONDUCT),
    IMPROPERLY_DETERMINING_A_WINNER("Improperly Determining a Winner", "IDAW", InfractionType.UNSPORTING_CONDUCT),
    BRIBERY_AND_WAGERING("Bribery and Wagering", "BAW", InfractionType.UNSPORTING_CONDUCT),
    AGGRESSIVE_BEHAVIOR("Aggressive Behavior", "AB", InfractionType.UNSPORTING_CONDUCT),
    THEFT_OF_TOURNAMENT_MATERIAL("Theft of Tournament Material", "TOTM", InfractionType.UNSPORTING_CONDUCT),
    TALLING("Stalling", "S", InfractionType.UNSPORTING_CONDUCT),
    CHEATING("Cheating", "C", InfractionType.UNSPORTING_CONDUCT);

    @JsonCreator
    public static InfractionSubType getByShortName(String shortName) {
        return Arrays.stream(InfractionSubType.values())
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
    private InfractionType infractionType;
}
