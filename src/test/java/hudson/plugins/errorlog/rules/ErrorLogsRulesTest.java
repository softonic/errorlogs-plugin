package hudson.plugins.errorlog.rules;
import hudson.plugins.errorlog.rules.ErrorLogsRules;
import hudson.plugins.errorlog.rules.Rule;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the class {@link ErrorLogsRules}.
 *
 * @author Ulli Hafner
 */
public class ErrorLogsRulesTest {
    /**
     * Test whether we could parse the Checkstyle rule meta data.
     */
    @Test
    public void checkRuleLoader() {
        ErrorLogsRules reader = ErrorLogsRules.getInstance();
        reader.initialize();

        assertEquals("Wrong number of rules detected.", 129, reader.getRules().size());
        assertNotNull("No EmptyBlock rule found.", reader.getRule("EmptyBlock"));
        assertEquals("Description for EmptyBlock found.", "<p> Checks for empty blocks. </p>", reader.getRule("EmptyBlock").getDescription());
        assertNotSame("No description for AnnotationUseStyle found.", Rule.UNDEFINED_DESCRIPTION, reader.getRule("AnnotationUseStyle").getDescription());
        assertNotSame("No description for AnnotationUseStyle found.", Rule.UNDEFINED_DESCRIPTION, reader.getDescription("AnnotationUseStyle"));
        assertSame("No default text available for undefined rule.", Rule.UNDEFINED_DESCRIPTION, reader.getRule("Undefined").getDescription());

        for (Rule rule : reader.getRules()) {
            assertNotSame("Rule " + rule.getName() + " has no description.", Rule.UNDEFINED_DESCRIPTION, rule.getDescription());
        }
    }
}
