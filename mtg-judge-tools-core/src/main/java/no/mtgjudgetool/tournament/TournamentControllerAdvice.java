package no.mtgjudgetool.tournament;

import no.mtgjudgetool.common.exception.ErrorFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * Created by hanseeve on 01.09.2018.
 */
@ControllerAdvice
public class TournamentControllerAdvice {
    @ExceptionHandler(value = IOException.class)
    protected ResponseEntity<ErrorFormat> handleIOException(Exception e, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).body(new ErrorFormat(e, httpStatus));
    }
}
