public class Offer9 {
    public int Fibonacci(int n) {
//        if (n == 0) {
//            return 0;
//        } else if (n == 1) {
//            return 1;
//        } else if (n > 1) {
//            return Fibonacci(n - 1) + Fibonacci(n - 2);
//        }else{
//            return 0 ;
//        }

        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            b = a+b;
            a = b-a;
        }

        return a;
    }
}
