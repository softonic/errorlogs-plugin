package hudson.plugins.errorlog;

import hudson.Extension;
import hudson.plugins.analysis.core.PluginDescriptor;

/**
 * Descriptor for the class {@link ErrorLogsPublisher}.
 *
 * @author Ulli Hafner
 */
@Extension(ordinal = 100) // NOCHECKSTYLE
public final class ErrorLogsDescriptor extends PluginDescriptor {
    /** The ID of this plug-in is used as URL. */
    static final String PLUGIN_ID = "errorlogs";
    /** The URL of the result action. */
    static final String RESULT_URL = PluginDescriptor.createResultUrlName(PLUGIN_ID);
    /** Icons prefix. */
    static final String ICON_URL_PREFIX = "/plugin/errorlogs/icons/";
    /** Icon to use for the result and project action. */
    static final String ICON_URL = ICON_URL_PREFIX + "disaster-24x24.bmp";

    /**
     * Instantiates a new find bugs descriptor.
     */
    public ErrorLogsDescriptor() {
        super(ErrorLogsPublisher.class);
    }

    @Override
    public String getDisplayName() {
        return Messages.Checkstyle_Publisher_Name();
    }

    @Override
    public String getPluginName() {
        return PLUGIN_ID;
    }

    @Override
    public String getIconUrl() {
        return ICON_URL;
    }

    @Override
    public String getSummaryIconUrl() {
        return ICON_URL_PREFIX + "disaster-48x48.bmp";
    }
}