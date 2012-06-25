package hudson.plugins.errorlog.tokens;

import hudson.Extension;
import hudson.plugins.analysis.tokens.AbstractNewAnnotationsTokenMacro;
import hudson.plugins.errorlog.ErrorLogsMavenResultAction;
import hudson.plugins.errorlog.ErrorLogsResultAction;

/**
 * Provides a token that evaluates to the number of new Checkstyle warnings.
 *
 * @author Ulli Hafner
 */
@Extension(optional = true)
public class NewErrorLogsWarningsTokenMacro extends AbstractNewAnnotationsTokenMacro {
    /**
     * Creates a new instance of {@link NewErrorLogsWarningsTokenMacro}.
     */
    @SuppressWarnings("unchecked")
    public NewErrorLogsWarningsTokenMacro() {
        super("CHECKSTYLE_NEW", ErrorLogsResultAction.class, ErrorLogsMavenResultAction.class);
    }
}

