package 面试;

public class 树的子结构 {
    /***
     * 判断B是不是A的子结构
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值
     * 若树B是树A的子结构，那子结构的根可能为树A的任意一个节点。
     * 先序遍历树A中的每个节点n
     * 判断树A中以A为根节点的子树是否包含树B。 对应函数recur
     * recur的终止条件：1.当节点B为空，说明B已经匹配完成，返回true。
     * 2.如果节点A为空，说明匹配失败，返回false
     * 3.如果A的值不等于B的值，返回false;
     * 返回值：判断A和B的左子树和右子树是否相同
     * @param A
     * @param B
     * 该函数当树A为空或者树B为空时，返回false;
     * 返回值，若B是A的子结构，那么必须满足以下条件：
     * 1.以节点n为根的树包含B
     * 2.左子树包含B
     * 3.右子树包含B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null)
            return false;
        if (A.val != B.val)
            return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
