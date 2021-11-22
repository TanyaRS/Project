package HomeProjectOtus;

public final class Utils {

    public static String UtilsRubles(long n, String f1, String f2, String f5){
        n = Math.abs(n) % 100;
        long n1 = n % 10;
        if (n > 10 && n < 20) return f5;
        if (n1 > 1 && n1 < 5) return f2;
        if (n1 == 1) return f1;

        return f5;
    }
}
