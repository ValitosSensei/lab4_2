package lab4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {

    public static String decodeMessage(String encodedMessage) {
        String[] words = encodedMessage.split("\\s");
        StringBuilder decodedMessage = new StringBuilder();

        for (String word : words) {
            String decodingMethod = determineDecodingMethod(word);
            String decodedWord = decodeWord(word, decodingMethod);
            decodedMessage.append(decodedWord).append(" ");
        }

        return decodedMessage.toString().trim();
    }

    private static String determineDecodingMethod(String word) {
        if (word.matches("[\\d]+")) {
            return "vowel";
        } else if (word.matches("[b-df-hj-np-tv-z]+")) {
            return "consonant";
        } else {
            return "unknown";
        }
    }

    private static String decodeWord(String word, String decodingMethod) {
        StringBuilder decodedWord = new StringBuilder();

        switch (decodingMethod) {
            case "vowel":
                decodedWord.append(decodeVowels(word));
                break;
            case "consonant":
                decodedWord.append(decodeConsonants(word));
                break;
            default:
                decodedWord.append(word);
        }

        return decodedWord.toString();
    }

    private static String decodeVowels(String word) {
        StringBuilder decodedWord = new StringBuilder();

        for (char letter : word.toCharArray()) {
            switch (letter) {
                case '1':
                    decodedWord.append('a');
                    break;
                case '2':
                    decodedWord.append('e');
                    break;
                case '3':
                    decodedWord.append('i');
                    break;
                case '4':
                    decodedWord.append('o');
                    break;
                case '5':
                    decodedWord.append('u');
                    break;
                default:
                    decodedWord.append(letter);
            }
        }

        return decodedWord.toString();
    }

    private static String decodeConsonants(String word) {
        StringBuilder decodedWord = new StringBuilder();

        Pattern pattern = Pattern.compile("[b-df-hj-np-tv-z]");
        Matcher matcher = pattern.matcher(word);

        while (matcher.find()) {
            char decodedLetter = (char) (matcher.group().charAt(0) - 1);
            decodedWord.append(decodedLetter);
        }

        return decodedWord.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String encodedMessage = "t2st3ng vetviph";
        String decodedMessage = decodeMessage(encodedMessage);
        System.out.println("Encoded Message: " + encodedMessage);
        System.out.println("Decoded Message: " + decodedMessage);
    }
}
