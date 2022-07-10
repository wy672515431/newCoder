package 面试;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Stack;

public class 二叉树逆时针打印外围节点 {
        /**
         * 先遍历左边节点，再遍历叶子节点，最后遍历右节点。
         */
        private static ArrayList<TreeNode> ans = new ArrayList<>();
        public static void getLeftNodes(TreeNode root){
                TreeNode cur =  root;
                while (cur!=null){
                        ans.add(cur);
                        cur = cur.left;
                }
        }
        public static void getLeafNodes(TreeNode root){
                TreeNode cur = root;
                if(cur == null)
                        return;
                if(cur.left == null && cur.right == null){
                        //防止重复
                        if(ans.get(ans.size()-1) != cur)
                                ans.add(cur);
                }
                getLeftNodes(cur.left);
                getLeftNodes(cur.right);
        }
        public static void getRightNodes(TreeNode root){
                TreeNode cur = root;
                Stack<TreeNode> stack = new Stack<>();
                cur = cur.right;
                while (cur!=null){
                        stack.push(cur);
                        cur = cur.right;
                }
                while (!stack.isEmpty()){
                        TreeNode tem = stack.pop();
                        if(ans.get(ans.size()-1)!=tem)
                                ans.add(tem);
                }
        }
}
