package HomeworkGB;

public class Cat extends Animals{

    private static int catCount = 0;

    public Cat() {
        this.setName("HomeworkGB.Cat");
        catCount++;
    }

    public Cat(String name, int age) {
        super(name, age);
        catCount++;
    }

    public Cat(String name, int age, int limitForRun, int limitForJump) {
        super(name, age, limitForRun, limitForJump);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    protected void swim(double length) {
        System.out.println(this.getName() + " не умеет плавать.");
    }
}
