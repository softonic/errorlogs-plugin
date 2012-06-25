package hudson.plugins.errorlog;

import hudson.maven.MavenAggregatedReport;
import hudson.maven.MavenBuild;
import hudson.maven.MavenModule;
import hudson.maven.MavenModuleSet;
import hudson.maven.MavenModuleSetBuild;
import hudson.model.Action;
import hudson.plugins.analysis.core.HealthDescriptor;
import hudson.plugins.analysis.core.MavenResultAction;

import java.util.List;
import java.util.Map;

import javax.annotation.CheckForNull;

/**
 * A {@link ErrorLogsResultAction} for native Maven jobs. This action
 * additionally provides result aggregation for sub-modules and for the main
 * project.
 *
 * @author Ulli Hafner
 */
public class ErrorLogsMavenResultAction extends MavenResultAction<ErrorLogsResult> {
    /**
     * Creates a new instance of {@link ErrorLogsMavenResultAction}. This instance
     * will have no result set in the beginning. The result will be set
     * successively after each of the modules are build.
     *
     * @param owner
     *            the associated build of this action
     * @param healthDescriptor
     *            health descriptor to use
     * @param defaultEncoding
     *            the default encoding to be used when reading and parsing files
     */
    public ErrorLogsMavenResultAction(final MavenModuleSetBuild owner, final HealthDescriptor healthDescriptor,
            final String defaultEncoding) {
        super(new ErrorLogsResultAction(owner, healthDescriptor), defaultEncoding, "CHECKSTYLE");
    }

    /**
     * Creates a new instance of {@link ErrorLogsMavenResultAction}.
     *
     * @param owner
     *            the associated build of this action
     * @param healthDescriptor
     *            health descriptor to use
     * @param defaultEncoding
     *            the default encoding to be used when reading and parsing files
     * @param result
     *            the result in this build
     */
    public ErrorLogsMavenResultAction(final MavenBuild owner, final HealthDescriptor healthDescriptor,
            final String defaultEncoding, final ErrorLogsResult result) {
        super(new ErrorLogsResultAction(owner, healthDescriptor, result), defaultEncoding, "CHECKSTYLE");
    }

    /** {@inheritDoc} */
    public MavenAggregatedReport createAggregatedAction(final MavenModuleSetBuild build, final Map<MavenModule, List<MavenBuild>> moduleBuilds) {
        return new ErrorLogsMavenResultAction(build, getHealthDescriptor(), getDisplayName());
    }

    /** {@inheritDoc} */
    public Action getProjectAction(final MavenModuleSet moduleSet) {
        return new ErrorLogsProjectAction(moduleSet, ErrorLogsMavenResultAction.class);
    }

    @Override
    public Class<? extends MavenResultAction<ErrorLogsResult>> getIndividualActionType() {
        return ErrorLogsMavenResultAction.class;
    }

    @Override
    protected ErrorLogsResult createResult(@CheckForNull final ErrorLogsResult existingResult, final ErrorLogsResult additionalResult) {
        return new ErrorLogsReporterResult(getOwner(), additionalResult.getDefaultEncoding(), aggregate(existingResult, additionalResult));
    }
}

