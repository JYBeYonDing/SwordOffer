/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数。
 */
public class Offer32 {
    public static void main(String[] args) {
//        System.out.println((int)Math.pow(10,2));
//        char[] nchar = String.valueOf(10).toCharArray();
//        for (char c : nchar) {
//            System.out.println(c);
//        }
        System.out.println(NumberOf1Between1AndN_Solution(55));
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }

        return numOf1(n);
    }

    private static int numOf1(int n) {
        char[] nchar = String.valueOf(n).toCharArray();

        if (nchar.length <= 0) {
            return 0;
        }
        int first = nchar[0] - '0';

        if (nchar.length == 1) {
            if (first > 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int num = 0;
        if (first > 1) {
            num = (int) Math.pow(10, nchar.length - 1);
        } else if (first == 1) {
            num = n - (int) Math.pow(10, nchar.length - 1) + 1;
        }

        int otherNum = first * (nchar.length - 1) * (int) Math.pow(10, nchar.length - 2);


        return num+otherNum+numOf1(n-first*(int) Math.pow(10, nchar.length - 1));
    }
}
