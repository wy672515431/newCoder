import java.math.BigInteger;
import java.util.*;

public class Q {
        private StringBuffer sb = new StringBuffer();
        private Stack<String> stack = new Stack();
        public String trans(String s, int n) {
                // write code here
                //首先处理开头的空白字符
                int cnt = 0;
                while(Character.isSpace(s.charAt(cnt))){
                        sb.append(s.charAt(cnt));
                        cnt++;
                }
                if(cnt!=0){
                        stack.add(sb.toString());
                        sb.setLength(0);
                }
                while(cnt<n){
                        while(cnt<n&&Character.isLetter(s.charAt(cnt))){
                                if(Character.isLowerCase(s.charAt(cnt))){
                                        sb.append(Character.toUpperCase(s.charAt(cnt)));
                                }else{
                                        sb.append(Character.toLowerCase(s.charAt(cnt)));
                                }
                                cnt++;
                                if(cnt<n&&!Character.isLetter(s.charAt(cnt))){
                                        stack.add(sb.toString());
                                        sb.setLength(0);
                                }
                        }
                        while(cnt<n&&Character.isSpace(s.charAt(cnt))){
                                sb.append(s.charAt(cnt));
                                cnt++;
                                if(cnt<n&&!Character.isSpace(s.charAt(cnt))){
                                        stack.add(sb.toString());
                                        sb.setLength(0);
                                }
                        }
                }
                String ans = "";
                while(!stack.isEmpty()){
                        String s1 = stack.pop();
                        ans+= s1;
                }
                return ans;
        }

        public static void main(String[] args) {
                new Q().trans("This is a sample",16);
                BigInteger sum = new BigInteger(String.valueOf(1));
                String s = "959440.94f";
                System.out.println(Double.parseDouble(s));
                String q;
                
        }
}
