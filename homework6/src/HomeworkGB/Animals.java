package HomeworkGB;

public abstract class Animals {
    /*Счетчик всех созданных животных*/
    private static int animalCount = 0;

    private String name;
    private int age;

    /*Поля для установки лимитов*/
    private double limitForRun;
    private double limitForSwim;
    private double limitForJump;

    public Animals(){
        animalCount++;
        setLimit();
    }

    public Animals(String name, int age){
        this.name = name;
        this.age = age;
        animalCount++;
        setLimit();
    }
    /*Конструктор для тех кто все умеет и с заранее заданными ограничителями*/
    public Animals(String name, int age, int limitForRun, int limitForSwim, int limitForJump){
        this(name, age);
        this.limitForRun = limitForRun;
        this.limitForSwim = limitForSwim;
        this.limitForJump = limitForJump;
        animalCount++;
    }

    /*Конструктор для тех кто не умеет плавать*/
    public Animals(String name, int age, int limitForRun, int limitForJump){
        this(name, age);
        this.limitForRun = limitForRun;
        this.limitForJump = limitForJump;
        this.limitForSwim = 0;
        animalCount++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    /*Для получения общего количества животных*/
    public static int getAnimalCount() {
        return animalCount;
    }

    protected void run(double length){
        String text = this.name;
        text += length <= limitForRun ? " пробежал " : " не пробежит ";
        text += length;
        text += length < 5 ? " метра." : " метров.";
        System.out.println(text);
    }

    protected void swim(double length){
        String text = this.name;
        text += length <= limitForSwim ? " проплыл " : " не проплывет ";
        text += length;
        text += length < 5 ? " метра." : " метров.";;
        System.out.println(text);
    }

    protected void jump(double height){
        String text = this.name;
        text += height <= limitForJump ? " прыгнул на " : " не прыгнет на ";
        text += height;
        text += height < 5 ? " метра." : " метров.";;
        System.out.println(text);
    }
        /*Метод для установки лимитов*/
    private void setLimit(){
        if (this instanceof Dog)    setConcreteLimit(10, 500,0.4);
        if (this instanceof Horse)  setConcreteLimit(100, 1500, 3);
        if (this instanceof Bird)   setConcreteLimit(0, 5, 0.1);
        if (this instanceof Cat)    setConcreteLimit(0, 200, 2);
    }
    /*Вспомогательный метод для установки лимитов в зависимости от возраста. Если животному больше 5 лет то его возможности по дефолту уменьшаем в 2 раза*/
    private void setConcreteLimit(double limitForJump, double limitForRun, double limitForSwim){
            this.limitForSwim = this.age < 5 ? limitForSwim : limitForSwim / 2;
            this.limitForRun =  this.age < 5 ? limitForRun  : limitForRun / 2;
            this.limitForJump = this.age < 5 ? limitForJump : limitForJump / 2;
    }
}
