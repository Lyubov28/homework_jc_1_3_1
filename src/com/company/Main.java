package com.company;

import java.io.*;

public class Main {
    static String directory = "C:\\Users\\Akimo\\OneDrive\\Рабочий стол\\Games\\";
    static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        developmentDirectory("src");
        developmentDirectory("res");
        developmentDirectory("savegames");
        developmentDirectory("temp");
        developmentDirectory("src/main");
        developmentDirectory("src/test");
        developmentFile("src/main/Main.java");
        developmentFile("src/main/Utils.java");
        developmentDirectory("res/drawables");
        developmentDirectory("res/vectors");
        developmentDirectory("res/icons");
        developmentFile("temp/temp.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "temp/temp.txt"))) {
            writer.write(log.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static String logResult(Boolean positively, File tipe, String name) {
        if (tipe.isDirectory()) {
            return positively ? "Каталог " + name + " создан" : "Каталог " + name + " не создан";
        } else {
            return positively ? "Файл " + name + " создан" : "Файл " + name + " не создан";
        }
    }

    static void developmentDirectory(String name) {
        File dir = new File(directory + name);
        log.append(logResult(dir.mkdir(), dir, name)).append("\n");
    }

    static void developmentFile(String name) {
        File file = new File(directory + name);
        try {
            log.append(logResult(file.createNewFile(), file, name)).append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

