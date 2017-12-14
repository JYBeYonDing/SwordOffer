public class Offer10 {
    public int NumberOf1(int n) {
        int flag = 1;
        int num = 0;
        while (flag != 0) {
            if ((n & flag) != 0) {
                num++;
            }
            flag<<=1;
        }
        return num;
    }
}
