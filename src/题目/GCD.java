package 题目;

public class GCD {
        public static int gcd(int r,int q){
                return q!=0?gcd(q,r%q):r;
        }

        public static  int gcd1(int a,int b,int[] x){
                if(b==0){
                        x[0]=1;
                        x[1]=0;
                        return a;
                }
                int r = gcd1(b,a%b,x);
                int tem = x[1];
                x[1] = x[0]-(a/b)*x[1];
                x[0] = tem;
                return r;
        }


        public static void main(String[] args) {
                int[] a = {0,0};
                //System.out.println(gcd1(100,23,a));
                //System.out.println(a[0]);
                //System.out.println(a[1]);
                gcd1(10,7,a);
                System.out.println(a[1]);
        }
}
