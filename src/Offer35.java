import java.util.HashMap;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置
 */
public class Offer35 {
    public static void main(String[] args) {
        String str = "abbaccdeff";
        System.out.println(FirstNotRepeatingChar(str));
    }

    public static int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();

        if (chars.length <= 0) {
            return -1;
        }

        HashMap<Character, Integer> charsMap = new HashMap<>();

        for (char c : chars) {
            int value = 0;
            if (charsMap.get(c) != null) {
                value = charsMap.get(c)+1;
            } else {
                value = 1;
            }
            charsMap.put(c, value);
        }

        for (int i = 0; i < chars.length; i++) {
            if (charsMap.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
