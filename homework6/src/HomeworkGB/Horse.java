package HomeworkGB;

public class Horse extends Animals {

    private static int horseCount = 0;

    public Horse() {
        this.setName("HomeworkGB.Horse");
        horseCount++;
    }

    public Horse(String name, int age) {
        super(name, age);
        horseCount++;
    }

    public Horse(String name, int age, int limitForRun, int limitForSwim, int limitForJump) {
        super(name, age, limitForRun, limitForSwim, limitForJump);
        horseCount++;
    }

    public static int getHorseCount() {
        return horseCount;
    }
}
