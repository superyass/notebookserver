package ma.superyass.notebookserver.core.interpreters;

import ma.superyass.notebookserver.core.interpreters.python.PythonInterpreterContext;
import java.util.Date;
import ma.superyass.notebookserver.core.interpreters.utils.InterpreterNotSupportedException;
import ma.superyass.notebookserver.core.interpreters.utils.SupportedInterpreters;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author A-Y.boutahar
 */
@Component
@SessionScope
public class InterpreterManager {

    @Autowired
    private PythonInterpreterContext pic;

    public ContextualInterpreter getInterpreter(String code) {
        if (SupportedInterpreters.PYTHON.getKey().equals(StringUtils.substringBetween(code,"%", " "))) {
            return pic;
        }
        throw new InterpreterNotSupportedException("Interpreter not supported", code, null, new Date());
    }

}
