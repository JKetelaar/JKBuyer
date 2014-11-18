package nl.jketelaar.buyer;

/**
 * @author JKetelaar
 */
public class Variables {
    private static int slotID;
    private static int itemID;
    private static int amount;

    public static int getItemID() {
        return itemID;
    }

    public static int getSlotID() {
        return slotID;
    }

    public static void setItemID(int itemID) {
        Variables.itemID = itemID;
    }

    public static void setSlotID(int slotID) {
        Variables.slotID = slotID;
    }

    public static int getAmount() {
        return amount;
    }

    public static void setAmount(int amount) {
        Variables.amount = amount;
    }
}
