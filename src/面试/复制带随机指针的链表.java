package 面试;

import java.util.HashMap;

public class 复制带随机指针的链表 {
    /***
     * LeetCode 138
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     *
     * 构造这个链表的 深拷贝。
     * @param head
     * @return
     */

    public RandomNode copyRandomList(RandomNode head) {
        //利用HashMap构造旧节点和新节点的拷贝
        if(head == null)
            return null;
        HashMap<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode tem = head;
        while (tem != null) {
            RandomNode newNode = new RandomNode(tem.val);
            map.put(tem, newNode);
            tem = tem.next;
        }
        tem = head;
        while (tem != null){
            map.get(tem).next = map.get(tem.next);
            map.get(tem).random = map.get(tem.random);
            tem = tem.next;
        }
        return map.get(head);
    }
}

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
