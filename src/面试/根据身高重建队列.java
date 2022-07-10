package 面试;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class 根据身高重建队列 {
    /**
     * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，
     * 前面 正好 有 ki 个身高大于或等于 hi 的人。
     *
     * 请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj]
     * 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）
     * 解体思路：
     * 先排序在插入
     * 按照高度降序，然后按照k升序
     * 高个子先站好位置，然后矮个子插到第k个位置上，钱买你肯定有k个高个子，矮个子插到前面也满足需求
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o2[0] - o1[0];
            }
        });
        LinkedList<int[]> ans = new LinkedList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(people);
    }
}
