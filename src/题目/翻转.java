package 题目;

public class 翻转 {
        /***
         *对于一个十进制数，我们可以知道
         * ans = ans*10+n%10; n/=10;(自己判断正负数)
         * 上述即可完成翻转
         * 对于一个二进制数
         * ans = ans*2 + n%2; n/=2;
         * 但是对于一个负数,n%2并不能得到我们所需要的位数，需要n&0x01。
         *我们可以加上n!=0，这样会更快.
         * @param n
         * @return
         */
        public int reverseBits_1(int n){
                int ans = 0;
                for(int i=0;i<32 && n!=0 ;i++){
                        ans =  (ans<<1)+(n&0x01);
                        n>>=1;
                }
                return ans;
        }

        /***
         * 采用分治的思想，反转左右16位
         * 对于16位，反转左右8位
         * 依次下去，最后反转两位
         * @param n
         * @return
         */
        public int reverseBits_2(int n){
                //交换16位
                n = (n>>>16)|(n<<16);
                n = ((n&0xff00ff00)>>>8)|((n&0x00ff00ff)<<8);
                n = ((n&0xf0f0f0f0)>>>4)|((n&0x0f0f0f0f)<<4);
                n = ((n&0xcccccccc)>>>2)|((n&0x33333333)<<2);
                n = ((n&0xaaaaaaaa)>>>1)|((n&0x55555555)<<2);
                return n;
        }
}
