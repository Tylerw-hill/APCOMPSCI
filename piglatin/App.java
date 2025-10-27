package piglatin;
public class App {
    public static void main(String[] args) {
        Book book = new Book();
        book.readFromUrlAndTranslate("Romeo and Juliet", "https://www.gutenberg.org/files/1513/1513-0.txt");
    }
}