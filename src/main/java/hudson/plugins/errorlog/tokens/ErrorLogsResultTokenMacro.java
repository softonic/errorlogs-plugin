package hudson.plugins.errorlog.tokens;

import hudson.Extension;
import hudson.plugins.analysis.tokens.AbstractResultTokenMacro;
import hudson.plugins.errorlog.ErrorLogsMavenResultAction;
import hudson.plugins.errorlog.ErrorLogsResultAction;

/**
 * Provides a token that evaluates to the Checkstyle build result.
 *
 * @author Ulli Hafner
 */
@Extension(optional = true)
public class ErrorLogsResultTokenMacro extends AbstractResultTokenMacro {
    /**
     * Creates a new instance of {@link ErrorLogsResultTokenMacro}.
     */
    @SuppressWarnings("unchecked")
    public ErrorLogsResultTokenMacro() {
        super("CHECKSTYLE_RESULT", ErrorLogsResultAction.class, ErrorLogsMavenResultAction.class);
    }
}

