package 面试;

public class 有序数组查找重复元素个数 {
        public int solve(int[] a){
                int ans = 0;
                int tem =  a[0];
                boolean flag =  false;
                for(int i=1;i<a.length;i++){
                        if(a[i] == tem && !flag){
                                ans++;
                                flag = true;
                        }else if(a[i] == tem && flag){
                                continue;
                        }else if(a[i] != tem){
                                flag = false;
                                tem = a[i];
                        }
                }
                return  ans;
        }

        public static void main(String[] args) {
                int[] a ={1,2,2,4,4,4,4,4,5,5,6,10};
                System.out.print(new 有序数组查找重复元素个数().solve(a));

        }
}
