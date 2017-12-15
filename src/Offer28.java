import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Offer28 {
    private ArrayList<String> strs = new ArrayList<>();
    private char[] chars;
    public ArrayList<String> Permutation(String str) {
        if (str == null) {
            return this.strs;
        }
        this.chars = str.toCharArray();
        int begin = 0;
        permutation(chars, begin);
        Collections.sort(this.strs);
        return this.strs;
    }

    private void permutation(char[] chars, int begin) {
        if (begin == chars.length - 1) {
            String tempStr = new String(chars);
            if (!strs.contains(tempStr)) {
                strs.add(tempStr);
            }
        } else {
            for(int i = begin ; i<chars.length ; i++) {
                char temp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = temp;

                permutation(chars, begin + 1);

                temp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = temp;
            }
        }
    }
}
