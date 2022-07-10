package 面试;

import java.util.ArrayList;

public class 二叉树最近公共祖先 {
        private ArrayList<TreeNode> arr1 = new ArrayList();
        private ArrayList<TreeNode> arr2 = new ArrayList();
        private boolean flag = false;

        /***
         * 若root是p和q的公共祖先，如果root的左节点和右节点都不是p和q的公共祖先，那么root就是p和q的最近公共祖先。
         * p 和 q 在 root的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
         * p = root ，且 q 在 root 的左或右子树中；
         * q = root，且 p 在 root的左或右子树中；
         * 从底至顶回溯，当节点p,q在节点root的异侧时，节点root为最近公共祖先，向上返回root。
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
                if(root == null || p == root || q == root)
                        return  root ;
                TreeNode left = lowestCommonAncestor(root.left,p,q);
                TreeNode right = lowestCommonAncestor(root.right,p,q);
                if(left == null)
                        return right;
                if(right == null)
                        return left;
                return root;
        }
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                find(root,p);
                flag = false;
                find1(root,q);
                TreeNode ans = null;
                for(int i=0;i<Math.min(arr1.size(),arr2.size());i++){
                        if(arr1.get(i) == arr2.get(i))
                                ans = arr1.get(i);
                }
                return ans;
        }
        public void find(TreeNode cur,TreeNode p){
                if(cur == null)
                        return;
                if(cur != p){
                        arr1.add(cur);
                        if(!flag)
                                find(cur.left,p);
                        if(!flag)
                                find(cur.right,p);
                        if(!flag)
                                arr1.remove(arr1.size()-1);
                }else{
                        arr1.add(cur);
                        flag = true;
                        return;
                }
        }
        public void find1(TreeNode cur,TreeNode p){
                if(cur == null)
                        return;
                if(cur != p){
                        arr2.add(cur);
                        if(!flag)
                                find1(cur.left,p);
                        if(!flag)
                                find1(cur.right,p);
                        if(!flag)
                                arr2.remove(arr2.size()-1);
                }else{
                        arr2.add(cur);
                        flag = true;
                        return;
                }
        }

        public static void main(String[] args) {

        }
}
