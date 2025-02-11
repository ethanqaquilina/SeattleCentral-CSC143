package lab04$algorithms;

public class Test01Recursion {

    public static int fac(int n) {
        if (n <= 1) {
            return n;
        } else {
            return n * fac(n - 1);
        }
    }

    public static boolean isPalindrome(String s) {

        int length = s.length();

        if (length == 1) {
            return true;
        } else if (length == 0) {
            return false;
        } else {
            char first = s.charAt(0);
            char last = s.charAt(length - 1);

            if (Character.isLetter(first) && Character.isLetter(last)) {
                if (first == last) {

                    String shorter = s.substring(1, length - 1);
                    return isPalindrome(shorter);
                } else {
                    return false;
                }

            } else if (!Character.isLetter(last)) {
                // Remove last character.
                String shorter = s.substring(0, length - 1);
                return isPalindrome(shorter);
            } else {
                // Remove first character.
                String shorter = s.substring(1);
                return isPalindrome(shorter);
            }
        }

    }

    public static double pow(double x, int n) {
        if (n == 1) {
            return x;
        } else {
            return x * pow(x, n - 1);
        }
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }


    public static void checkFactorialRecursion(int n) {
        //count of nth factorial
        System.out.println("==============  nth factorial  ==============");
        for (int i = 0; i <= n; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        //value for nth factorial
        for (int i = 0; i <= n; i++) {
            System.out.print(fac(i) + "\t");
        }
        System.out.println();
    }

    public static void checkPalindrome() {
        System.out.println();
        System.out.println("===========  Which are palindromes? ==========");
        String[] strings = new String[11];
        strings[0] = "madam";
        strings[1] = "racecar";
        strings[2] = "tacocat";
        strings[3] = "step on no pets";
        strings[4] = "able was I ere I saw elba";
        strings[5] = "Java";
        strings[6] = "rotater";
        strings[7] = "byebye";
        strings[8] = "notion";
        strings[9] = "";
        strings[10] = "a";

        for (String str : strings) {
            System.out.printf("Is \"%s\" a palindrome? %6s\n", str, isPalindrome(str));
        }
        System.out.println();
    }

    public static void checkPowerRecursion(int n) {
        //two to the power of  n
        double twoToN = Math.pow(2, n);
        System.out.println();
        System.out.println("===========  pow(2, n)  ===========");
        System.out.println("pow(2, n): " + n + " gives " + twoToN);
        System.out.println("pow(2, n): " + n + " gives " + pow(2, n));
        System.out.println();

        //e to the power of  n
        double xToN = Math.pow(Math.E, n);
        System.out.println("===========  pow(x,n)  ===========");
        System.out.println("x(n):      " + n + " gives " + xToN);
        System.out.println("pow(e, n): " + n + " gives " + pow(Math.E, n));
        System.out.println();
    }

    public static void checkSumRecursion(int n) {
        System.out.println();
        System.out.println("===========  sum(n)  ===========");

        //summation of n integers
        int sum = n * (n + 1) / 2;
        System.out.println("sum of " + n + " integers: " + sum);
        System.out.println("sum of " + n + " integers: " + sum(n));
        System.out.println();
    }

    public static void intro() {
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" R E C U R S I O N    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        intro();
        checkFactorialRecursion(5);
        checkSumRecursion(4);
        checkPowerRecursion(8);
        checkPalindrome();
    }
}