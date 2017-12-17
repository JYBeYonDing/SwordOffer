/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class Offer29 {
    public static void main(String[] args) {
        int[] array = {1, 3, 3, 2, 3,3,3, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        int result = 0;
        int num = 1;
        if (array == null) {
            return 0;
        }

        for(int i =0;i<array.length ;i++) {
            if (array[i] != result) {
                num--;
            } else {
                num++;
            }

            if (num == 0) {
                result = array[i];
                num = 1;
            }
        }

        if (!checkMoreThanHalf(array,result)) {
            result = 0;
        }
        return result;
    }

    private static boolean checkMoreThanHalf(int[] array,int result) {
        int num = 0;
        for(int i = 0 ; i<array.length ; i++) {
            if (array[i] == result) {
                num++;
            }
        }
        if (num > array.length >> 1) {
            return true;
        } else {
            return false;
        }
    }
}
