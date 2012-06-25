package hudson.plugins.errorlog;

import hudson.model.AbstractBuild;
import hudson.plugins.analysis.core.AbstractResultAction;
import hudson.plugins.analysis.core.HealthDescriptor;
import hudson.plugins.analysis.core.PluginDescriptor;

/**
 * Controls the live cycle of the Checkstyle results. This action persists the
 * results of the Checkstyle analysis of a build and displays the results on the
 * build page. The actual visualization of the results is defined in the
 * matching <code>summary.jelly</code> file.
 * <p>
 * Moreover, this class renders the Checkstyle result trend.
 * </p>
 *
 * @author Ulli Hafner
 */
public class ErrorLogsResultAction extends AbstractResultAction<ErrorLogsResult> {
    /**
     * Creates a new instance of <code>ErrorLogsResultAction</code>.
     *
     * @param owner
     *            the associated build of this action
     * @param healthDescriptor
     *            health descriptor
     * @param result
     *            the result in this build
     */
    public ErrorLogsResultAction(final AbstractBuild<?, ?> owner, final HealthDescriptor healthDescriptor, final ErrorLogsResult result) {
        super(owner, new ErrorLogsHealthDescriptor(healthDescriptor), result);
    }

    /**
     * Creates a new instance of <code>ErrorLogsResultAction</code>.
     *
     * @param owner
     *            the associated build of this action
     * @param healthDescriptor
     *            health descriptor
     */
    public ErrorLogsResultAction(final AbstractBuild<?, ?> owner, final HealthDescriptor healthDescriptor) {
        super(owner, new ErrorLogsHealthDescriptor(healthDescriptor));
    }

    /** {@inheritDoc} */
    public String getDisplayName() {
        return Messages.Checkstyle_ProjectAction_Name();
    }

    @Override
    protected PluginDescriptor getDescriptor() {
        return new ErrorLogsDescriptor();
    }
}
