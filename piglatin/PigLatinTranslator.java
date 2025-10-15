public class PigLatinTranslator {
    private static final String VOWELS = "aeiou";

    public static void translate(String input) {
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(translateWord(word)).append(" ");
        }

        return result.toString().trim();
    }

    private static String translateWord(String input) {
        if (input.isEmpty()) return "";

        boolean wasCapitalized = Character.isUpperCase(input.charAt(0));
        String punctuation = "";
        String word = input;

        if (!Character.isLetter(input.charAt(input.length() - 1))) {
            punctuation = input.substring(input.length() - 1);
            word = input.substring(0, input.length() - 1);
        }

        word = word.toLowerCase();
        int index = findVowelIndex(word);

        String translatedWord;
        if (index == 0) {
            translatedWord = word + "way";
        } else {
            translatedWord = word.substring(index) + word.substring(0, index) + "ay";
        }

        if (wasCapitalized) {
            translatedWord = translatedWord.substring(0, 1).toUpperCase() + translatedWord.substring(1);
        }
        return translatedWord + punctuation;
    }

    private static int findVowelIndex(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (VOWELS.indexOf(word.charAt(i)) != -1) {
                return i;
            }
        }
        return 0; 
    }

    public static Book translate(Book input) {
        Book translatedBook = new Book();

        for (String line : input.getText().split("\n")) {
            translatedBook.appendLine(translate(line));
        }

        return translatedBook;
    }
}