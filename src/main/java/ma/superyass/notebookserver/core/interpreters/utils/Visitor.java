package ma.superyass.notebookserver.core.interpreters.utils;

import ma.superyass.notebookserver.core.statements.Statement;

/**
 *
 * @author A-Y.boutahar
 */
public interface Visitor {
    public void visit(Statement s);
}
