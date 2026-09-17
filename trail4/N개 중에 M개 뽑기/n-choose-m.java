import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m;
    static ArrayList<Integer> selected;

    static void recursion(int start) {
        if (selected.size() == m) {
            for (int num : selected) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            selected.add(i);

            recursion(i + 1);

            selected.remove(selected.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.

        selected = new ArrayList<>();

        recursion(1);
    }
}