package 面试;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的深度 {
        /***
         * 递归方法
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
                return solve(root);
        }
        //当前节点的高度
        public int solve(TreeNode node){
                if(node == null)
                        return  0;
                int leftDepth = solve(node.left)+1;
                int rightDepth = solve(node.right)+1;
                return  Math.max(leftDepth,rightDepth);
        }

        /***
         * 迭代方法
         * @param root
         * @return
         */
        public int maxDepth1(TreeNode root){
                Queue<TreeNode> queue = new LinkedList<>();
                int level = 0;
                queue.offer(root);
                while (!queue.isEmpty()){
                        int len = queue.size();
                        level++;
                        while (len>0){
                                TreeNode tem = queue.poll();
                                if(tem.left!=null)
                                        queue.offer(tem.left);
                                if(tem.right!=null)
                                        queue.offer(tem.right);
                                len--;
                        }
                }
                return level;
        }
        /**
         * N叉树
         */
        public int maxDepth2(Node root) {
                if(root == null)
                        return 0;
                return solve(root)+1;
        }
        public int solve(Node cur){
                if(cur == null)
                        return 0;
                int max = 0;
                for(int i=0;i<cur.children.size();i++){
                        int tem = 1+solve(cur.children.get(i));
                        max = Math.max(max,tem);
                }
                return max;
        }
}
