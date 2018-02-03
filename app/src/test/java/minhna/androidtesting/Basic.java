package minhna.androidtesting;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Minh on 2/3/2018.
 */

public class Basic {
    @Test
    public void test() {
        Assert.assertEquals(isPrimeNumber(5), true);
        Assert.assertEquals(isPrimeNumber(100), false);
        Assert.assertEquals(isPrimeNumber(83), true);

        emulSortAlphabetically();
    }

    public boolean isPrimeNumber(int n) {
        if (n < 2)
            return false;
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void emulSortAlphabetically()  {
        ArrayList<String> list = new ArrayList<>();
        list.add("Kim");
        list.add("Dan");
        list.add("dan");
        list.add("minh");
        list.sort((p1, p2) -> p1.compareTo(p2));
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
