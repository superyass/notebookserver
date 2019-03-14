package ma.superyass.notebookserver.core.interpreters.python;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import ma.superyass.notebookserver.core.interpreters.ContextualInterpreter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * python interpreter that preserves context in current session
 *
 * @author A-Y.boutahar
 */
@Component
//@SessionScope
public class PythonInterpreterContext extends ContextualInterpreter {

    private static final String CMD = "python";
   

    @PostConstruct
    private void init() {
        this.sessionVariables = new HashMap<>();
    }

    @Override
    public String getCommand() {
        return CMD;
    }

    
}