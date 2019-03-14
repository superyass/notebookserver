package ma.superyass.notebookserver.core.statements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import ma.superyass.notebookserver.core.interpreters.ContextualInterpreter;
import ma.superyass.notebookserver.core.statements.utils.ProcessReadTask;
import ma.superyass.notebookserver.core.interpreters.utils.Visitor;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author A-Y.boutahar
 */
public class Statement {

    String statement;
    ContextualInterpreter ci;

    public Statement(String code, ContextualInterpreter ci) {
        this.statement = StringUtils.substringAfter(code, "%" + ci.getCommand() + " ");
        this.ci = ci;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getStatement() {
        return statement;
    }

    public ContextualInterpreter getCi() {
        return ci;
    }

    public String execute() {
        String filename = ci.writeFile(statement);
        ExecutorService pool = Executors.newSingleThreadExecutor();
        ProcessBuilder processBuilder = new ProcessBuilder();
        StringBuilder text = new StringBuilder();
        try {

            processBuilder.command(ci.getCommand(), filename);
            
            Process process = processBuilder.start();

            ProcessReadTask task = new ProcessReadTask(process.getInputStream(), process.getErrorStream());
            Future<List<String>> future = pool.submit(task);

            List<String> result = future.get(ci.DEFAULT_EXEC_TIMEOUT, TimeUnit.SECONDS);
            for (String s : result) {
                text.append(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
            //TODO
            //delete file
        }
        return text.toString();
    }

}
