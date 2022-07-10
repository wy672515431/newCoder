package 面试;

public class 数组是否能分为相等的三个区间 {
        public static boolean solve(int[] arr){
                int sum = 0;
                for(int i=0;i<arr.length;i++)
                        sum+=arr[i];
                if(sum % 3 != 0)
                        return false;
                sum = sum/3;
                int cnt =0;
                int tem = 0;
                for(int i=0;i<arr.length;i++){
                        tem+=arr[i];
                        if(tem == sum){
                                cnt++;
                                tem = 0;
                        }
                        if(cnt == 3){
                                for(int j=i+1;j<arr.length;j++){
                                        tem+=arr[j];
                                }
                                break;
                        }
                }
                if(tem!=0)
                        cnt++;
                if(cnt != 3)
                        return false;
                return true;
        }

        public static void main(String[] args) {
                int[] a = {-1,3,-4,-2,1};
                System.out.print(solve(a));
        }
}
