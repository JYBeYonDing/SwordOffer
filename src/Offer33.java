import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Offer33 {
    public static void main(String[] args) {
        System.out.println(PrintMinNumber(new int[]{3,32,321}));
    }
    public static String PrintMinNumber(int [] numbers) {
        String[] result = new String[numbers.length];
        for (int i =0 ; i<numbers.length; i++) {
            result[i] = numbers[i]+"";
        }

        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        String res = "";
        for (String s : result) {
            res += s;
        }
        return res;
    }
}
