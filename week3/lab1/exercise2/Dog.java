public class Dog extends Animal {
    private int exerciseTime;

    public Dog(String name) {
        super(name);
    }

    public int getExerciseTime() {
        return exerciseTime;
    }

    public void setExerciseTime(int exerciseTime) {
        this.exerciseTime = exerciseTime;
    }

    @Override
    public String toString() {
        return super.toString() + "\nExercise Time:\t" + exerciseTime;
    }
}