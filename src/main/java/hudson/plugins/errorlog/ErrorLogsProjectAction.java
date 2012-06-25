package hudson.plugins.errorlog;

import hudson.model.AbstractProject;
import hudson.plugins.analysis.core.ResultAction;
import hudson.plugins.analysis.core.AbstractProjectAction;

/**
 * Entry point to visualize the Checkstyle trend graph in the project screen.
 * Drawing of the graph is delegated to the associated {@link ResultAction}.
 *
 * @author Ulli Hafner
 */
public class ErrorLogsProjectAction extends AbstractProjectAction<ResultAction<ErrorLogsResult>> {
    /**
     * Instantiates a new {@link ErrorLogsProjectAction}.
     *
     * @param project
     *            the project that owns this action
     */
    public ErrorLogsProjectAction(final AbstractProject<?, ?> project) {
        this(project, ErrorLogsResultAction.class);
    }

    /**
     * Instantiates a new {@link ErrorLogsProjectAction}.
     *
     * @param project
     *            the project that owns this action
     * @param type
     *            the result action type
     */
    public ErrorLogsProjectAction(final AbstractProject<?, ?> project,
            final Class<? extends ResultAction<ErrorLogsResult>> type) {
        super(project, type, Messages._Checkstyle_ProjectAction_Name(), Messages._Checkstyle_Trend_Name(),
                ErrorLogsDescriptor.PLUGIN_ID, ErrorLogsDescriptor.ICON_URL, ErrorLogsDescriptor.RESULT_URL);
    }
}

