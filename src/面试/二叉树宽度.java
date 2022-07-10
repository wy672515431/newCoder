package 面试;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉树宽度 {
        //二叉树的最大宽度 = max{当前层次最右节点的序号-最左节点的序号}
        //默认根节点的序号为1。
        public int widthOfBinaryTree(TreeNode root) {
                if(root == null)
                        return 0;
                int ans = 0;
                int curDepth = -1;
                int left = 0;
                int right = 0;
                Queue<MixedTreeNode> queue = new LinkedList<>();
                queue.offer(new MixedTreeNode(root,1,0));
                while (!queue.isEmpty()){
                        MixedTreeNode tem = queue.poll();
                        if(tem.depth != curDepth){
                                curDepth = tem.depth;
                                left = tem.position;
                                right = tem.position;
                        }else{
                                right = tem.position;
                        }
                        ans = Math.max(ans,right-left+1);
                        if(tem.node.left!=null){
                                queue.offer(new MixedTreeNode(tem.node.left,tem.position*2,tem.depth+1));
                        }
                        if(tem.node.right!=null){
                                queue.offer(new MixedTreeNode(tem.node.right,tem.position*2+1,tem.depth+1));
                        }
                }
                return  ans;
        }
        public int widthOfBinaryTree1(TreeNode root){
                if(root == null)
                        return 0;
                int ans = 0;
                int cnt = 0;
                int curDepth = -1;
                Queue<MixedTreeNode> queue = new LinkedList<>();
                queue.offer(new MixedTreeNode(root,1,0));
                while (!queue.isEmpty()){
                        MixedTreeNode tem = queue.poll();
                        if(tem.depth!=curDepth){
                                curDepth = tem.depth;
                                cnt = 1;
                        }else{
                                cnt++;
                        }
                        ans = Math.max(ans,cnt);
                        if(tem.node.left!=null){
                                queue.offer(new MixedTreeNode(tem.node.left,tem.position*2,tem.depth+1));
                        }
                        if(tem.node.right!=null){
                                queue.offer(new MixedTreeNode(tem.node.right,tem.position*2+1,tem.depth+1));
                        }
                }
                return  ans;
        }
        private static class MixedTreeNode{
                TreeNode node;
                int position;
                int depth;
                public MixedTreeNode(TreeNode node,int position,int depth){
                        this.node = node;
                        this.position = position;
                        this.depth = depth;
                }
        }
}
