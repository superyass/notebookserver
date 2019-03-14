package ma.superyass.notebookserver.core.interpreters.utils;

/**
 *
 * @author A-Y.boutahar
 */
public enum SupportedInterpreters {
    PYTHON("python");

    private String key;

    private SupportedInterpreters(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
