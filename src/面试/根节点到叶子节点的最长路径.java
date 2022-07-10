package 面试;

import java.util.ArrayList;

public class 根节点到叶子节点的最长路径 {
        private static TreeNode root;
        //存储最大路径
        private ArrayList<Integer> longestPath = new ArrayList<>();
        //存储当前递归得到的路径
        private ArrayList<Integer> path = new ArrayList<>();
        private int depth = 0;//当前递归得到的路径长度
        private int maxDepth = 0;
        public void getLongestPath(TreeNode node){
                if(node == null)
                        return;
                //找到叶子节点
                if(node.left == null && node.right == null){
                        path.add(node.val);
                        if(depth > maxDepth){
                                maxDepth = depth;
                                for(int i=0;i<=depth;i++){
                                        if(i<longestPath.size()){
                                                longestPath.set(i,path.get(i));
                                        }else{
                                                longestPath.add(path.get(i));
                                        }
                                }
                        }
                        path.remove(path.size()-1);
                }else{
                        path.add(node.val);
                        depth++;
                        getLongestPath(node.left);
                        getLongestPath(node.right);
                        depth--;
                        path.remove(path.size()-1);
                }

        }
        private void insert(int data){
                TreeNode node = new TreeNode(data);
                if(root == null)
                        root = node;
                else{
                        TreeNode cur = root;
                        TreeNode parent;
                        while (true){
                                if(node.val <= cur.val){
                                        parent = cur;
                                        cur = cur.left;
                                        if(cur == null){
                                                parent.left = node;
                                                return;
                                        }
                                }else{
                                        parent = cur;
                                        cur = cur.right;
                                        if(cur == null){
                                                parent.right = node;
                                                return;
                                        }
                                }
                        }
                }
        }
        public static void main(String[] args) {
                根节点到叶子节点的最长路径 s = new 根节点到叶子节点的最长路径();
                s.insert(7);
                s.insert(1);
                s.insert(32);
                s.insert(0);
                s.insert(3);
                s.insert(20);
                s.insert(40);
                s.insert(2);
                s.insert(10);
                s.insert(25);
                s.insert(35);
                s.insert(23);
                s.getLongestPath(root);
                for(int i=0;i<s.longestPath.size();i++){
                        System.out.print(s.longestPath.get(i)+" ");
                }
        }
}
