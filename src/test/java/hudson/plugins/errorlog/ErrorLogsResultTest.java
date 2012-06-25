package hudson.plugins.errorlog;

import hudson.plugins.errorlog.ErrorLogsResult;
import hudson.model.AbstractBuild;
import hudson.plugins.analysis.core.BuildHistory;
import hudson.plugins.analysis.core.ParserResult;
import hudson.plugins.analysis.test.BuildResultTest;

/**
 * Tests the class {@link ErrorLogsResult}.
 */
public class ErrorLogsResultTest extends BuildResultTest<ErrorLogsResult> {
    @Override
    protected ErrorLogsResult createBuildResult(final AbstractBuild<?, ?> build, final ParserResult project, final BuildHistory history) {
        return new ErrorLogsResult(build, history, project, "UTF8", false);
    }
}

