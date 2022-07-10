package 面试;

import java.util.ArrayList;
import java.util.List;

public class 根节点到叶子节点路径之和为target的路径列表 {
        private List<List<Integer>> ans = new ArrayList();
        private List<Integer> tem = new ArrayList();
        private int sum = 0;
        public List<List<Integer>> pathSum(TreeNode root, int target) {
                solve(root,target);
                return ans;
        }
        public void solve(TreeNode cur,int target){
                if(cur == null)
                        return;
                if(cur.left == null && cur.right == null){
                        tem.add(cur.val);
                        sum += cur.val;
                        if(sum == target){
                                List<Integer> list = new ArrayList(tem);
                                ans.add(list);
                        }
                        sum -= cur.val;
                        tem.remove(tem.size()-1);
                }else{
                        sum+= cur.val;
                        tem.add(cur.val);
                        solve(cur.left,target);
                        solve(cur.right,target);
                        sum -= cur.val;
                        tem.remove(tem.size()-1);
                }
        }
}
