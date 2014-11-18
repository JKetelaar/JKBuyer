package nl.jketelaar.buyer;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;

import java.util.ArrayList;

/**
 * @author JKetelaar
 */
@ScriptManifest(author = "Paradox",
        category = Category.OTHER,
        description = "A buy for Soulsplit",
        name = "JKBuyer",
        servers = { "Soulsplit"},
        version = 1.3)
public class Core extends Script {

    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

    @Override
    public boolean onExecute() {
        final UI userInterface = new UI();

        while (userInterface.getFrame().isVisible()){
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return !userInterface.getFrame().isVisible();
                }
            }, 2500);
        }

        strategies.add(new Buying());
        provide(strategies);
        return true;
    }
}
