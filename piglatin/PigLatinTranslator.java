public class PigLatinTranslator {
    private static final String VOWELS = "aeiou";

    public static String translate(String input) {
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(translateWord(word)).append(" ");
        }

        return result.toString().trim();
    }

    private static String translateWord(String word) {
        if (word.isEmpty()) return "";

        if (startsWithVowel(word)) {
            return word + "way";
        } else {
            return word.substring(1) + word.charAt(0) + "ay";
        }
    }

    private static boolean startsWithVowel(String word) {
        String lowerCaseWord = word.toLowerCase();
        return VOWELS.indexOf(lowerCaseWord.charAt(0)) != -1;
    }
}