import javax.swing.JOptionPane;

public class ShoppingMenu {
    private enum MenuAction {
        ADD,
        LIST,
        SHOW,
        EXIT
    }

    private final Shopping shopping = new Shopping();

    public void showMenu() {
        while (true) {
            MenuAction action = getSelectedAction();

            switch (action) {
                case ADD:
                    addNewItem();
                    break;
                case LIST:
                    if (shopping.numberOfItems() == 0) {
                        System.out.println("No item in list");
                        continue;
                    }
                    shopping.listItems();
                    break;
                case SHOW:
                    if (shopping.numberOfItems() == 0) {
                        System.out.println("No item in list");
                        continue;
                    }
                    shopping.showItem(getItemIndex());
                    break;
                case EXIT:
                    return;
                default:
                    return;
            }
        }
    }

    private MenuAction getSelectedAction() {
        int selected = JOptionPane.showOptionDialog(null, "Select from ..", "Shopping Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, MenuAction.values(),
                MenuAction.values()[0]);

        return MenuAction.values()[selected];
    }

    private int getItemIndex() {
        try {
            String strItemIndex = JOptionPane.showInputDialog(null,
                    "Enter an item index", "Show Item",
                    JOptionPane.PLAIN_MESSAGE);

            return Integer.parseInt(strItemIndex);
        } catch (Exception e) {
            return -1;
        }
    }

    private void addNewItem() {
        String itemName = JOptionPane.showInputDialog(null,
                "Enter an item name", "Add Item",
                JOptionPane.PLAIN_MESSAGE);

        if (itemName == null)
            return;

        itemName = itemName.trim();

        if (!itemName.equals(""))
            shopping.addItem(itemName);
    }
}
