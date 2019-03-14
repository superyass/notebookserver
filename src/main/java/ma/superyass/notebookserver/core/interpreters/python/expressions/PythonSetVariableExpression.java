package ma.superyass.notebookserver.core.interpreters.python.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ma.superyass.notebookserver.core.interpreters.utils.Visitor;
import ma.superyass.notebookserver.core.statements.Statement;

/**
 *
 * @author A-Y.boutahar
 */
public class PythonSetVariableExpression implements Visitor {

    @Override
    public void visit(Statement s) {
        Pattern ptrn = Pattern.compile("^[a-zA-Z_$][a-zA-Z_$0-9]*\\s*(=)\\s*\\w");
        Matcher m = ptrn.matcher(s.getStatement());
        if (m.lookingAt()) {
            String varname = s.getStatement().split("=")[0].trim();
            s.getCi().getSessionVariables().put(varname, s.getStatement());
        }
    }

}
