package 面试;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class 并查集 {
        Set<Integer> set = new HashSet();
        class UnionFindSet{
                //记录当前节点的父节点
                private HashMap<Integer,Integer> fatherMap;
                //记录当前集合的大小
                private HashMap<Integer,Integer> sizeMap;
                //记录所有集合中最大的集合
                private int maxNums = 1;
                public UnionFindSet(){
                        fatherMap = new HashMap();
                        sizeMap = new HashMap();
                }
                public void init(int[] nums){
                        for(int i=0; i<nums.length; i++){
                                //初始化时节点设为我自己
                                fatherMap.put(nums[i],nums[i]);
                                sizeMap.put(nums[i],1);
                        }
                }
                public Integer findRepresentNode(Integer node){
                        Integer father = fatherMap.get(node);
                        if(father!=node){
                                father = findRepresentNode(father);
                        }
                        //路径压缩
                        fatherMap.put(node,father);
                        return father;
                }
                public void union(Integer node1, Integer node2){
                        //要合并的两个元素中,有一个不存在
                        if(!set.contains(node1)||!set.contains(node2)){
                                return;
                        }
                        //二者存在于相同的集合内
                        int representNode1 = findRepresentNode(node1);
                        int representNode2 = findRepresentNode(node2);
                        if(representNode1 != representNode2){
                                int size1 = sizeMap.get(representNode1);
                                int size2 = sizeMap.get(representNode2);
                                if(size1>size2){
                                        fatherMap.put(representNode2,representNode1);
                                        sizeMap.put(representNode1,size1+size2);
                                        maxNums = Math.max(maxNums,size1+size2);
                                }else{
                                        fatherMap.put(representNode1,representNode2);
                                        sizeMap.put(representNode2,size1+size2);
                                        maxNums = Math.max(maxNums,size1+size2);
                                }
                        }
                }
        }

}
