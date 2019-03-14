package ma.superyass.notebookserver.core.interpreters.utils;

import java.util.Date;

/**
 *
 * @author A-Y.boutahar
 */
public class InterpreterNotSupportedException extends RuntimeException {

    private String statement;
    private String sessionId;
    private Date date;

    public InterpreterNotSupportedException(String message, String statement, String sessionId, Date date) {
        super(message);
        this.statement = statement;
        this.sessionId = sessionId;
        this.date = date;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
