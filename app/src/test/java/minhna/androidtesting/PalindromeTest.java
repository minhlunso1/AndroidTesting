package minhna.androidtesting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 22-Aug-17.
 */

public class PalindromeTest {
    @Test
    public void isPalindrome() {
        String word = "toacattacoat";
        int wordCount = word.toCharArray().length;
        word = formatPalindrome(word);
        char[] charArray = word.toCharArray();
        String reversedWord = "";
        for (int i = charArray.length - 1; i >= 0; i--)
            reversedWord += charArray[i];

        System.out.println("Palindrome word:" + word);
        System.out.println("Characters added:" + (word.toCharArray().length - wordCount));
        Assert.assertEquals(word, reversedWord);
    }

    public String formatPalindrome(String origin) {
        String result = origin;
        if (origin != null) {
            char[] charArray = origin.toCharArray();
            String left = "";
            String right = "";
            int pivot = charArray.length / 2;
            if (charArray.length % 2 != 0) {
                for (int i = charArray.length - 1, j = 0; i > pivot; i--, j++) {
                    if (charArray[j] == charArray[i]) {
                        left += String.valueOf(charArray[j]);
                        right = String.valueOf(charArray[i]) + right;
                    } else {
                        left += String.valueOf(charArray[j]) + String.valueOf(charArray[i]);
                        right = String.valueOf(charArray[i]) + String.valueOf(charArray[j]) + right;
                    }
                }
                result = left + charArray[pivot] + right;
            } else {
                for (int i = charArray.length - 1, j = 0; i > pivot; i--, j++) {
                    if (charArray[j] == charArray[i]) {
                        left += String.valueOf(charArray[j]);
                        right = String.valueOf(charArray[i]) + right;
                    } else {
                        left += String.valueOf(charArray[j]) + String.valueOf(charArray[i]);
                        right = String.valueOf(charArray[i]) + String.valueOf(charArray[j]) + right;
                    }
                }
                result = left + right;
            }
        }
        return result;
    }
}
