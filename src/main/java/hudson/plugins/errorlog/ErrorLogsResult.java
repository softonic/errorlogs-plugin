package hudson.plugins.errorlog;

import hudson.model.AbstractBuild;
import hudson.plugins.analysis.core.BuildHistory;
import hudson.plugins.analysis.core.ParserResult;
import hudson.plugins.analysis.core.ResultAction;
import hudson.plugins.analysis.core.BuildResult;
import hudson.plugins.errorlog.parser.Warning;

import com.thoughtworks.xstream.XStream;

/**
 * Represents the results of the Checkstyle analysis. One instance of this class
 * is persisted for each build via an XML file.
 *
 * @author Ulli Hafner
 */
public class ErrorLogsResult extends BuildResult {
    private static final long serialVersionUID = 2768250056765266658L;

    /**
     * Creates a new instance of {@link ErrorLogsResult}.
     *
     * @param build
     *            the current build as owner of this action
     * @param defaultEncoding
     *            the default encoding to be used when reading and parsing files
     * @param result
     *            the parsed result with all annotations
     */
    public ErrorLogsResult(final AbstractBuild<?, ?> build, final String defaultEncoding, final ParserResult result) {
        this(build, defaultEncoding, result, ErrorLogsResultAction.class);
    }

    /**
     * Creates a new instance of {@link ErrorLogsResult}.
     *
     * @param build
     *            the current build as owner of this action
     * @param defaultEncoding
     *            the default encoding to be used when reading and parsing files
     * @param result
     *            the parsed result with all annotations
     * @param actionType
     *            the type of the result action
     */
    protected ErrorLogsResult(final AbstractBuild<?, ?> build, final String defaultEncoding, final ParserResult result,
            final Class<? extends ResultAction<ErrorLogsResult>> actionType) {
        this(build, new BuildHistory(build, actionType), result, defaultEncoding, true);
    }

    ErrorLogsResult(final AbstractBuild<?, ?> build, final BuildHistory history,
            final ParserResult result, final String defaultEncoding, final boolean canSerialize) {
        super(build, history, result, defaultEncoding);

        if (canSerialize) {
            serializeAnnotations(result.getAnnotations());
        }
    }

    @Override
    public String getHeader() {
        return Messages.Checkstyle_ResultAction_Header();
    }

    @Override
    protected void configure(final XStream xstream) {
        xstream.alias("warning", Warning.class);
    }

    @Override
    public String getSummary() {
        return "Errors: " + createDefaultSummary(ErrorLogsDescriptor.RESULT_URL, getNumberOfAnnotations(), getNumberOfModules());
    }

    @Override
    protected String createDeltaMessage() {
        return createDefaultDeltaMessage(ErrorLogsDescriptor.RESULT_URL, getNumberOfNewWarnings(), getNumberOfFixedWarnings());
    }

    /**
     * Returns the name of the file to store the serialized annotations.
     *
     * @return the name of the file to store the serialized annotations
     */
    @Override
    protected String getSerializationFileName() {
        return "errorlogs-warnings.xml";
    }

    /** {@inheritDoc} */
    public String getDisplayName() {
        return Messages.Checkstyle_ProjectAction_Name();
    }

    @Override
    protected Class<? extends ResultAction<? extends BuildResult>> getResultActionType() {
        return ErrorLogsResultAction.class;
    }
}
