import java.util.Scanner;

public class Main {
    static int n, m, answer;
    static int[] A;

    static void dfs(int start, int count, int xorValue) {
        
        if (count == m) {
            answer = Math.max(xorValue, answer);
            return;
        }

        for (int i = start; i < n; i++) {
            dfs(i + 1, count + 1, xorValue ^ A[i]);   
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        // Please write your code here.

        answer = 0;

        dfs(0, 0, 0);

        System.out.println(answer);
    }
}