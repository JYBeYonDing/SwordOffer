import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Offer30 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || k <= 0 || input.length <= 0 || k>input.length) {
            return new ArrayList<Integer>();
        }
        TreeSet<Integer> results = new TreeSet<>();
        for(int i = 0 ; i< input.length ; i++) {
            if (results.size() < k) {
                results.add(input[i]);
            } else {
                if (results.last() > input[i]) {
                    results.pollLast();
                    results.add(input[i]);
                }
            }
        }
        return new ArrayList<Integer>(results);
    }
}
