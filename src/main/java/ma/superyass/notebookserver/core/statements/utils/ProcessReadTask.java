package ma.superyass.notebookserver.core.statements.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author A-Y.boutahar
 */
public class ProcessReadTask implements Callable<List<String>> {

    private InputStream inputStream;
    private InputStream errorStream;

    public ProcessReadTask(InputStream inputStream, InputStream errorStream) {
        this.inputStream = inputStream;
        this.errorStream = errorStream;
    }

    @Override
    public List<String> call() {
        //contact input and error streams then collect
        return Stream.concat(new BufferedReader(new InputStreamReader(inputStream))
                .lines(), new BufferedReader(new InputStreamReader(errorStream))
                        .lines()).collect(Collectors.toList());
    }
}
