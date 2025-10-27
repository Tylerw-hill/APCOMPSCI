package piglatin;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Book {
    public void readFromUrlAndTranslate(String title, String url) {
        try {
            URL bookUrl = URI.create(url).toURL();
            Scanner scanner = new Scanner(bookUrl.openStream());
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String translatedLine = PigLatinTranslator.translate(line);
                System.out.println(translatedLine);
            }
            scanner.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}