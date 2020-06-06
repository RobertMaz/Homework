public class Worker {

    public static void main(String[] args) {
        Worker[] workers = new Worker[5];
        workers[0] = new Worker("Mike", "manager", "manager_Mike@mail.ru" , "89177777777", 40000, 40);
        workers[1] = new Worker("Donald", "director", "director_Donald@mail.ru" , "89251111111", 80000, 45);
        workers[2] = new Worker("Tom", "intern", "intern_Tom@mail.ru" , "+79872222222", 20000, 25);
        workers[3] = new Worker("Michail", "manager", "manager_Michail@mail.ru" , "89273333333", 30000, 50);
        workers[4] = new Worker("Boris", "manager", "manager_Boris@mail.ru" , "89999999999", 35000, 55);

        for (Worker w : workers) {
            if (w.age > 40) w.printWorker();
        }
    }

    private String name;
    private String position;
    private String e_mail;
    private String phoneNumber;
    private int pay;
    private int age;

    public Worker(String name, String position, String e_mail, String phoneNumber, int pay, int age) {
        this.name = name;
        this.position = position;
        this.e_mail = e_mail;
        this.phoneNumber = phoneNumber;
        this.pay = pay;
        this.age = age;
    }



    public void printWorker(){
        System.out.println("Worker name is: " + this.name + ".\nPosition is: " + this.position + ".\nE-mail :" + this.e_mail
                + ". \nPhone number: " + this.phoneNumber + ". \nPay: " + this.pay + ". \nAge: " + this.age + ".\n" );
    }
}
