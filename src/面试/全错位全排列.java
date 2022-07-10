package 面试;

import java.util.ArrayList;

public class 全错位全排列 {
        private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        private ArrayList<Integer> tem = new ArrayList<>();
        private boolean[] isUsed;
        public ArrayList<ArrayList<Integer>> wrongPermutation(int n){
                isUsed = new boolean[n];
                solve(9,0);
                return ans;
        }
        public void solve(int n,int cur){
                if(cur == n){
                        ArrayList<Integer> ans1 = new ArrayList();
                        for(Integer integer:tem)
                                ans1.add(integer);
                        ans.add(ans1);
                        return;
                }
                for(int i=0;i<n;i++){
                        if(i == cur || isUsed[i])
                                continue;
                        else {
                                tem.add(i+1);
                                isUsed[i] = true;
                                solve(n,cur+1);
                                tem.remove((Integer)(i+1));
                                isUsed[i] = false;
                        }
                }
        }

        public static void main(String[] args) {
               ArrayList<ArrayList<Integer>> ans = new 全错位全排列().wrongPermutation(9);
                for(int i=0;i<ans.size();i++){
                        for(int j=0;j<ans.get(i).size();j++){
                                System.out.print(ans.get(i).get(j));
                        }
                        System.out.println();
                }

        }
}
