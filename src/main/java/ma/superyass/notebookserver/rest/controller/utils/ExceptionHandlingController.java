package ma.superyass.notebookserver.rest.controller.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author A-Y.boutahar
 */
@ControllerAdvice
public class ExceptionHandlingController {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public @ResponseBody
    ExceptionDto handleException(Exception e) {
        e.printStackTrace();
        return new ExceptionDto(e.getLocalizedMessage());
    }

}
