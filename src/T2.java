
        import java.security.PublicKey;
        import java.util.*;
        public class T2 {
                public static void main(String[] args) {
                        Scanner scanner = new Scanner(System.in);
                        int n = scanner.nextInt();
                        int m = scanner.nextInt();
                        scanner.nextLine();
                        char[][] maze =  new char[n][m];
                        for(int i = 0;i<n;i++){
                                String str = scanner.nextLine();
                                for(int j=0;j<m;j++){
                                        maze[i][j] = str.charAt(j);
                                }
                        }
                        int personX =0,personY=0,boxX=0,boxY=0;
                        for(int i = 0;i<n;i++){
                                for(int j = 0;j<m;j++){
                                        if(maze[i][j] == 'S'){
                                                personX=i;
                                                personY=j;
                                        }
                                        if (maze[i][j] == '0') {
                                                boxX=i;
                                                boxY=j;
                                        }
                                }
                        }
                        System.out.println(solve(maze,personX,personY,boxX,boxY));
                }

                public static int solve(char[][] maze,int startPersonX,int startPersonY,int startBoxX,int startBoxY){
                        Node startNode = new Node(startPersonX,startPersonY,startBoxX,startBoxY);
                        boolean[][][][] isVisited = new boolean[maze.length][maze[0].length][maze.length][maze[0].length];
                        Direction[] directions = new Direction[4];
                        //上
                        directions[0] = new Direction(-1,0);
                        //下
                        directions[1] = new Direction(1,0);
                        //左
                        directions[2] = new Direction(0,-1);
                        //右
                        directions[3] = new Direction(0,1);
                        startNode.dis=0;
                        Queue<Node> queue = new LinkedList<>();
                        queue.add(startNode);
                        while (!queue.isEmpty()){
                                Node cur = queue.poll();
                                int newBoxX = cur.boxX;
                                int newBoxY = cur.boxY;
                                for(int i = 0 ;i<4;i++){
                                        //如果人在箱子的左右
                                        if(cur.personX == cur.boxX){
                                                if(cur.personY+directions[i].dirY == cur.boxY){
                                                        newBoxY = cur.boxY+directions[i].dirY;
                                                }else
                                                        newBoxY = cur.boxY;
                                        }
                                        //如果人在箱子的上下
                                        if(cur.personY == cur.boxY){
                                                if(cur.personX+directions[i].dirX == cur.boxX){
                                                        newBoxX = cur.boxX+directions[i].dirX;
                                                }else
                                                        newBoxX = cur.boxX;
                                        }
                                        Node newNode = new Node(cur.personX+directions[i].dirX,cur.personY+directions[i].dirY,newBoxX,newBoxY);
                                        if(newNode.personX<0||newNode.personX>=maze.length||newNode.personY<0||
                                        newNode.personY>=maze[0].length||maze[newNode.personX][newNode.personY]=='#')
                                                continue;
                                        if(newNode.boxX<0||newNode.boxX>=maze.length||newNode.boxY<0||
                                                newNode.boxY>=maze[0].length||maze[newNode.boxX][newNode.boxY]=='#')
                                                continue;
                                        if(!isVisited[newNode.personX][newNode.personY][newNode.boxX][newNode.boxY]){
                                                isVisited[newNode.personX][newNode.personY][newNode.boxX][newNode.boxY]=true;
                                                newNode.dis = cur.dis+1;
                                                if(maze[newNode.boxX][newNode.boxY]=='E')
                                                        return newNode.dis;
                                                queue.add(newNode);
                                        }
                                }

                        }


                        return -1;
                }

        }
        class Node{
                int personX;
                int personY;
                int boxX;
                int boxY;
                int dis;
                public Node(int personX,int personY,int boxX,int boxY){
                        this.personX = personX;
                        this.personY = personY;
                        this.boxX = boxX;
                        this.boxY = boxY;
                }
        }
        class Direction{
                int dirX;
                int dirY;
                public Direction(int dirX,int dirY){
                        this.dirX =dirX;
                        this.dirY =dirY;
                }
        }

