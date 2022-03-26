package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static StringBuilder log = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String dirMain = "D://Нетология//Games//";
        String dir = dirMain + "src";
        makeDir(dir);
        makeDir(dir + "//test");
        dir = dir + "//main";
        makeDir(dir);
        makeFile(dir, "Main.java");
        makeFile(dir, "Utils.java");

        makeDir(dirMain + "res");
        makeDir(dirMain + "savegames");

        dir = dirMain + "temp";
        makeDir(dir);
        makeFile(dir, "temp.txt");

        FileWriter file = new FileWriter (dir + "//temp.txt");
        file.write(String.valueOf(log));
        file.close();
    }

    public static void makeDir(String dir) {
        File dir1 = new File(dir);
        if (dir1.mkdir()) {
            String  s  = "Создан каталог " + dir;
            log.append(s);
            //System.out.println(s);
        } else {
            log.append("Не удалось создать каталог ").append(dir);
        }
    }

    public static void makeFile(String dir, String fname) {
        File myFile = new File(dir, fname);
// создадим новый файл
        try {
            if (myFile.createNewFile()) {
                log.append("\nСоздан файл  ").append(fname).append(" в каталоге ").append(dir);
               // System.out.println("\nФайл был создан");
            } else {
                log.append("\nНе удалось создать файл ").append(fname);
            }
        } catch (IOException ex) {
            log.append("\nНе удалось создать файл ").append(fname);
            System.out.println(ex.getMessage());
        }
    }
}

