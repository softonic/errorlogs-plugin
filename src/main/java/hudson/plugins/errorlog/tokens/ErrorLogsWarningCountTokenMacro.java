package hudson.plugins.errorlog.tokens;

import hudson.Extension;
import hudson.plugins.analysis.tokens.AbstractAnnotationsCountTokenMacro;
import hudson.plugins.errorlog.ErrorLogsMavenResultAction;
import hudson.plugins.errorlog.ErrorLogsResultAction;

/**
 * Provides a token that evaluates to the number of Checkstyle warnings.
 *
 * @author Ulli Hafner
 */
@Extension(optional = true)
public class ErrorLogsWarningCountTokenMacro extends AbstractAnnotationsCountTokenMacro {
    /**
     * Creates a new instance of {@link ErrorLogsWarningCountTokenMacro}.
     */
    @SuppressWarnings("unchecked")
    public ErrorLogsWarningCountTokenMacro() {
        super("CHECKSTYLE_COUNT", ErrorLogsResultAction.class, ErrorLogsMavenResultAction.class);
    }
}

