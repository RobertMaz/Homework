package com.company;

import java.util.Scanner;

public class Main {

    public static final char DOT_EMPTY = ' ';
    public static final char DOT_HUMAN = 'X';
    public static final char DOT_COMPUTER = 'O';
    public static int checkWinCount;
    public static int mapSize;
    public static char[][] map;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        newGame();

        while (true) {
            humanTurn();
            if (isEndGame(DOT_HUMAN)) break;

            computerTurn();
            if (isEndGame(DOT_COMPUTER)) break;
        }

    }

    public static void newGame() {
        /*Создаем игровое поле*/
        System.out.println("Введите размерность поля: ");
        mapSize = scanner.nextInt();
        System.out.println("Введите какое количество фишек необходимо для выигрыша: ");
        checkWinCount = scanner.nextInt();

        map = new char[mapSize][mapSize];
        initialMap();
        printGameMap();
    }

    public static void initialMap() {
        /*Инициализируем игровое поле*/
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                map[y][x] = DOT_EMPTY;
            }
        }
    }

    public static void printGameMap() {
        /*Метод для печати игрового поля*/

        for (int i = 0; i < map.length + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int y = 0; y < map.length; y++) {
            System.out.print(y + 1 + " ");
            for (int x = 0; x < map.length; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        /*Ход человека*/
        int x, y;
        do {
            System.out.println("Введите координаты вашего хода через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isNotCorrect(x, y));
        map[y][x] = DOT_HUMAN;
        printGameMap();
    }

    public static boolean isEndGame(char symbol) {
        /*Проверка на выигрыш и окончание игры*/
        boolean result = false;
        if (isCheckWin(symbol)) {
            System.out.println("Игра окончена. Выиграл: " + symbol);
            result = true;
        }
        else if (isMapFull()) {
            System.out.println("Ничья");
            result =  true;
        }
        return result;
    }

    public static boolean isCheckWin(char symbol) {
        /*Метод для проверки выигрыша*/
        for (int i = 0; i < map.length; i++) {
            int sizeLineUp = 0;//тут будем считать количество одинаковых фишек в высоту
            int sizeLineRight = 0;//тут по краям
            int diagonalCheckCount1 = 0;//тут первая диагональ
            int diagonalCheckCount2 = 0;//тут вторая диагональ
            /*После каждого внешнего цикла сбрасываем их*/

            for (int j = 0; j < map.length; j++) {

                if (map[i][j] == symbol) sizeLineRight++;
                else sizeLineRight = 0;

                if (map[j][i] == symbol) sizeLineUp++;
                else sizeLineUp = 0;

                if (i == 0) { /*Диагонали будем проверять только в одном внешнем цикле, поэтому условие == 0  и я проверяю только две центральные диагонали*/
                    if (map[j][j] == symbol) diagonalCheckCount1++;
                    else diagonalCheckCount1 = 0;

                    if (map[map.length - j - 1][j] == symbol) diagonalCheckCount2++;
                    else diagonalCheckCount2 = 0;
                }
                /*Если хотя бы одна линия равна длине которая хватает для выигрыша, то возвращаем победу*/
                if (diagonalCheckCount1 == checkWinCount || diagonalCheckCount2 == checkWinCount
                        || sizeLineRight == checkWinCount || sizeLineUp == checkWinCount) return true;
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        /*Если есть хотя бы одно пустое место то возвращаем false*/
        for (char[] chars : map) {
            for (int j = 0; j < map.length; j++) {
                if (chars[j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean isNotCorrect(int x, int y) {
        if (x >= mapSize || x < 0 || y >= mapSize || y < 0) return true;
        return map[y][x] != DOT_EMPTY;
    }

    public static boolean checkPoint(int x, int y) {
        /*это метод для метода computerTurn для проверки ячейки*/
        boolean result = false;
        if (!(x >= mapSize || x < 0 || y >= mapSize || y < 0) &&(map[y][x] == DOT_COMPUTER)) result = true;
        return result;
    }

    public static void computerTurn() {
        /*В этом методе компьютер ходит только в соседнюю свою клетку*/
        boolean result = false;
        int x = 0;
        int y = 0;
        int max = 0;
        int point = 0; //счетчик для количества соседних клеток рядом

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == DOT_EMPTY) {
                    /*Тут пробегаемся по каждой соседней клетке и если находим нашу, то счетчик увеличиваем*/
                    if (checkPoint(i, j + 1)) // вверх
                    {
                        point++;
                    }
                    if (checkPoint(i, j - 1)) //вниз
                    {
                        point++;
                    }
                    if (checkPoint(i + 1, j)) //право
                    {
                        point++;
                    }
                    if (checkPoint(i - 1, j)) //лево
                    {
                        point++;
                    }
                    if (checkPoint(i - 1, j - 1)) //диагональ 1
                    {
                        point++;
                    }
                    if (checkPoint(i + 1, j + 1)) //диагональ 2
                    {
                        point++;
                    }
                    if (checkPoint(i - 1, j + 1)) //диагональ 3
                    {
                        point++;
                    }
                    if (checkPoint(i + 1, j - 1)) //диагональ 4
                    {
                        point++;
                    }
                }

                if (point > max) {
                    y = j;
                    x = i;
                    max = point;
                    result = true; //если была клетка по соседству с нашей, то фиксируем ее
                }
                point = 0;
            }
        }

        if (!result) { //Это если нет ни одной пустой клетки рядом с нашей клеткой
            do {
                x = (int) (Math.random() * (map.length));
                y = (int) (Math.random() * (map.length));
            } while (isNotCorrect(x, y));
        }
        map[y][x] = DOT_COMPUTER;
        System.out.println("Компьютер сделал свой ход: " + (y + 1) + " " + (x + 1));
        printGameMap();
    }

}
