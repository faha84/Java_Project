import java.util.Scanner;
public class Zadnew {

    public static class Opr_Znak_Ch {
        String[] zn = new String[]{"+", "-", "/", "*"};

        public String Opr_Znak(String s)
        {
            String znak = "";
            boolean pv = false;
            for (int i = 0; i <= s.length() - 1; i++)
             {
                for (int j = 0; j <= zn.length - 1; j++)
                {
                    if (zn[j].equals(String.valueOf(s.charAt(i))))
                    {
                        znak = zn[j];
                    }
                }

            }
            return znak;
        }

        public String[] Opr_ch(String s)
        {
            boolean pv = false;
            String ss[] = new String[]{"", ""};
            int k = 0;
            for (int i = 0; i <= s.length() - 1; i++)
             {
                for (int j = 0; j <= zn.length - 1; j++)
                {
                    if (!zn[j].equals(String.valueOf(s.charAt(i))))
                    {
                        pv = false;
                    } else {
                            k++;
                            pv = true;
                            break;
                           }
                }
                if (!pv)
                {
                    ss[k] = ss[k] + s.charAt(i);
                }

            }

            return ss;
        }

        public boolean opr_diap(String s) {
            boolean r = false;
            try {
                if (Integer.valueOf(s) <= 0)
                {
                    System.out.println("Число меньше 1 (Введите число с 1 до 10)");
                    r = false;
                } else if (Integer.valueOf(s) > 10)
                {
                    System.out.println("Число больше 10 (Введите число с 1 до 10)");
                    r = false;
                } else r = true;
            }catch (NumberFormatException e)
            {
                System.out.println("Ошибка при конвертации.Введите числа в формате 1+2 или I+II");
            }
            return r;
        }
    }

    static class Opr_rim {
        String[] rm = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", " LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", " LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] ch = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        boolean Opr_rim(String c1, String c2)
        {
            boolean b = false;
            boolean r1, r2;
            r1 = false;
            r2 = false;
            for (int r = 0; r <= rm.length - 1; r++)
            {
                if (c1.toUpperCase().equals(rm[r])) r1 = true;
                if (c2.toUpperCase().equals(rm[r])) r2 = true;
            }
            b =(r1&r2);
            return b;
        }

        public String RimtoCh(String s)
        {
            String bs = "";
            for (int g = 0; g <= rm.length - 1; g++)
            {
                if (s.toUpperCase().equals(rm[g])) bs =String.valueOf(g+1);
            }
            return bs;
        }
        public String ChtoRim(int s)
        {
           return rm[s-1];
        }

    }

    public static class Oper {
        public int Plus(String c1, String c2)
        {
            int res = Integer.valueOf(c1) + Integer.valueOf(c2);
            return res;
        }

        public int Minus(String c1, String c2)
        {
            int res = Integer.valueOf(c1) - Integer.valueOf(c2);
            return res;
        }

        public int Multi(String c1, String c2)
        {
            int res = Integer.valueOf(c1) * Integer.valueOf(c2);
            return res;
        }

        public int Dev(String c1, String c2)
        {
            int res = Integer.valueOf(c1) / Integer.valueOf(c2);
            return res;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Input:");
        Scanner inn = new Scanner(System.in);
        String s = inn.nextLine();
        String[] chis;
        Opr_Znak_Ch opznch = new Opr_Znak_Ch();
        Opr_rim oprim = new Opr_rim();
        Oper op=new Oper();
        chis = opznch.Opr_ch(s);
        String znak = opznch.Opr_Znak(s);
        int rez = 0;
        boolean ch = oprim.Opr_rim(chis[0], chis[1]);
          if (ch) {
                  chis[0] = oprim.RimtoCh(chis[0]);
                  chis[1] = oprim.RimtoCh(chis[1]);
                  }
                    if (opznch.opr_diap(chis[0]) & opznch.opr_diap(chis[1]))
                           {
                            if(znak.equals("+")) rez=op.Plus(chis[0],chis[1]);
                            if(znak.equals("-")) rez=op.Minus(chis[0],chis[1]);
                            if(znak.equals("*")) rez=op.Multi(chis[0],chis[1]);
                            if(znak.equals("/")) rez=op.Dev(chis[0],chis[1]);
                            if(ch){System.out.println(oprim.ChtoRim(rez));}else System.out.println(rez);
                           }

        }
    }

