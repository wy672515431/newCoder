package 面试;

public class 二叉排序树的建立 {
        //根
        private TreeNode root;
        private void insert(int data){
                TreeNode node = new TreeNode(data);
                if(root == null)
                        root = node;
                else{
                        TreeNode cur = root;
                        TreeNode parent;
                        while (true){
                                if(node.val < cur.val){
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
}
