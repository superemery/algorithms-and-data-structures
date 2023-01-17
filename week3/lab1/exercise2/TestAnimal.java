public class TestAnimal {
    public static void main(String[] args) {
        final String dogName = "Harry";
        final int exerciseTime = 100;
        final String catName = "Leo";

        Dog dog = new Dog(dogName);
        dog.setExerciseTime(exerciseTime);
        System.out.println(dog);

        Cat cat = new Cat(catName);
        System.out.println(cat);
        for (int i = 0; i < 9; i++) {
            cat.loseLife();
        }
    }
}
