import java.util.*;
public class Main{
        public static void main(String[] args){
                Scanner scanner = new Scanner(System.in);
                int n = scanner.nextInt();
                int[] arr = new int[n];
                for(int i=0;i<n;i++)
                        arr[i] = scanner.nextInt();
                int target = scanner.nextInt();
                long ans = 0;
                long tem = 0;
                for(int i=0;i<n;i++){
                        for(int j=i;j<n;j++){
                                tem = arr[i]|arr[j];
                                if(tem<=target)
                                        ans++;
                                else
                                        break;
                        }
                }
                System.out.print(ans%1000000007);
        }
}