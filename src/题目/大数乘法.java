package 题目;

import java.util.ArrayList;

public class 大数乘法 {
        private int[] a;
        private int[] b;
        private int[] c;
        StringBuffer sb = new StringBuffer();
        public String solve (String s, String t) {
                // write code here
                int len1 = s.length();
                int len2 = t.length();
                int len3 = len1+len2;
                a = new int[len1];
                b = new int[len2];
                c = new int[len3];
                for(int i=0;i<len1;i++)
                        a[len1-i-1] = s.charAt(i)-'0';
                for(int i=0;i<len2;i++)
                        b[len2-i-1] = t.charAt(i)-'0';
                for(int i=0;i<len1;i++){
                        for(int j=0;j<len2;j++){
                                c[i+j]+=a[i]*b[j];
                        }
                }
                for(int i=0;i<len3-1;i++){
                        if(c[i]>=10){
                                c[i+1]+=c[i]/10;
                                c[i]%=10;
                        }
                }
                while(c[len3-1]==0&&len3-1>0)
                        len3--;
                for(int i=len3-1;i>=0;i--)
                        sb.append(c[i]);
                return sb.toString();

        }

        public static void main(String[] args) {
                new 大数乘法().solve("7330643661","459309139");
        }
}
