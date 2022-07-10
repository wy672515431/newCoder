package 面试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 组合总数 {
    /**
     * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合
     * candidates中的每个数字在每个组合中只能使用一次
     */
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> tem = new ArrayList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //从小到大排序
        Arrays.sort(candidates);
        solve(candidates, target, 0);
        return ans;
    }

    //不能有重复的
    private void solve(int[] candidates, int target, int pos) {
        if (pos >= candidates.length)
            return;
        int lastPos = pos;
        for (int i = pos; i < candidates.length; i++) {
            if (i != lastPos && candidates[i] == candidates[i - 1])
                continue;
            lastPos = i;
            sum += candidates[i];
            tem.add(candidates[i]);
            if (sum == target) {
                List<Integer> tem1 = new ArrayList(tem);
                ans.add(tem1);
                sum -= candidates[i];
                tem.remove(tem.size() - 1);
                return;
            } else if (sum < target) {
                solve(candidates, target, i + 1);
                sum -= candidates[i];
                tem.remove(tem.size() - 1);
            }else{
                sum -= candidates[i];
                tem.remove(tem.size() - 1);
                return;
            }
        }
    }
}
