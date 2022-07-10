import java.util.Scanner;

public class T3 {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                String s = scanner.next();
                int m = scanner.nextInt();
                int ans = 1;
                for(char c = 'a' ; c<='z' ; c++){
                        int[] pos = new int[s.length()];
                        int cnt = 0;
                        for(int i = 0 ; i<s.length();i++){
                                if(s.charAt(i) == c){
                                       pos[cnt] = i;
                                       cnt++;
                                }
                        }
                        //只有一个字符，最多为1次
                        if(cnt<2)
                                continue;

                        int[][] dp = new int[cnt][cnt];
                        for(int i = 0 ;i<cnt;i++){
                                for(int j = 0;j<cnt;j++)
                                        dp[i][j]=0;
                        }
                        int tem = 1;
                        for(int len  = 2 ;len<=cnt;len++){
                                for(int i = 0 ;i+len-1<cnt;i++){
                                        dp[i][i+len-1] = dp[i+1][i+len-2] + pos[i+len-1] - pos[i] - len+1;
                                        if(dp[i][i+len-1]<=m)
                                                tem = len;
                                }
                        }
                        ans = Math.max(ans,tem);
                }
                System.out.println(ans);
        }
}
