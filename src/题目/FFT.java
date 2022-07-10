package 题目;

import java.util.Scanner;

public class FFT {
        private  static  final  int MAXN = 20010;
        private Complex[] x1 = new Complex[MAXN];
        private Complex[] x2 = new Complex[MAXN];
        private int[] sum = new int[MAXN];
        StringBuffer sb = new StringBuffer();
        private static final  double pi = Math.acos(-1.0);
        private static class Complex{
                private double x;
                private double y;
                public Complex(double x,double y){
                        this.x = x;
                        this.y = y;
                }
                public Complex add(Complex o1,Complex o2){
                        return new Complex(o1.x+o2.x,o1.y+o2.y);
                }
                public Complex subtract(Complex o1,Complex o2){
                        return new Complex(o1.x-o2.x,o1.y-o2.y);
                }
                public Complex multiply(Complex o1,Complex o2){
                        return new Complex(o1.x*o2.x-o1.y*o2.y,o1.y*o2.x+o1.x*o2.y);
                }
        }
        public void change(Complex[] y,int len){
                int i,j,k;
                for(i=1,j=len/2;i<len-1;i++){
                        if(i<j){
                                Complex tem =y[i];
                                y[i] = y[j];
                                y[j] = tem;
                        }
                        k = len/2;
                        while (j>=k){
                                j-=k;
                                k/=2;
                        }
                        if(j<k) j+=k;
                }
        }
        public void fft(Complex[] y,int len,int on){
                change(y,len);
                for(int h=2;h<=len;h<<=1){
                        Complex wn = new Complex(Math.cos(-on*2*pi/h),Math.sin(-on*2*pi/h));
                        for(int j=0;j<len;j+=h){
                                Complex w = new Complex(1,0);
                                for(int k=j;k<j+h/2;k++){
                                        Complex u = y[k];
                                        Complex t = w.multiply(w,y[k+h/2]);
                                        y[k] = u.add(u,t);
                                        y[k+h/2] = u.subtract(u,t);
                                        w = w.multiply(w,wn);
                                }
                        }
                }
                if(on==-1){
                        for(int i=0;i<len;i++)
                                y[i].x/=len;
                }
        }
        public String solve (String s, String t) {
                int len1 = s.length();
                int len2 = t.length();
                int len=1;
                while (len<len1*2||len<len2*2)
                        len<<=1;
                for(int i=0;i<len1;i++)
                        x1[i] = new Complex(s.charAt(len1-i-1)-'0',0);
                for(int i=len1;i<len;i++)
                        x1[i] = new Complex(0,0);
                for(int i=0;i<len2;i++)
                        x2[i] = new Complex(t.charAt(len2-i-1)-'0',0);
                for(int i=len2;i<len;i++)
                        x2[i] = new Complex(0,0);
                fft(x1,len,1);
                fft(x2,len,1);
                for(int i=0;i<len;i++)
                        x1[i] = x1[i].multiply(x1[i],x2[i]);
                fft(x1,len,-1);
                for(int i=0;i<len;i++)
                        sum[i] = (int)(x1[i].x+0.5);
                for(int i=0;i<len;i++){
                        sum[i+1]+=sum[i]/10;
                        sum[i]%=10;
                }
                len = len1+len2-1;
                while (sum[len]<=0&&len>0)
                        len--;
                for(int i=len;i>=0;i--)
                        sb.append(sum[i]);
                return sb.toString();
        }
        public static void main(String[] args){
                String s;
                String t;
                Scanner scanner = new Scanner(System.in);
                s = scanner.nextLine();
                t = scanner.nextLine();
                System.out.println();
        }
}
