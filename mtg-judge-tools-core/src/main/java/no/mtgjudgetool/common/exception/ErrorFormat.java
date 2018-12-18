package no.mtgjudgetool.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by hanseeve on 01.09.2018.
 */
@Getter
@AllArgsConstructor
public class ErrorFormat {
    private Exception exception;
    private HttpStatus httpStatus;
}
