/**
 * 在牛客网上没有全部通过
 *
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *
 * 输入描述:
     题目保证输入的数组中没有的相同的数字
   数据范围：
     对于%50的数据,size<=10^4
     对于%75的数据,size<=10^5
     对于%100的数据,size<=2*10^5

 示例1
     输入
     1,2,3,4,5,6,7,0
     输出
     7
 */
public class Offer36 {
    public static void main(String[] args) {
        System.out.println(InversePairs(new int[]{4,9,3,3,3,0,2,7,7}));
    }

    public static int InversePairs(int [] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int[] copy = new int[array.length];
        for(int i=0; i<array.length; i++) {
            copy[i] = array[i];
        }
        int count = inversePairs(array, copy, 0, array.length - 1);
        return count;
    }

    private static int inversePairs(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }

        int length = (end - start) / 2+1;

        int left = inversePairs(copy, array, start, start + length-1);
        int right = inversePairs(copy, array, start + length, end);

        int i = start + length-1;
        int j = end;

        int indexCopy = end;

        int count = 0;

        while (i >= start && j >= start + length) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - start - length+1;
            } else {
                copy[indexCopy--] = array[j--];
            }
        }

        for(;i>=start;--i) {
            copy[indexCopy--] = array[i];
        }
        for(;j>=start+length;--j) {
            copy[indexCopy--] = array[j];
        }
        return left+right+count;
    }
}
