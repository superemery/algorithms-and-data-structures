public class ShoppingTester {
    public static void main(String[] args) {
        Shopping shopping = new Shopping();
        shopping.addItem("milk");
        shopping.addItem("eggs");
        shopping.addItem("cake");

        System.out.println(shopping.numberOfItems());

        shopping.showItem(-1);
        shopping.showItem(1);
        shopping.showItem(4);

        shopping.listItems();
    }
}
