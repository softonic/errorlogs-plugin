package hudson.plugins.errorlog;

import hudson.model.AbstractBuild;
import hudson.plugins.analysis.core.ParserResult;
import hudson.plugins.analysis.core.ResultAction;
import hudson.plugins.analysis.core.BuildResult;

/**
 * Represents the aggregated results of the Checkstyle analysis in m2 jobs.
 *
 * @author Ulli Hafner
 */
public class ErrorLogsReporterResult extends ErrorLogsResult {
    private static final long serialVersionUID = 6414012312137436141L;

    /**
     * Creates a new instance of {@link ErrorLogsReporterResult}.
     *
     * @param build
     *            the current build as owner of this action
     * @param defaultEncoding
     *            the default encoding to be used when reading and parsing files
     * @param result
     *            the parsed result with all annotations
     */
    public ErrorLogsReporterResult(final AbstractBuild<?, ?> build, final String defaultEncoding, final ParserResult result) {
        super(build, defaultEncoding, result, ErrorLogsMavenResultAction.class);
    }

    @Override
    protected Class<? extends ResultAction<? extends BuildResult>> getResultActionType() {
        return ErrorLogsMavenResultAction.class;
    }
}
