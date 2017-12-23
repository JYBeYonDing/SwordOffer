/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Offer38 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 4, 4, 5};
        System.out.println(GetNumberOfK(array,4));
    }
    public static int GetNumberOfK(int [] array , int k) {
        int last = getLastK(array, k, 0, array.length - 1);
        int first = getFirstK(array, k, 0, array.length - 1);
        if (last != -1) {
            return last - first + 1;
        } else {
            return 0;
        }
    }

    private static int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        int midData = array[mid];

        if (midData == k) {
            if (mid > 0 && array[mid - 1] == k) {
                end = mid - 1;
            } else {
                return mid;
            }
        } else if (midData > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getFirstK(array, k, start, end);
    }

    private static int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        int midData = array[mid];

        if (midData == k) {
            if (mid < array.length-1 && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
        } else if (midData > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getLastK(array, k, start, end);
    }
}
