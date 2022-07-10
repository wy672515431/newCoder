package 面试;

import java.util.HashMap;

public class 前序和中序构造二叉树 {
        private HashMap<Integer,Integer> map;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
                map = new HashMap();
                for(int i=0;i<inorder.length;i++)
                        map.put(inorder[i],i);
                return solve(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        }
        public TreeNode solve(int[] preorder,int preorderStart,int preorderEnd,int[] inorder,int inorderStart,int inorderEnd)    {
                if(preorderStart>preorderEnd)
                        return null;
                //前序遍历第一个即为根节点
                int preorderRoot = preorderStart;
                TreeNode root = new TreeNode(preorder[preorderStart]);
                //根据中序遍历，找出左子树的位置
                int inorderRoot = map.get(preorder[preorderRoot]);
                int len = inorderRoot-inorderStart;
                root.left = solve(preorder,preorderStart+1,preorderStart+len,inorder,inorderStart,inorderRoot-1);
                root.right = solve(preorder,preorderStart+len+1,preorderEnd,inorder,inorderRoot+1,inorderEnd);
                return root;
        }
}
