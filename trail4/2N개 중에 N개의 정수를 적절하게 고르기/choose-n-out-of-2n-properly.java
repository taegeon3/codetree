import java.util.Scanner;
public class Main {
    static int n, totalNum, answer, compareNum;
    static int[] arr;

    static void dfs(int startIndex, int count, int sumNum) {
        if (count == n) {
            compareNum = totalNum - sumNum;

            int diff = Math.abs(sumNum - compareNum);

            answer = Math.min(answer, diff);

            return;
        }

        for (int i = startIndex; i < 2 * n; i++) {
            dfs(i + 1, count + 1, sumNum + arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        answer = Integer.MAX_VALUE;
        totalNum = 0;

        for (int i = 0; i < 2 * n; i++) {
            totalNum += arr[i];
        }

        compareNum = 0;
        
        dfs(0, 0, 0);

        System.out.println(answer);
    }
}