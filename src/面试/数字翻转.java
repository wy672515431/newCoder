package 面试;

public class 数字翻转 {
        public int reverse(int x) {
                int sum = 0;
                while(x!=0){
                        int tem = x%10;
                        if(((sum>Integer.MAX_VALUE/10)||(sum == Integer.MAX_VALUE/10 && tem>=7)))
                                return 0;
                        if(((sum<Integer.MIN_VALUE/10)||(sum == Integer.MIN_VALUE/10 && tem<=-8)))
                                return 0;
                        sum = sum*10+tem;
                        x = x/10;
                }
                return sum;
        }
}
