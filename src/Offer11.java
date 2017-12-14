public class Offer11 {
    public static void main(String[] args) {

        Math.pow(1,1);
        System.out.println(Power(2,0));
    }

    public static double Power(double base, int exponent) {
        if (equal(base, 0.0)) {
            if (exponent == 0) {
                return 1;
            } else {
                return 0;
            }
        }else{
            if (exponent == 0) {
                return 1;
            } else if (exponent < 0) {
                return 1.0 / positiveExponentPower(base, -exponent);
            } else {
                return positiveExponentPower(base, exponent);
            }
        }
    }

    private static double positiveExponentPower(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = positiveExponentPower(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result = result * base;
        }
        return result;
    }

    public static boolean equal(double a, double b) {
        if (Math.abs(a - b) < 0.000001) {
            return true;
        } else {
            return false;
        }
    }
}
