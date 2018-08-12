package minhna.androidtesting;

/**
 * * Created by Minh on 8/12/2018
 **/

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Display all the most appearances of items on list which contains list
 */
public class FrequenceTest {
    
    @Test
    public void test1() {
        List<List<String>> parentList = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        
        list1.add("blue");
        list1.add("blue");
        list1.add("blue");
        list1.add("blue");
        
        list2.add("blue");
        list2.add("blue");
        list2.add("blue");
        list2.add("blue");
        
        list3.add("blue");
        list3.add("blue");
        list3.add("blue");
        list3.add("blue");

        parentList.add(list1);
        parentList.add(list2);
        parentList.add(list3);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("blue");
        Assert.assertEquals(true, checkSameList(expectedResult, getMostFrequency(parentList)));
    }

    @Test
    public void test2() {
        List<List<String>> parentList = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        list1.add("green");
        list1.add("blue");
        list1.add("yellow");
        list1.add("blue");

        list2.add("orange");
        list2.add("green");
        list2.add("green");
        list2.add("green");

        list3.add("blue");
        list3.add("yellow");
        list3.add("black");
        list3.add("orange");
        list3.add("orange");

        parentList.add(list1);
        parentList.add(list2);
        parentList.add(list3);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("green");
        Assert.assertEquals(true, checkSameList(expectedResult, getMostFrequency(parentList)));
    }

    @Test
    public void test3() {
        List<List<String>> parentList = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        list1.add("orange");
        list1.add("red");
        list1.add("red");
        list1.add("blue");

        list2.add("yellow");
        list2.add("black");
        list2.add("white");
        list2.add("green");

        list3.add("blue");
        list3.add("orange");
        list3.add("black");
        list3.add("white");

        parentList.add(list1);
        parentList.add(list2);
        parentList.add(list3);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("orange");
        expectedResult.add("red");
        expectedResult.add("blue");
        expectedResult.add("white");
        expectedResult.add("black");
        Assert.assertEquals(true, checkSameList(expectedResult, getMostFrequency(parentList)));
    }

    private boolean checkSameList(List<String> expectedResult, List<String> mostFrequency) {
        if (expectedResult.equals(mostFrequency)) return true; // operator '==' is not correct in this scenario
        else return false;
    }

    public List<String> getMostFrequency(List<List<String>> list) {
        List<String> result = new ArrayList<>();
        Map colorFreqMap = new HashMap<String, Integer>();
        int mostCount = 0;

        for (List<String> items: list) {
            for (String item: items) {
                Integer colorCount = colorFreqMap.containsKey(item) ?
                        (Integer) colorFreqMap.get(item) + 1 : 0;
                if (mostCount < colorCount)
                    mostCount = colorCount;
                colorFreqMap.put(item, colorCount);
            }
        }

        if (colorFreqMap.containsValue(mostCount)) {
            for (Object item: colorFreqMap.entrySet()) {
                Map.Entry entry = (Map.Entry<String, Integer>) item;
                if ((int) entry.getValue() == mostCount) 
                    result.add(entry.getKey().toString());
            }
        }

        return result;
    }
}
