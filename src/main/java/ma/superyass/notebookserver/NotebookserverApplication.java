package ma.superyass.notebookserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotebookserverApplication {

    public static void main(String[] args) {

        try {
            Process p = Runtime.getRuntime().exec("python --version");
            p.waitFor(3, TimeUnit.SECONDS);
            if (p.exitValue() == 0) {
                SpringApplication.run(NotebookserverApplication.class, args);
            } else {
                throw new RuntimeException("Python is not installed");
            }
        } catch (Exception ex) {
            Logger.getLogger(NotebookserverApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
