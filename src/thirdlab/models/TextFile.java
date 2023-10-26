package thirdlab.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TextFile {

    public void getTextFileInfo(String filePath) {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Line count = " + lineCount);
        System.out.println("Word count = " + wordCount);
        System.out.println("Character count = " + charCount);
    }
}
