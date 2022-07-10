import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class T1 {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                int n  = scanner.nextInt();
                int x  = scanner.nextInt();
                long[] num =  new long[n];
                for(int i = 0 ; i<n ;i++){
                        num[i] = scanner.nextLong();
                }
                Room[] rooms = new Room[n];
                for(int i = 0;i<n;i++){
                        Room room  = new Room(num[i],i+1);
                        rooms[i] = room;
                }
                Arrays.sort(rooms, new Comparator<Room>() {
                        @Override
                        public int compare(Room o1, Room o2) {
                                if(o1.num>o2.num)
                                        return 1;
                                else if(o1.num<o2.num)
                                        return -1;
                                else{
                                        return o1.pos - o2.pos;
                                }
                        }
                });
                int[] pos = new int[n];
                int cnt=0;
                for(int i = 0;i<n;i++){
                        if(rooms[i].num!=rooms[0].num)
                                break;
                        else{
                                pos[cnt] = rooms[i].pos;
                                cnt++;
                        }
                }
                int tem=-1;
                for(int i = 0  ;i<cnt;i++){
                        if(x<pos[i]){
                                tem = i-1;
                                if(tem<0){
                                        tem=cnt-1;
                                }
                                break;
                        }else if(x>pos[i]){
                                if(i==cnt-1)
                                        tem=cnt-1;
                                        continue;
                        }
                        else{
                               tem=i;
                               break;
                        }
                }
                int i =tem;
                        long[] helpArr = new long[n];
                        System.arraycopy(num,0,helpArr,0,n);
                        if(pos[i] == x){
                                int j  =0;
                                long sum=0;
                                for(j = 0 ; j <n;j++){
                                        helpArr[j] -=num[pos[i]-1];
                                        sum+=num[pos[i]-1];
                                }
                                      helpArr[pos[i]-1]+= sum;
                                      for(int k =0;k<n;k++)
                                              System.out.print(helpArr[k]+" ");
                        }else if(pos[i]<x){

                                long sum=0;
                                for(int j  = pos[i];j<=x-1;j++){
                                        helpArr[j] -=(num[pos[i]-1]+1);
                                        sum+=num[pos[i]-1]+1;

                                }
                                for(int j = x;;j++){
                                        if(j>=n){
                                              j=(j-n)%n;
                                        }
                                        helpArr[j]-=num[pos[i]-1];
                                        sum+=num[pos[i]-1];
                                        if(j==pos[i]-1)
                                                break;
                                }
                                helpArr[pos[i]-1]+=sum;
                                for(int k =0;k<n;k++)
                                        System.out.print(helpArr[k]+" ");
                        }else if(pos[i]>x){
                                boolean flag = true;
                                long sum=0;
                                for(int j = x;j<=pos[i]-1;j++){
                                        helpArr[j]-=num[pos[i]-1];
                                        sum+=num[pos[i]-1];
                                }
                                for(int j=pos[i];;j++){
                                        if(j>=n){
                                                j=(j-n)%n;
                                        }
                                        helpArr[j]-=(num[pos[i]-1]+1);
                                        sum+=num[pos[i]-1]+1;
                                        if(j==x-1)
                                                break;
                                }
                                helpArr[pos[i]-1]+=sum;
                                for(int k =0;k<n;k++)
                                        System.out.print(helpArr[k]+" ");
                        }



        }
}
class Room{
        long num;
        int pos;
        public Room(long num , int pos){
                this.num = num;
                this.pos = pos;
        }
}
