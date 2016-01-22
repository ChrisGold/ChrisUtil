package de.ChrisGold.ChrisUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Christian Goldapp
 */
public class IO {

    public static boolean writeToFile(File file, String content) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean writeToFile(File file, byte[] bytes) {
        return writeToFile(file, new String(bytes));
    }

    public static boolean writeToFile(String filename, String content) {
        return writeToFile(new File(filename), content);
    }

    public static boolean writeToFile(String filename, byte[] bytes) {
        return writeToFile(new File(filename), new String(bytes));
    }

    public static String readFile(String filename){
        return readFile(new File(filename));
    }

    public static String readFile(File file){
        String str = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            str = new String(data, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String[] readLinesFromFile(File file){
        try {
            List<String> lines = Files.readAllLines(Paths.get("file"), StandardCharsets.UTF_8);
            return lines.toArray(new String[lines.size()]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] loadFile(File file){
        byte[] data = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static byte[] loadFile(String filename){
        return loadFile(new File(filename));
    }

}
