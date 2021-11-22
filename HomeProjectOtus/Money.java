package HomeProjectOtus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Money {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long howMuchMoney = sc.nextLong();
        try {
            if (howMuchMoney<0 )//|| howMuchMoney <= 1000000000000) если добавляю это условие, выдает ошибку, якобы больше  Integer, хотя это long
                throw new NegativNumberEcxeption("Error");
        } catch (NegativNumberEcxeption e) {
            System.out.println("Введите положительное число");
        }

            String[][] sex = {
                    {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
                    {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            };

            String[] strings11 = {"", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
                    "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать"};

            String[] strings10 = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
                    "семьдесят", "восемьдесят", "девяносто"};

            String[] strings100 = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
                    "восемьсот", "девятьсот"};

            String[][] forms = {

                    {"тысяча", "тысячи", "тысяч", "1"},
                    {"миллион", "миллиона", "миллионов", "1"},
                    {"миллиард", "миллиарда", "миллиардов", "1"},
                    {"триллион", "триллиона", "триллионов", "0"},
                    {"триллион", "триллиона", "триллионов", "0"},

            };

            long amount = howMuchMoney;

            // Разбиваем сумму на части по 3 цифры с конца
            ArrayList<Long> parts = new ArrayList();
            while (amount > 999) {
                long part = amount / 1000;
                parts.add(amount % 1000);
                amount = part; //получаем массив типа [73,974,564]
            }

            parts.add(amount);
            Collections.reverse(parts);

            // Анализируем сегменты
            StringBuilder results = new StringBuilder();
            if (howMuchMoney == 0) {// если введен Ноль
                results = new StringBuilder("ноль");
            }
            // если сумма больше нуля
            int lev = parts.size();
            for (Long part : parts) {// перебираем части числа
                // lev--;

                // определяем род

                long gender = (long) Long.parseLong(forms[lev][3]);
                lev--;
                String rs = String.valueOf(part); // преобразуем число в строку
                // нормализация
                if (rs.length() == 1) rs = "00" + rs;// добавляем 00 в префикс, если есть необходимость
                if (rs.length() == 2) rs = "0" + rs; // или 0, если двухзначное

                long r1 = Long.parseLong(rs.substring(0, 1)); //первая цифра фрагмента
                long r2 = Long.parseLong(rs.substring(1, 2)); //вторая цифра
                long r3 = Long.parseLong(rs.substring(2, 3)); //третья цифра
                long r23 = Long.parseLong(rs.substring(1, 3)); //вторая и третья

                if (part > 99) results.append(strings100[(int) r1]).append(" "); // Сотни
                if (r23 > 20) {// >20
                    results.append(strings10[(int) r2]).append(" ");
                    results.append(sex[(int) gender][(int) r3]).append(" ");
                } else { // если число <=20
                    if (r23 > 9) results.append(strings11[(int) (r23 - 9)]).append(" "); // от 10-20
                    else results.append(sex[(int) gender][(int) r3]).append(" "); // от 0-9
                }

                // Единицы измерения
                if (lev != 0) {
                    results.append(Utils.UtilsRubles(part, forms[lev - 1][0], forms[lev - 1][1], forms[lev - 1][2])).append(" ");
                } else {
                    long lastNumber = part % 10;
                    results.append(Rubles.rublesForms(lastNumber));
                }
            }

            System.out.println(results);
        }
    }
