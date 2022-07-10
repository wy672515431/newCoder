package 面试;

public class 接雨水 {
        public int trap(int[] height) {
                if(height.length == 0)
                        return 0;
                int ans = 0;
                int lmax = height[0];
                int rmax = height[height.length-1];
                int left = 0;
                int right = height.length -1;
                while(left<=right){
                        //从height[0...left]的柱子最高值
                        lmax = Math.max(lmax,height[left]);
                        //height[right....end]的最高值
                        rmax = Math.max(rmax,height[right]);
                        if(lmax<rmax){
                                ans += lmax - height[left];
                                left++;
                        }else{
                                ans += rmax - height[right];
                                right--;
                        }
                }
                return ans;
        }
}
