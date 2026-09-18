import java.util.Scanner;

public class Main {

    static int n;
    static int startX, startY;
    static int endX, endY;
    static int answer = Integer.MAX_VALUE;

    // 1~9번 동전 위치
    static int[] coinX = new int[10];
    static int[] coinY = new int[10];
    static boolean[] exist = new boolean[10];

    // 두 위치 사이 최소 이동 거리
    static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void dfs(int x, int y, int lastCoin, int coinCount, int dist) {

        // 동전을 3개 이상 먹었다면 E로 갈 수 있음
        if (coinCount >= 3) {
            int totalDist = dist + getDist(x, y, endX, endY);
            answer = Math.min(answer, totalDist);
        }

        // 마지막으로 먹은 동전보다 큰 번호만 선택
        for (int i = lastCoin + 1; i <= 9; i++) {

            // i번 동전이 없다면 넘어감
            if (!exist[i]) {
                continue;
            }

            int moveDist = getDist(x, y, coinX[i], coinY[i]);

            dfs(
                coinX[i],
                coinY[i],
                i,
                coinCount + 1,
                dist + moveDist
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String s = sc.next();

            for (int j = 0; j < n; j++) {

                char c = s.charAt(j);

                if (c == 'S') {
                    startX = i;
                    startY = j;

                } else if (c == 'E') {
                    endX = i;
                    endY = j;

                } else if (c >= '1' && c <= '9') {

                    int num = c - '0';

                    coinX[num] = i;
                    coinY[num] = j;
                    exist[num] = true;
                }
            }
        }

        dfs(startX, startY, 0, 0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}