package ma.superyass.notebookserver.rest.controller.utils;

/**
 *
 * @author A-Y.boutahar
 */
public class ExceptionDto {

    private String message;

    public ExceptionDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
