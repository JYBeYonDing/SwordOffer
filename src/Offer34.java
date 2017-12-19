/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
public class Offer34 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(5));
    }
    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }

        int[] uglyNumbers = new int[index];//存放丑数
        uglyNumbers[0] = 1;
        int nextUnlyIndex = 1;

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        while (nextUnlyIndex < index) {
            uglyNumbers[nextUnlyIndex] = minUgly(uglyNumbers[index2] * 2,
                    uglyNumbers[index3] * 3,
                    uglyNumbers[index5] * 5);
            while (uglyNumbers[index2] * 2 <= uglyNumbers[nextUnlyIndex]) {
                index2++;
            }
            while (uglyNumbers[index3] * 3 <= uglyNumbers[nextUnlyIndex]) {
                index3++;
            }
            while (uglyNumbers[index5] * 5 <= uglyNumbers[nextUnlyIndex]) {
                index5++;
            }

            nextUnlyIndex++;
        }

        return uglyNumbers[index - 1];
    }

    private static int minUgly(int i2, int i3, int i5) {
        int min = i2 < i3 ? i2 : i3;
        return min < i5 ? min : i5;
    }
}
