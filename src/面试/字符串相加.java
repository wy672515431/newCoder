package 面试;

public class 字符串相加 {
        public String addStrings(String num1, String num2) {
                StringBuilder sb = new StringBuilder();
                int i = num1.length()-1;
                int j = num2.length()-1;
                int cnt = 0;
                int add1;
                int add2;
                int sum;
                while (i>=0||j>=0||cnt!=0){
                        add1 = (i == -1)?0:num1.charAt(i)-'0';
                        add2 = (j == -1)?0:num2.charAt(j)-'0';
                        sum = add1+add2+cnt;
                        cnt=0;
                        if(sum>=10){
                                sum -= 10;
                                cnt = 1;
                        }
                        sb.append(sum);
                        i = (i>=0)?i-1:-1;
                        j = (j>=0)?j-1:-1;
                }
                return sb.reverse().toString();
        }
}
