package ma.superyass.notebookserver.rest.dtos;

/**
 *
 * @author A-Y.boutahar
 */
public class ExecuteInputDTO {

    private String code;
    private String sessionId;

    public ExecuteInputDTO() {
    }

    public ExecuteInputDTO(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
