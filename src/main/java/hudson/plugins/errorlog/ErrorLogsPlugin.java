package hudson.plugins.errorlog;

import hudson.Plugin;
import hudson.plugins.errorlog.rules.ErrorLogsRules;

/**
 * Initializes the Checkstyle messages and descriptions.
 *
 * @author Ulli Hafner
 */
public class ErrorLogsPlugin extends Plugin {
    @Override
    public void start() {
        ErrorLogsRules.getInstance().initialize();
    }
}
