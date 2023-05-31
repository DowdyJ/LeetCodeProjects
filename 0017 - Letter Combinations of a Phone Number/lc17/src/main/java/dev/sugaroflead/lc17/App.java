package dev.sugaroflead.lc17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App 
{

    class NumberNode {
        public NumberNode(char val, NumberNode next) {
            this.val = val;
            this.next = next;
        }

        public NumberNode next = null;
        public char val;
        public boolean headVal = false;
    }


    static Map<Character, NumberNode> numberData = new HashMap<>();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App a = new App();
        for (String s : a.letterCombinations("25883"))
            System.out.println(s);
    }

    public List<String> letterCombinations(String digits) {

        List<String> returnList = new ArrayList<>();

        if (digits.length() == 0)
            return returnList;

        if (numberData.size() == 0) {
            inializeNumberData();
        }

        NumberNode[] value = new NumberNode[digits.length()];
        for (int i = 0; i < digits.length(); ++i) {
            value[i] = numberData.get(digits.charAt(i));
        }

        for (;;) {
            returnList.add(concatNumberNodeValues(value));
            incrementNodeNumberValues(value);
            
            if (shouldStop(value))
                break;
        }

        returnList.add(concatNumberNodeValues(value));

        return returnList;
    }

    private boolean shouldStop(NumberNode[] nums) {
        for (NumberNode num : nums)
            if (!num.next.headVal)
                return false;

        return true;
    }

    private void incrementNodeNumberValues(NumberNode[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            
            if (!nums[i].next.headVal) {
                nums[i] = nums[i].next;
                break;
            } else {
                nums[i] = nums[i].next;
            }
        }
    }

    private String concatNumberNodeValues(NumberNode[] nums) {
        StringBuilder result = new StringBuilder();
        for (NumberNode num : nums) {
            result.append(num.val);
        }

        return result.toString();
    }

    private void inializeNumberData() {
        NumberNode data2_3 = new NumberNode('c', null);
        NumberNode data2_2 = new NumberNode('b', data2_3);
        NumberNode data2_1 = new NumberNode('a', data2_2);
        data2_1.headVal = true;
        data2_3.next = data2_1;

        NumberNode data3_3 = new NumberNode('f', null);
        NumberNode data3_2 = new NumberNode('e', data3_3);
        NumberNode data3_1 = new NumberNode('d', data3_2);
        data3_1.headVal = true;
        data3_3.next = data3_1;

        NumberNode data4_3 = new NumberNode('i', null);
        NumberNode data4_2 = new NumberNode('h', data4_3);
        NumberNode data4_1 = new NumberNode('g', data4_2);
        data4_1.headVal = true;
        data4_3.next = data4_1;


        NumberNode data5_3 = new NumberNode('l', null);
        NumberNode data5_2 = new NumberNode('k', data5_3);
        NumberNode data5_1 = new NumberNode('j', data5_2);
        data5_1.headVal = true;
        data5_3.next = data5_1;


        NumberNode data6_3 = new NumberNode('o', null);
        NumberNode data6_2 = new NumberNode('n', data6_3);
        NumberNode data6_1 = new NumberNode('m', data6_2);
        data6_1.headVal = true;
        data6_3.next = data6_1;

        NumberNode data7_4 = new NumberNode('s', null);
        NumberNode data7_3 = new NumberNode('r', data7_4);
        NumberNode data7_2 = new NumberNode('q', data7_3);
        NumberNode data7_1 = new NumberNode('p', data7_2);
        data7_1.headVal = true;        
        data7_4.next = data7_1;



        NumberNode data8_3 = new NumberNode('v', null);
        NumberNode data8_2 = new NumberNode('u', data8_3);
        NumberNode data8_1 = new NumberNode('t', data8_2);
        data8_1.headVal = true;
        data8_3.next = data8_1;


        NumberNode data9_4 = new NumberNode('z', null);
        NumberNode data9_3 = new NumberNode('y', data9_4);
        NumberNode data9_2 = new NumberNode('x', data9_3);
        NumberNode data9_1 = new NumberNode('w', data9_2);
        data9_1.headVal = true;
        data9_4.next = data9_1;

        numberData.put('2', data2_1);
        numberData.put('3', data3_1);
        numberData.put('4', data4_1);
        numberData.put('5', data5_1);
        numberData.put('6', data6_1);
        numberData.put('7', data7_1);
        numberData.put('8', data8_1);
        numberData.put('9', data9_1);
    }
}
