package 面试;

import java.util.Deque;
import java.util.LinkedList;

public class Linux简化路径 {
    private StringBuilder sb = new StringBuilder();

    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList();
        String[] res = path.split("/");
        for (int i = 0; i < res.length; i++) {
            if (res[i].equals(".") || res[i].equals("")) {
                continue;
            } else if (res[i].equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                deque.offer(res[i]);
            }
        }
        sb.append("/");
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
            if (!deque.isEmpty()) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
