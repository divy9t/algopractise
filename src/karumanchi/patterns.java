package karumanchi;

public class patterns {
    public static void main(String[] args) {
        System.out.println();
        new patterns().countOddDigit(123);

    }

    public int countOddDigit(int n) {
        int odds = 0;
        for (Character s : String.valueOf(n).toCharArray()) {
            if (Integer.valueOf(s) % 2 != 0) {
                odds++;
            }
        }

        return odds;

    }

    public void pattern22(int n) {
        for (int i = 0; i < (2 * n - 1); i++) {
            for (int j = 0; j < (2 * n) - 1; j++) {
                System.out.print(n - Math.min(Math.min(i, j), Math.min((2 * n - 2) - i, (2 * n - 2) - j)));
            }
            System.out.println();
        }
    }

    public void pattern21(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void pattern20(int n) {

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            if (i < n - 1)
                System.out.println();
        }
    }

    public void pattern19(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            if (i < n - 1)
                System.out.println();
        }

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void pattern18(int n) {
        for (int i = 1; i <= n; i++) {
            char currentChar = (char) ('A' + (n - i));
            for (int j = 0; j < i; j++) {
                System.out.print(currentChar++);
            }
            System.out.println();
        }
    }

    public void pattern10(int n) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void pattern11(int n) {

        for (int i = 1; i <= n; i++) {
            System.out.print(i + "--");
            for (int j = 1; j <= i; j++) {
                System.out.print((i + j) % 2 == 0 ? 1 : 0);
            }
            System.out.println();
        }

    }

    public void pattern12(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <= (n - i) * 2; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public void pattern13(int n) {
        int k = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(k++ + " ");
            }
            System.out.println();
        }
    }

    public void pattern15(int n) {
        for (int i = n; i >= 1; i--) {
            char currentChar = 'A';
            for (int j = 1; j <= i; j++) {
                System.out.print(currentChar++ + " ");
            }
            System.out.println();
        }
    }

    public void pattern14(int n) {
        char currentChar = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(currentChar + " ");
            }
            currentChar++;
            System.out.println();
        }
    }

    public void pattern17(int n) {
        for (int i = 1; i <= n; i++) {
            char currentChar = 'A';
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (i * 2) - 1; j++) {
                System.out.print(currentChar);
                if (j < i) {
                    currentChar++;  // Increment until middle
                } else {
                    currentChar--;  // Decrement after middle
                }
            }
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
