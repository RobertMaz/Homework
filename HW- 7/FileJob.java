import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileJob {
    public static void main(String[] args) {
        File directory = new File("src\\fileDirectory\\");
        File outFile = new File("textOther.txt");
        printToFile(directory, outFile);
        addWordToFiles(directory, "Домашка");
        System.out.println(checkWordOfFile("Создать", outFile));
        System.out.println(checkWordOfDirectory("отрицательного", directory));

    }

    /*1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
    (Файлы в пакете fileDirectory)
    2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст
    из первого файла, потом текст из второго в новый файл.*/
    public static void printToFile(File trekToDirectory, File outFileName) {
        List<File> list = arrayFiles(trekToDirectory);
        for (File file : list) {
            try (Scanner scanner = new Scanner(new File(String.valueOf(file)));
                 PrintStream printStream = new PrintStream(new FileOutputStream(outFileName, true))) {
                while (scanner.hasNextLine()) {
                    printStream.write(scanner.nextLine().getBytes());
                    printStream.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*3. * Написать программу, которая проверяет присутствует ли
    указанное пользователем слово в файле (работаем только с латиницей).*/
    public static boolean checkWordOfFile(String word, File fileName) {
        boolean result = false;
        try (Scanner scanner = new Scanner(fileName)) {
            while (scanner.hasNext()) {
                String text = scanner.next();
                if (text.equals(word)) {
                    result = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /*4. ** Написать метод, проверяющий, есть ли указанное слово в файлах в папке*/
    public static boolean checkWordOfDirectory(String word, File directory) {
        boolean result = false;
        List<File> list = arrayFiles(directory);
        for (File file : list) {
            result = checkWordOfFile(word, file);
        }
        return result;
    }

    /*5. *** Написать метод, добавляющий, указанное слово в файлы в папке*/
    public static void addWordToFiles(File directory, String word) {
        ArrayList<File> arrayList = arrayFiles(directory);
        for (File file : arrayList) {
            try (PrintStream printStream = new PrintStream(new FileOutputStream(file, true))) {
                printStream.write(word.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*Это вспомогательный метод для создания списка файлов*/
    public static ArrayList<File> arrayFiles(File directory) {
        ArrayList<File> list = new ArrayList<>();

        try {
            for (File file : directory.listFiles())
                if (file.isFile()) list.add(file);
        } catch (NullPointerException e) {
            System.out.println("В заданной директории файлы не найдены");
        }
        return list;
    }
}
