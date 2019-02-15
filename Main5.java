package lesson5;

public class Main5 {
    public static int fibo (int n) {
        int f_curr = 1;
        int f_prev = 1;
        int i_curr = 2;
        while (i_curr < n) {
            int f_next = f_curr+f_prev;
            f_prev = f_curr;
            f_curr = f_next;
            i_curr++;
        }
        return f_curr;
    }

    public static int fiboRec (int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fiboRec(n-1) + fiboRec(n-2);
        }
    }

    public static int fact (int n) {
        int product = 1;

        while (n > 0) {
            product = product *n;
            n--;
        }
        return product;
    }

    public static int factRec (int n) {
        if (n == 1) {
            return 1;
        } else {
            return factRec(n-1)*n;
        }
    }

    public static int triangle (int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum +i;
        }
        return sum;
    }

    public static int triangleRec (int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangleRec(n-1);
        }
    }

    public static int digitSum (int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + n%10;
            n = n/10;

        }
        return sum;
    }

    public static int digitSumRec (int n) {
        if (n < 10) {
            return n;
        } else {
            return digitSum(n/10) + n%10;
        }
    }

    public static int product (int a, int b) {
        int sum = 0;
        while (b>0) {
            sum = sum + a;
            b--;
        }
        return sum;
    }

    public static int productRec (int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else if (b == 1) {
            return a;
        } else {
            return productRec(a, b-1) + a;
        }
    }

    public static int power (int base, int n) {
        int result = 1;
        while (n > 0) {
            result = result * base;
            n--;
        }
        return result;
    }
    public static int powerRec (int base, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        } else {
            return powerRec(base, n-1)*base;
        }
    }


    public static int quickPowerRec (int base, int n) {
        if (n == 1) {
            return base;
        } else if (n%2 == 0) {
            return quickPowerRec(base, n/2) * quickPowerRec(base, n/2);
        } else {
            return quickPowerRec(base, n/2) * quickPowerRec(base, n/2) * base;
        }
    }


    public static void hanoi (int n, int from, int to, int additional) {
        if (n == 0) {
            return;
        } else {
            hanoi(n-1, from,additional,to);
            System.out.println(from + " - " + to);
            hanoi(n-1, additional, to, from );
        }
    }

    public static void main(String[] args) {
        System.out.println(fibo(10));
        System.out.println(fiboRec(10));

        System.out.println(fact(5));
        System.out.println(factRec(5));

        System.out.println(triangle(5));
        System.out.println(triangleRec(5));

        System.out.println(digitSum(23461));
        System.out.println(digitSumRec(23461));

        System.out.println(product(5, 6));
        System.out.println(productRec(5, 6));

        double start = System.currentTimeMillis();
        System.out.println(power(2,19));
        double end = System.currentTimeMillis();
        double time1 = end - start;
        System.out.println("Время в цикле: " + time1);

        double start2 = System.currentTimeMillis();
        System.out.println(powerRec(2, 19));
        double end2 = System.currentTimeMillis();
        double time2 = end2 - start2;
        System.out.println("Время в рекурсии: " + time2);

        double start3 = System.currentTimeMillis();
        System.out.println(quickPowerRec(2,19));
        double end3 = System.currentTimeMillis();
        double time3 = end3 - start3;
        System.out.println("Время при быстром возведении: " + time3);

        hanoi(3, 1,2,3);

    }
}
