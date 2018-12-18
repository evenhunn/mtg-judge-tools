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
public enum InfractionSubType {
    MISSED_TRIGGER(new Infraction("Missed Trigger", "MT"), InfractionType.GAME_PLAY_ERROR),
    LOOKING_AT_EXTRA_CARDS(new Infraction("Looking at Extra Cards", "LAEC"), InfractionType.GAME_PLAY_ERROR),
    HIDDEN_CARD_ERROR(new Infraction("Hidden Card Error", "HCE"), InfractionType.GAME_PLAY_ERROR),
    MULLIGAN_PROCEDURE_ERROR(new Infraction("Mulligan Procedure Error", "MPE"), InfractionType.GAME_PLAY_ERROR),
    GAME_RULE_VIOLATION(new Infraction("Game Rule Violation", "GRV"), InfractionType.GAME_PLAY_ERROR),
    FAILURE_TO_MAINTAIN_GAME_STATE(new Infraction("Failure to Maintain Game State", "FTMGS"), InfractionType.GAME_PLAY_ERROR),

    TARDINESS(new Infraction("Tardiness", "T"), InfractionType.TOURNAMENT_ERROR),
    OUTSIDE_ASSISTANCE(new Infraction("Outside Assistance", "OA"), InfractionType.TOURNAMENT_ERROR),
    SLOW_PLAY(new Infraction("Slow Play", "SP"), InfractionType.TOURNAMENT_ERROR),
    DECKLIST_PROBLEM(new Infraction("Decklist Problem", "DLP"), InfractionType.TOURNAMENT_ERROR),
    DECK_PROBLEM(new Infraction("Deck Problem", "DP"), InfractionType.TOURNAMENT_ERROR),
    LIMITED_PROCEDURE_VIOLATION(new Infraction("Limited Procedure Violation", "LPV"), InfractionType.TOURNAMENT_ERROR),
    COMMUNICATION_POLICY_VIOLATION(new Infraction("Communication Policy Violation", "CPV"), InfractionType.TOURNAMENT_ERROR),
    MARKED_CARDS(new Infraction("Marked Cards", "MC"), InfractionType.TOURNAMENT_ERROR),
    INSUFFICIENT_SHUFFLING(new Infraction("Insufficient Shuffling", "IS"), InfractionType.TOURNAMENT_ERROR),

    MINOR(new Infraction("Minor", "Mi"), InfractionType.UNSPORTING_CONDUCT),
    MAJOR(new Infraction("Major", "Ma"), InfractionType.UNSPORTING_CONDUCT),
    IMPROPERLY_DETERMINING_A_WINNER(new Infraction("Improperly Determining a Winner", "IDAW"), InfractionType.UNSPORTING_CONDUCT),
    BRIBERY_AND_WAGERING(new Infraction("Bribery and Wagering", "BAW"), InfractionType.UNSPORTING_CONDUCT),
    AGGRESSIVE_BEHAVIOR(new Infraction("Aggressive Behavior", "AB"), InfractionType.UNSPORTING_CONDUCT),
    THEFT_OF_TOURNAMENT_MATERIAL(new Infraction("Theft of Tournament Material", "TOTM"), InfractionType.UNSPORTING_CONDUCT),
    TALLING(new Infraction("Stalling", "S"), InfractionType.UNSPORTING_CONDUCT),
    CHEATING(new Infraction("Cheating", "C"), InfractionType.UNSPORTING_CONDUCT);

    @JsonCreator
    public static InfractionSubType getByShortName(String shortName) {
        return Arrays.stream(InfractionSubType.values())
                .filter(ist -> shortName.equalsIgnoreCase(ist.getInfraction().getShortName()))
                .findFirst()
                .orElse(null);
    }

    @JsonValue
    public Infraction getName() {
        return this.getInfraction();
    }

    private Infraction infraction;
    private InfractionType infractionType;
}
