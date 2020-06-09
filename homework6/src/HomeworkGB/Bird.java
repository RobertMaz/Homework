package HomeworkGB;

public class Bird extends Animals{

    private static int birdCount = 0;

    public Bird() {
        this.setName("HomeworkGB.Bird");
        birdCount++;
    }

    public Bird(String name, int age) {
        super(name, age);
        birdCount++;
    }

    public Bird(String name, int age, int limitForRun, int limitForJump) {
        super(name, age, limitForRun, limitForJump);
        birdCount++;
    }

    public static int getBirdCount() {
        return birdCount;
    }

    @Override
    protected void swim(double length) {
        System.out.println(this.getName() + " не умеет плавать.");
    }
}
