import java.util.ArrayList;

public class Shopping {
    private ArrayList<String> shoppingList;

    public Shopping() {
        shoppingList = new ArrayList<String>();
    }

    public void addItem(String itemName) {
        shoppingList.add(itemName);
    }

    public int numberOfItems() {
        return shoppingList.size();
    }

    public void showItem(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= numberOfItems())
            return;

        System.out.println(shoppingList.get(itemIndex));
    }

    public void listItems() {
        for (String item : shoppingList) {
            System.out.println(item);
        }
    }
}
