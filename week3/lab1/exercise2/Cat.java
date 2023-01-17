public class Cat extends Animal {
    private int livesLeft;

    public Cat(String name) {
        super(name);
        livesLeft = 9;
    }

    public int getLivesLeft() {
        return livesLeft;
    }

    public void loseLife() {
        livesLeft--;

        if (livesLeft <= 0)
            System.out.println("The cat is dead");
    }

    @Override
    public String toString() {
        return super.toString() + "\nLives Left:\t" + livesLeft;
    }
}
