package 题目;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/***
 * Java的linkedhashmap实现了LRU算法。其是通过hashmap+双向链表实现的。
 * 建立一个头节点和尾节点。每次set值时，将新的节点紧邻head节点。要删除的时候删除靠近尾节点的节点即可。
 */
public class LRU {
        static class Node{
                int key;
                int value;
                Node prev = null;
                Node next = null;
                public Node(int key,int value){
                        this.key = key;
                        this.value = value;
                }
        }
        private HashMap<Integer,Node> hashMap = new HashMap<>();
        private Node head = new Node(-1,-1);
        private Node tail = new Node(-1,-1);
        private int k;
        public int[] LRU(int[][] operators,int k){
                this.k = k;
                head.next = tail;
                tail.prev = head;
                int length = (int) Arrays.stream(operators).filter(x->x[0]==2).count();
                int[] ans = new int[length];
                int cnt = 0;
                for(int i = 0 ;i<operators.length;i++){
                        if(operators[i][0]==1)
                                set(operators[i][1],operators[i][2]);
                        else{
                                ans[cnt] = get(operators[i][1]);
                                cnt++;
                        }
                }
                return  ans;
        }
        public void set(int key,int value){
                if(hashMap.get(key)!=null){
                       hashMap.get(key).value = value;
                }else{
                        if(hashMap.size() >= k){
                                int removeKey = tail.prev.key;
                                tail.prev.prev.next = tail;
                                tail.prev = tail.prev.prev;
                                hashMap.remove(removeKey);
                        }
                        Node node = new Node(key,value);
                        hashMap.put(key,node);
                        removeToHead(node);
                }
        }
        public int get(int key){
                if(hashMap.get(key)==null){
                        return -1;
                }else{
                        Node node = hashMap.get(key);
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                        removeToHead(node);
                        return hashMap.get(key).value;
                }
        }
        public void removeToHead(Node node){
                head.next.prev = node;
                node.next = head.next;
                node.prev = head;
                head.next = node;
        }
        public static void main(String[] args) {

        }

}
