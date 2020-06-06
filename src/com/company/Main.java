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



    public static void initialMap(){
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                map[y][x] = DOT_EMPTY;
            }
        }
    }

    public static void printGameMap() {
        for (int i = 0; i < map.length + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int y = 0; y < map.length; y++) {
            System.out.print(y + 1 + " ");
            for (int i = 0; i < map.length; i++) {
                System.out.print(map[y][i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        newGame();

        while (true) {
            humanTurn();
            if (isEndGame(DOT_HUMAN)) break;

            countForGame();
            if (isEndGame(DOT_COMPUTER)) break;
        }

    }
    public static void newGame(){
        System.out.println("Введите размерность поля: ");
        mapSize = scanner.nextInt();
        System.out.println("Введите какое количество фишек необходимо для выигрыша: ");
        checkWinCount = scanner.nextInt();

        map = new char[mapSize][mapSize];
        initialMap();
        printGameMap();
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты вашего хода через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isNotCorrect(x , y));
        map[y][x] = DOT_HUMAN;
        printGameMap();
    }

    public static boolean isEndGame(char symbol) {
        if (isCheckWin(symbol)) {
            System.out.println("Игра окончена. Выиграл: " + symbol);
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }


    public static boolean isCheckWin(char symbol) {
        int sizeLineUp = 0;
        int sizeLineRight = 0;
        int diagonalCheckCount1 = 0;
        int diagonalCheckCount2 = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {

                if (map[i][j] == symbol) sizeLineRight++;
                else sizeLineRight = 0;

                if (map[j][i] == symbol) sizeLineUp++;
                else sizeLineUp = 0;

                if (i == 0) {
                    if (map[j][j] == symbol) diagonalCheckCount1++;
                    else diagonalCheckCount1 = 0;

                    if (map[map.length - j - 1][j] == symbol) diagonalCheckCount2++;
                    else diagonalCheckCount2 = 0;

                    if (diagonalCheckCount1 == checkWinCount || diagonalCheckCount2 == checkWinCount
                            || sizeLineRight == checkWinCount || sizeLineUp == checkWinCount) return true;
                }
            }
        }
        return false;
    }

    public static boolean isMapFull(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void computerTurn(){  //stupid
        int x, y;
        do {
            x = (int)(Math.random() * (map.length));
            y = (int)(Math.random() * (map.length));
        } while (isNotCorrect(x, y));
        map[x][y] = DOT_COMPUTER;
        System.out.println("Компьютер сделал свой ход: " + (x + 1) + " " + (y + 1));
        printGameMap();
    }

//    public static boolean isCorrectGood(int x, int y){
//        if (!isNotCorrect(y,x)) {
//            map[x][y] = DOT_COMPUTER;
//            forBreak = 0;
//            return true;
//        }
//        else return false;
//    }
//    public static void intellectComputerTurn(){
//        int x, y;
//        int count = 0;
//        int max = 0;
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map.length; j++) {
//                if (map[i][j] == DOT_HUMAN) {
//                    if (isCorrectGood(i, j + 1)) break;
//                    if (isCorrectGood(i - 1, j + 1)) break;
//                    if (isCorrectGood(i - 1, j )) break;
//                    if (isCorrectGood(i + 1, j )) break;
//                    if (isCorrectGood(i + 1, j - 1)) break;
//                    if (isCorrectGood(i , j - 1)) break;
//                    if (isCorrectGood(i - 1, j - 1)) break;
//                    if (isCorrectGood(i + 1, j + 1)) break;
//
//                }
//            }
//            if (forBreak == 0) {
//                System.out.println("Компьютер сделал свой ход: ");
//                printGameMap();
//                forBreak = 1;
//                break;
//            }
//        }
//    }

    public static boolean isNotCorrect(int x,int y) {
        if (x >= mapSize || x < 0 || y >= mapSize || y < 0) return true;
        if (map[y][x] == DOT_EMPTY) return false;
        else return true;
    }

    public static void countForGame() { //по линиям
        boolean result = false;
        int x = 0;
        int y = 0;
        int max = 0;
        int point = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == DOT_EMPTY)
                {
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
                    if (checkPoint(i - 1, j + 1)) //диагональ 1
                    {
                        point++;
                    }
                    if (checkPoint(i + 1, j - 1)) //диагональ 1
                    {
                        point++;
                    }
                }
                if (point > max)
                {
                    y = j;
                    x = i;
                    max = point;
                    result = true;
                }
                point = 0;
            }
        }
        if (!result)
        {
            do {
                x = (int)(Math.random() * (map.length));
                y = (int)(Math.random() * (map.length));
            } while (isNotCorrect(x, y));
        }
        map[y][x] = DOT_COMPUTER;
        System.out.println("Компьютер сделал свой ход: " + (y + 1) + " " + (x + 1));
        printGameMap();
    }

    public static boolean checkPoint(int x, int y) {
        boolean result = false;
        if (x >= mapSize || x < 0 || y >= mapSize || y < 0)
            result =  false;
        else if (map[y][x] == DOT_EMPTY)
            result = true;

        return result;
    }


}
