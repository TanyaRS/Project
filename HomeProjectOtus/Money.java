package HomeProjectOtus;

import java.util.ArrayList;
import java.util.Scanner;

public class Money {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int howMuchMoney = sc.nextInt();
        String string = String.valueOf(howMuchMoney);
        System.out.println(howMuchMoney.);

        public String num2str () //надо как то привязать к выводу в систем аут
            String[][] strings1 = {
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
                    {"рубль", "рубля", "рублей"},
                    {"тысяча", "тысячи", "тысяч"},
                    {"миллион", "миллиона", "миллионов"},
                    {"миллиард", "миллиарда", "миллиардов"},
                    {"триллион", "триллиона", "триллионов"},
            };
            long amount = howMuchMoney;
            // Разбиваем сумму на части по 3 цифры с конца
            ArrayList parts = new ArrayList();
            while (amount > 999) {
                long part = amount / 1000;
                parts.add(amount - (part * 1000));
                amount = part; //получаем массив типа [73,974,564]
            }
            parts.add(amount);
            // Анализируем сегменты
            String o = "";
            if (howMuchMoney == 0) {// если введен Ноль
                o = "ноль";
            }
                // если сумма больше нуля
                int lev = parts.size();
                for (int i = 0; i < parts.size(); i++) {// перебираем части числа
                    int gender = Integer.parseInt(forms[lev][3]);// определяем род
                    int thisi = (int) Integer.parseInt(parts.get(i).toString());// текущий фрагмент части числа
                    if (thisi == 0 && lev > 1) {// если фрагмент равен 0
                        lev--;
                        continue;
                    }
                    String rs = String.valueOf(thisi); // преобразуем число в строку
                    // нормализация
                    if (rs.length() == 1) rs = "00" + rs;// добавляем 00 в префикс, если есть необходимость
                    if (rs.length() == 2) rs = "0" + rs; // или 0, если двухзначное

                    int r1 = (int) Integer.valueOf(rs.substring(0, 1)); //первая цифра фрагмента
                    int r2 = (int) Integer.valueOf(rs.substring(1, 2)); //вторая цифра
                    int r3 = (int) Integer.valueOf(rs.substring(2, 3)); //третья цифра
                    int r22 = (int) Integer.valueOf(rs.substring(1, 3)); //вторая и третья

                    if (thisi > 99) o += strings100[r1] + " "; // Сотни
                    if (r22 > 20) {// >20
                        o += strings10[r2] + " ";
                        o += strings1[gender][r3] + " ";
                    } else { // если число <=20
                        if (r22 > 9) o += strings11[r22 - 9] + " "; // от 10-20
                        else o += strings1[gender][r3] + " "; // от 0-9
                    }

                }


            }
        }
    }
