package hudson.plugins.errorlog.tokens;

import hudson.Extension;
import hudson.plugins.analysis.tokens.AbstractFixedAnnotationsTokenMacro;
import hudson.plugins.errorlog.ErrorLogsMavenResultAction;
import hudson.plugins.errorlog.ErrorLogsResultAction;

/**
 * Provides a token that evaluates to the number of fixed Checkstyle warnings.
 *
 * @author Ulli Hafner
 */
@Extension(optional = true)
public class FixedErrorLogsWarningsTokenMacro extends AbstractFixedAnnotationsTokenMacro {
    /**
     * Creates a new instance of {@link FixedErrorLogsWarningsTokenMacro}.
     */
    @SuppressWarnings("unchecked")
    public FixedErrorLogsWarningsTokenMacro() {
        super("CHECKSTYLE_FIXED", ErrorLogsResultAction.class, ErrorLogsMavenResultAction.class);
    }
}

