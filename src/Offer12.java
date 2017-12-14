/**
 * 打印1到最大的n位数
 */
public class Offer12 {
    public static void main(String[] args) {
        int  n = 3;
        print1ToMaxOfNDigits(n);
    }

    private static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];

        for(int i = 0; i<10; i++) {
            number[0] =(char)(i + '0');
            print1ToMaxOfNDigitsRecursively(number, n, 0);
        }

    }

    private static void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            printNumber(number);
            return;
        }

        for(int i = 0; i<10; ++i) {
            number[index + 1] = (char)(i + '0');
            print1ToMaxOfNDigitsRecursively(number,length,index+1);
        }
    }

    private static void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;

        for(int i=0;i<nLength;i++) {
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }

            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
}
