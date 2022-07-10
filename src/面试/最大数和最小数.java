package 面试;

import java.util.Arrays;
import java.util.Comparator;

public class 最大数和最小数 {
        public String largestNumber(int[] nums) {
                String[] a = new String[nums.length];
                for(int i=0;i<nums.length;i++){
                        a[i] = nums[i]+"";
                }
                Arrays.sort(a, new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                                return (o2+o1).compareTo(o1+o2);
                        }
                });
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<a.length;i++)
                        sb.append(a[i]);
                int pos = 0;
                for(int i=0;i<sb.length();i++){
                        if(sb.charAt(i) != '0'){
                                pos = i;
                                break;
                        }
                }
                return sb.toString();
        }
        public String smallestNumber(int[] nums){
                String[] a = new String[nums.length];
                for(int i=0;i<nums.length;i++){
                        a[i] = nums[i]+"";
                }
                Arrays.sort(a, new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                                return (o1+o2).compareTo(o2+o1);
                        }
                });
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<a.length;i++)
                        sb.append(a[i]);
                int pos = 0;
                for(int i=0;i<sb.length();i++){
                        if(sb.charAt(i) != '0'){
                                pos = i;
                                break;
                        }
                }
                return sb.toString();
        }
}
