package ma.superyass.notebookserver.core.interpreters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
import ma.superyass.notebookserver.core.interpreters.python.expressions.PythonSetVariableExpression;
import ma.superyass.notebookserver.core.statements.Statement;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author A-Y.boutahar
 */
public abstract class ContextualInterpreter {

    /* key value of variable name and exec command*/
    protected Map<String, String> sessionVariables;
    public static final int DEFAULT_EXEC_TIMEOUT = 5;

    public abstract String getCommand();

    /**
     * returns file name
     */
    public String writeFile(String code) {

        String filename = "script.py";
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(code);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filename;
    }

    public Map<String, String> getSessionVariables() {
        return sessionVariables;
    }

    //TODO
    //String lastCommand();
    public Statement interprete(String code) {
        Statement s = new Statement(code, this);
        // visitors
        s.accept(new PythonSetVariableExpression());

        // TODO
        // context vars
        return s;
    }
}
