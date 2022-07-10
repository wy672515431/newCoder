package 题目;
import java.util.*;
public class 子集 {
        private ArrayList<ArrayList<Integer>> ans = new ArrayList();
        private ArrayList<Integer> list = new ArrayList();
        public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
                for(int i=0;i<=nums.length;i++)
                        solve(nums,i,0);
                return ans;
        }

        /***
         *解决不含有重复元素的子集
         * @param nums sets
         * @param k    the size of a subset
         * @param start start point
         */
        public void solve(int[] nums,int k,int start){
                if(k==0){
                        ans.add(new ArrayList<>(list));
                        return;
                }else{
                        for(int i=start;i<nums.length;i++){
                                list.add(nums[i]);
                                solve(nums,k-1,start+1);
                                list.remove(nums[i]);
                        }
                }
        }

        /***
         * 解决含有重复元素集合的子集
         * @param nums
         */
        public void solve1(int[] nums,int k){

        }


}
