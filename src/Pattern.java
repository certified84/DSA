public class Pattern {
    public static void main(String[] args) {
        int n = 4;
        combine(n);
    }

    static void combine(int n) {
        for (int row = 1; row <= 2 * n; row++) {
            for (int col = 1; col <= 2 * n; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern31(int n) {
        for (int row = n; row >= 1; row--) {
            for (int col = n; col >= 1; col--) {
                if (col == row)
                    break;
                System.out.print(col + " ");
            }
            for (int current = 0; current < row; current++) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }

    static void pattern30(int n) {
        for (int row = 1; row <= n; row++) {
            int spaces = n - row;
            for (int space = 0; space <= spaces; space++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n) {
        for (int row = 1; row < 2 * n; row++) {
            int c = row > n ? 2 * n - row : row;
            int spaces = n - c;
            for (int space = 0; space <= spaces; space++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= c; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern26(int n) {
        for (int row = 1; row <= n; row++) {
            int c = n - row + 1;
            for (int col = 1; col <= c; col++) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }

    static void pattern17(int n) {
        for (int row = 1; row <= 2 * n; row++) {
            int spaces = row < n ? n - row : row - n;
            for (int space = 0; space <= spaces; space++) {
                System.out.print(" ");
            }
            int c = row <= n ? row : 2 * n - row;
            for (int col = c; col >= 1; col--) {
                System.out.print(col);
            }
            for (int col = 2; col <= c; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static void pattern12(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int spaces = row < n ? row : 2 * n - row - 1;
            for (int space = 1; space <= spaces; space++) {
                System.out.print(" ");
            }
            int c = row < n ? n - row : row - n + 1;
            for (int col = c; col >= 1; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern11(int n) {
        for (int row = 0; row < n; row++) {
            int spaces = n - row;
            for (int space = 0; space <= row; space++) {
                System.out.print(" ");
            }
            for (int col = n - row; col >= 1; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern10(int n) {
        for (int row = 1; row <= n; row++) {
            int spaces = n - row;
            for (int space = 0; space <= spaces; space++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern9(int n) {
        int extra = 2 * n - 1;
        for (int row = 0; row < n; row++) {
            int spaces = n - row;
            for (int space = 0; space <= row; space++) {
                System.out.print("  ");
            }
            for (int col = extra; col >= 1; col--) {
                System.out.print("* ");
            }
            System.out.println();
            extra -= 2;
        }
    }

    static void pattern8(int n) {
        int extra = 0;
        for (int row = 1; row <= n; row++) {
            int spaces = n - row;
            for (int space = 0; space <= spaces; space++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= row + extra; col++) {
                System.out.print("* ");
            }
            System.out.println();
            extra++;
        }
    }

    static void pattern7(int n) {
        for (int row = 0; row < n; row++) {
            for (int space = 0; space <= row; space++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= n - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n) {
        for (int row = 1; row <= n; row++) {
            int spaces = n - row;
            for (int space = 0; space <= spaces; space++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int row = 1; row < 2 * n; row++) {
            int c = row > n ? 2 * n - row : row;
            for (int col = 1; col <= c; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 0; col <= n - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
