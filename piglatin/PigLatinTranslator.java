package piglatin;
public class PigLatinTranslator {
    public static String translate(String input) {
        if (input == null) {
            return null;
        }
//potato
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(translateWord(word)).append(" ");
        }

        return result.toString().trim();
    }

    private static String translateWord(String word) {
        if (word == null) {
            return null;
        }

        String VOWELS = "aeiouyAEIOUY";
        String punctuation = "";

        if (word.length() > 0 && !Character.isLetter(word.charAt(word.length() - 1))) {
            punctuation = String.valueOf(word.charAt(word.length() - 1));
            word = word.substring(0, word.length() - 1);
        }

        if (word.isEmpty()) {
            return punctuation;
        }

        boolean wasCapitalized = Character.isUpperCase(word.charAt(0));

        String result = "";
        if (VOWELS.indexOf(Character.toLowerCase(word.charAt(0))) != -1) {
            result = word + "ay";
        } else {
            int index = 0;
            while (index < word.length() && VOWELS.indexOf(Character.toLowerCase(word.charAt(index))) == -1) {
                index++;
            }
            if (index == word.length()) {
                result = word + "ay";
            } else {
                result = word.substring(index) + word.substring(0, index) + "ay";
            }
        }

        result += punctuation;

        if (wasCapitalized && result.length() > punctuation.length()) {
            result = Character.toUpperCase(result.charAt(punctuation.length())) + result.substring(punctuation.length() + 1).toLowerCase();
        } else {
            result = result.toLowerCase();
        }

        return result;
    }
}

