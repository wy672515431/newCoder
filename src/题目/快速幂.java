package 题目;

public class 快速幂 {
        private double result = 1.0;
        private boolean flag = false;
        public double myPow(double x, int n) {
                long tem = n;
                if(tem<0){
                        tem = -tem;
                        flag = true;
                }
                while(tem>0){
                        if((tem&1) == 1){
                                result = result * x;
                        }
                        tem>>=1;
                        x = x*x;
                }
                if(flag)
                        return 1/result;
                else
                        return result;
        }
}
