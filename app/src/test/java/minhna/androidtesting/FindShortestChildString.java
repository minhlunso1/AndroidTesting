package minhna.androidtesting;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 06-Sep-17.
 */

/**
 * Find the shortest child string that contains all chars of the original string
 */
public class FindShortestChildString {
    String input = "abaaccaababbccabbc";

    /**
     * To saving time, compare CharSequence by their total value. Correct in the most of cases.
     */
    public class MyChars {
        int length;
        int totalValue;

        public MyChars(int length, int totalValue) {
            this.length = length;
            this.totalValue = totalValue;
        }
    }

    public MyChars getChildString(String input) {
        int totalValue = 0;
        List<Character> charStrContains = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (canAddCharStrContain(charStrContains, input.charAt(i))) {
                charStrContains.add(input.charAt(i));
                totalValue += input.charAt(i);
            }
        }
        return new MyChars(charStrContains.size(), totalValue);
    }

    @Test
    public void testShortestChildStr() {
        String output = getShortestChild();
        Assert.assertEquals("cab", output);
    }

    public String getShortestChild() {
        MyChars charsToCompare = getChildString(input);
        char[] cArr = input.toCharArray();
        for (int i =  0; i < cArr.length; i++) {
            if (i + charsToCompare.length > cArr.length)
                return null;//not found
            else {
                String myStr = "";
                for (int j = 0; j < charsToCompare.length; j++)
                    myStr += cArr[i+j];
                if (hasSameCharacters(charsToCompare, myStr))
                    return myStr;
            }
        }
        return null;
    }

    private boolean hasSameCharacters(MyChars charsToCompare, String findStr) {
        MyChars charsFind = getChildString(findStr);
        if (charsToCompare.totalValue == charsFind.totalValue)
            return true;
        else
            return false;
    }

    private boolean canAddCharStrContain(List<Character> charStrContains, char c) {
        boolean flag = true;
        for (Character tmp: charStrContains) {
            if (tmp == c) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
