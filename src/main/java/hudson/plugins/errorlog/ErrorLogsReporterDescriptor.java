package hudson.plugins.errorlog;

import hudson.Extension;
import hudson.plugins.analysis.core.ReporterDescriptor;

/**
 * Descriptor for the class {@link ErrorLogsReporter}. Used as a singleton. The
 * class is marked as public so that it can be accessed from views.
 *
 * @author Ulli Hafner
 */
@Extension(ordinal = 100) // NOCHECKSTYLE
public class ErrorLogsReporterDescriptor extends ReporterDescriptor {
    /**
     * Creates a new instance of <code>ErrorLogsReporterDescriptor</code>.
     */
    public ErrorLogsReporterDescriptor() {
        super(ErrorLogsReporter.class, new ErrorLogsDescriptor());
    }
}

