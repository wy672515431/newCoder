package 面试;

import java.util.LinkedHashSet;
import java.util.Set;

public class 两个有序数组的交集和并集 {
        /***
         * 求两个有序数组的交集
         * @param a
         * @param b
         * @return
         */
        public Set<Integer> solve(int[] a , int[] b){
                int i = 0;
                int j = 0;
                Set<Integer> set = new LinkedHashSet<>();
                while (i<a.length&&j<b.length){
                        if(a[i] == b[j]){
                                set.add(a[i]);
                                i++;
                                j++;
                        }else if(a[i]<b[j]){
                                i++;
                        }else
                                j++;
                }
                return  set;
        }

        /***
         * 求两个有序数组的并集
         * @param a
         * @param b
         * @return
         */
        public Set<Integer> solve1(int[] a,int[] b){
                int i=0;
                int j=0;
                Set<Integer> set = new LinkedHashSet<>();
                while (i<a.length && j<b.length){
                        set.add(a[i]);
                        set.add(b[j]);
                        i++;
                        j++;
                }
                for(int k=i;k<a.length;k++)
                        set.add(a[k]);
                for(int k=j;k<b.length;k++)
                        set.add(b[k]);
                return  set;

        }
}
