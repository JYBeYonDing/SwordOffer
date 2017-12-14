
public class Offer4 {
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int p1 = str.length()-1;//p1指向数组的最后一位
        int spaceNum = 0;
        char[] cArr = str.toString().toCharArray();
        for (char c : cArr) {
            if (c == ' ') {
                spaceNum++;
            }
        }
        int p2 = p1+2*spaceNum; //p2指向最终替换后数组的最后一位
        char[] cArr2 = new char[p2+1];
        for(;p1>=0;p1--) {
            if (cArr[p1] == ' ') {
                cArr2[p2--] = '0';
                cArr2[p2--] = '2';
                cArr2[p2--] = '%';
            } else {
                cArr2[p2--] = cArr[p1];
            }
        }
        return String.valueOf(cArr2);
    }

    public static void main(String[] args) {
//        for (char c : replaceSpace(new StringBuffer("we are happy"))) {
//            System.out.println(c);
//        }
        System.out.println(replaceSpace(new StringBuffer("we are happy")));

    }
}
