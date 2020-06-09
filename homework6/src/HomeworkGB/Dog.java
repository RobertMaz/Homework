package HomeworkGB;

public class Dog extends Animals {

    private static int dogCount = 0;

    public Dog(){
        this.setName("HomeworkGB.Dog");
        dogCount++;
    }

    public Dog(String name, int age) {
        super(name, age);
        dogCount++;
    }

    public Dog(String name, int age, int limitForRun, int limitForSwim, int limitForJump) {
        super(name, age, limitForRun, limitForSwim, limitForJump);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
