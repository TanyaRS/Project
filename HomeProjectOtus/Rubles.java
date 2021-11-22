package HomeProjectOtus;

public final class Rubles {
    //взять последний элемент из массива и проанализиновать на рубли и копейки.
    private static final String[] rub = {"рубль", "рубля", "рублей", "0"};

    public static String rublesForms(Long part) {
        return Utils.UtilsRubles(part, rub[0], rub[1], rub[2]);
    }
}