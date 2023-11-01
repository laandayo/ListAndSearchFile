package DataAccess;
import Common.Validation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LNSDao {

    public static void actionCW() {
        System.out.println("-------- Count Word --------");
        System.out.print("Enter Path: ");
        String fileSource = Validation.checkInputPathFile();
        System.out.print("Enter Word: ");
        String word = Validation.checkInputString();
        int count = countWordInFile(fileSource, word);
        System.out.println("The number of occurrences of the word \"" + word + "\" in the file \"" + fileSource + "\" is: " + count);
    }

    public static void actionFF() {
        System.out.println("-------- Find File By Word --------");
        System.out.print("Enter Path: ");
        String path = Validation.checkInputPathFile();
        System.out.print("Enter Word: ");
        String word = Validation.checkInputString();

        List<String> files = searchFilesForWord(path, word);

        if (files.isEmpty()) {
            System.out.println("No files were found that contain the word \"" + word + "\"");
        } else {
            System.out.println("------------ File Name ------------");
            for (String file : files) {
                System.out.println("file name " + file);
            }
        }
    }


    private static int countWordInFile(String fileSource, String word) {
        int count = 0;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileSource);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] words = line.split(" ");

            for (String wordW : words) {
                if (wordW.equalsIgnoreCase(word)) {
                    count++;
                }
            }
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    private static List<String> searchFilesForWord(String path, String word) {
        List<String> files = new ArrayList<>();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    if (countWordInFile(file.getAbsolutePath(), word) != 0) {
                        files.add(file.getName());
                    }
                }
            }
        }
        return files;
    }
}
