package 题目;

/***
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 */
public class 旋转数组的最小数字 {
        /***
         * 注意体会二分的使用，当二分没有target比较时，可以用端点比较
         * ,@param numbers
         * @return
         */
        public int minArray(int[] numbers) {
                int low = 0;
                int high = numbers.length-1;
                int mid;
                // 0~i-1为递增 i~n-1为递增。其中前者的任何值大于后面的任意值.我们要求的是a[i]的值，是最小的值。
                while(low<high){
                        mid = (low+high)>>1;
                        //说明最小值不在[low~mid]中
                        if(numbers[mid]>numbers[high]){
                                low = mid+1;
                        }
                        //最小值不在[mid+1~high]中
                        else if(numbers[mid]<numbers[high])
                                high = mid;
                        else
                                high--;
                }
                // 1 0 1 1 1和 1 1 1 0 1
                return numbers[low];
        }
}
