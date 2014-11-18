package nl.jketelaar.buyer;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.soulsplit.api.methods.Game;
import org.soulsplit.api.methods.Inventory;
import org.soulsplit.api.methods.Menu;

/**
 * @author JKetelaar
 */
public class Buying implements Strategy {
    @Override
    public boolean activate() {
        return Game.getOpenInterfaceId() != -1 && Game.getOpenInterfaceId() != 0;
    }

    @Override
    public void execute() {
        final int inventoryAmount = Inventory.getItems(Variables.getItemID() + 1).length;
        Menu.sendAction(Variables.getAmount(), Variables.getItemID(), Variables.getSlotID(), 3900);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Inventory.getItems(Variables.getItemID() + 1).length > inventoryAmount;
            }
        }, 2500);
    }
}
