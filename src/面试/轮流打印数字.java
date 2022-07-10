package 面试;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 轮流打印数字 {
        private Lock threadLock = new ReentrantLock();
        private int flag = 0;
        private int count  = 10;
        Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                        while(true){
                                threadLock.lock();
                                try {
                                        if(count<1)
                                                return;
                                        if(count % 3 == 0){
                                                System.out.println("thread1:"+ count);
                                                count--;
                                        }
                                }catch (Exception e){

                                }finally {
                                        threadLock.unlock();
                                }
                        }
                }
        });
        Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                        while(true){
                                threadLock.lock();
                                try {
                                        if(count<1)
                                                return;
                                        if(count % 3 == 1){
                                                System.out.println("thread2:"+ count);
                                                count --;
                                        }
                                }catch (Exception e){

                                }finally {
                                        threadLock.unlock();
                                }
                        }
                }
        });
        Thread thread3 = new Thread(new Runnable() {
                @Override
                public void run() {
                        while(true){
                                threadLock.lock();
                                try {
                                        if(count<1)
                                                return;
                                        if(count % 3 == 2){
                                                System.out.println("thread3:"+ count);
                                                count --;
                                        }
                                }catch (Exception e){

                                }finally {
                                        threadLock.unlock();
                                }
                        }
                }
        });
        public void startThreeThread(){
                thread1.start();
                thread2.start();
                thread3.start();
        }
        public static void main(String[] args) {
                轮流打印数字 a = new 轮流打印数字();
                a.startThreeThread();
        }
}
