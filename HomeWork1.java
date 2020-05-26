public class HomeWork1 {
    public static void main(String[] args) {
        //объявляем все типы переменных
        byte b = 1;
        short s = 10;
        int i = 100;
        long l = 1000;
        float f = 1000.3f;
        double d = 1000.3;
        boolean bool = true;
        String str = "string";
        char c ='1';

        //Выводим в консоль методы которые возвращают значения
        System.out.println(method(1,2,8,4));
        System.out.println(checkNumber(4,10));
        System.out.println(isNegativeNumber(10));

        //вызываем остальные методы
        isPositiveNumber(-10);
        helloPrintName("Robert");
        leapYear(2020);
    }

    public static int method(int a, int b, int c, int d){
        return a * (b + (c / d));
    }

    public static boolean checkNumber(int a, int b){
        return (a + b > 10 && a + b <= 20);
    }

    public static void isPositiveNumber(int a) {
        System.out.println(a >= 0 ? "Число положительное":"Число отрицательное");
    }

    public static boolean isNegativeNumber(int a){
        return (a < 0);
    }

    public static void helloPrintName(String name){
        System.out.println("Привет, " + name + ".");
    }

    /*
    проверка года на высокосность
     */
    public static void leapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ) {
            System.out.println(year + " год високосный.");
        }
        else System.out.println(year + " год не високосный.");
    }
}
