import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {
        // task 1
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArray(arrayEdit(array));

        // task 2
        int[] array2 = new int[8];
        printArray(arrayPut(array2));

        // task 3
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(arrayEditTwo(array3));

        // task 4. В качестве параметра передаем размер квадрата для печати диагональных элементов.
        printArray(arraySquare(5));

        int[] arr = {2, 2, 2, 1, 2, 2, 10, 1}; //массив для 5, 6, 7 заданий

        // task 5.
        arrayMinMax(arr);

        //task 6
        checkBalance(arr);

        //task 7
        turnArray(arr, 999);
        printArray(arr);
    }

    //перегруженный метод для вывода массива в консоль
    public static void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }

    //перегруженный метод для вывода двумерного массива square в консоль
    public static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] != 0 ? array[i][j] : " ");
            }
            System.out.println();
        }
    }

    //task 1.
    /*
    Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0.
     */
    public static int[] arrayEdit(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        return array;
    }

    //task 2.
    /*
    Задать пустой целочисленный массив размером 8.
    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21.
    */
    public static int[] arrayPut(int[] array){
        for (int i = 0, j = 0; i < array.length; i++, j +=3) {
            array[i] = j;
        }
        return array;
    }

    //task 3.
    /*
    Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    пройти по нему циклом, и числа меньшие 6 умножить на 2.
     */
    public static int[] arrayEditTwo(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        return array;
    }

    //task 4.
    /*
    Создать квадратный двумерный целочисленный массив
    (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами.
    */
    public static int[][] arraySquare(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
            array[i][size - i - 1] = 1;
        }
        return array;
    }

    //task 5.
    /*
    Задать одномерный массив и найти в нем минимальный
    и максимальный элементы (без помощи интернета).
     */
    public static void arrayMinMax(int[] array){
        int max = array[0], min = array[0];
        for (int i : array) {
            max = i > max ? i : max;   //Idea советует пакетом Math пользоваться, в рамаках наших уроков не стал это делать.
            min = i < min ? i : min;
        }
        System.out.println("Max is: " + max + ". Min is: " + min + ".");
    }

    //task 6.
    /*
    Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой
    и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
     */
    public static void checkBalance(int[] array) {
        int leftSum = array[0];
        int rightSum = array[1];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                rightSum += array[j];
            }
            if (leftSum == rightSum) {
                //Тут большой кусок кода, что бы просто красивее был вывод.
                int sumForCheck = 0;
                System.out.print(true + "-> ");
                for (int j : array) {
                    System.out.print(j + " ");
                    sumForCheck += j;
                    if (sumForCheck == rightSum) System.out.print("|| ");
                }
                System.out.println();
                break;
            }
            rightSum = 0;
            if (i < array.length - 1) leftSum += array[i + 1];
            else System.out.println(false);
        }
    }

    //task 7.
    /*
    Написать метод, которому на вход подается одномерный массив
    и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    public static void turnArray(int[] array, int a){
        int size = array.length; //так просто код аккуратнее выглядит
        if (a < 0) a = Math.abs(a) > size ? a % size + a : size + a; // если смещаем на отрицательное число, от длины просто отнимаем это число и входим в цикл( "+" потому что число отрицательное)
        a = a > size? a % size + a : size + a;   //это, что бы если число большое ввели, чем длина массива, лишний раз не перебирать
        for (int j = 0; j < a; j++) {
            for (int i = 0; i < size - 1; i++) {
                int future = array[size -  i - 1]; //size - i не стал в другую переменную переназначать, подумал что потом могут непонятки пойти
                    array[size - i - 1] = array[size - i - 2];
                    array[size - i - 2] = future;
            }
        }
    }
}
