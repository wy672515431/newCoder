package 题目;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class findKth {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                int n = nums1.length;
                int m = nums2.length;
                //当n+m为奇数时,中位数为(n+m+1)/2；当n+m为偶数时，中位数为(n+m+1)/2和(n+m+2)/2的和的一半
                int left = (n+m+1)/2;
                int right = (n+m+2)/2;
                return (solve(nums1,0,n-1,nums2,0,m-1,left)+solve(nums1,0,n-1,nums2,0,m-1,right))/2.0;
        }
        public int solve(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
                int len1 = end1-start1+1;
                int len2 = end2-start2+1;
                //保证一定是len1数组先为空
                if(len1>len2)
                        return solve(nums2,start2,end2,nums1,start1,end1,k);
                if(len1==0)
                        return nums2[start2+k-1];
                if(k==1)
                        return Math.min(nums1[start1],nums2[start2]);
                int tem1 = start1+Math.min(len1,k/2)-1;
                int tem2 = start2+Math.min(len2,k/2)-1;
                if(nums1[tem1]>nums2[tem2]){
                        return solve(nums1,start1,end1,nums2,tem2+1,end2,k-(tem2-start2+1));
                }else{
                        return solve(nums1,tem1+1,end1,nums2,start2,end2,k-(tem1-start1+1));
                }
        }
        public static void main(String[] args) {
              int[] nums1 = {1,3};
              int[] nums2 = {2};
              new findKth().findMedianSortedArrays(nums1,nums2);
              System.out.print(-23%10);
        }
}



