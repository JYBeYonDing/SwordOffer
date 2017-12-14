/**
 * 按照牛客网上的在写，要求保证原来的相对位置，按照这种思路没写出来。
 */
public class Offer14 {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        reorderOddEven(array);
        for (int i=0;i<array.length;i++) {
            System.out.println(array[i]);
        }
//        System.out.println(array);
    }

    private static void reorderOddEven(int[] array) {
        int point1 = 0;//寻找偶数
        int point2 = 0;//寻找奇数
        int temp = 0;
        while (point1<array.length) {
            while ((array[point1] & 1) == 1 && point1<array.length-1) {
                point1++;
            }
            point2 = point1+1;
            while ((array[point2] & 1) == 0 && point2<array.length-1) {
                point2++;
            }


            temp = array[point1];
            array[point1] = array[point2];
            array[point2] = temp;
            point1++;
            point2++;
        }
    }
}
