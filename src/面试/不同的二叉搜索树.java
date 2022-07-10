package 面试;

public class 不同的二叉搜索树 {
    /***
     * 卡特兰数
     * 假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
     * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2
     * @param n
     * @return
     */
    private int[] ans = new int[20];

    public int numTrees(int n) {
        calculateTreeNum();
        return ans[1];
    }

    private void calculateTreeNum() {
        ans[0] = 1;
        for (int i = 2; i <= 19; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += ans[j - 1] * ans[i - j];
            }
            ans[i] = sum;
        }
    }
}
