package com.example.assignment1_javafilecounter;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JavaFileCounter {

    public static void main(String[] args) {
        // ✅ Replace this with your actual folder path
        String directoryPath = "C:/Users/muham/IdeaProjects/Assignment1_JavaFileCounter/src/main/java/com/example/assignment1_javafilecounter";


        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles();

        int javaFileCount = 0;
        int issueCount = 0;

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    javaFileCount++;
                    try {
                        String content = new String(Files.readAllBytes(file.toPath()));
                        if (content.toLowerCase().contains("solved")) {
                            issueCount++;
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                }
            }
        }

        System.out.println("Number of Java Files = " + javaFileCount);
        System.out.println("Number of Issues = " + issueCount);
    }
}
