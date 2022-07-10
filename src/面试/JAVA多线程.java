package 面试;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;

public class JAVA多线程 {
        public static void main(String[] args) {
                Container container = new Container();
                Thread t1 = new Thread(new Producer(container));
                Thread t2 = new Thread(new Consumer(container));
                t1.start();
                t2.start();
        }
        static class Container{
                LinkedList<Integer> list = new LinkedList<>();
                int maxCapacity = 10;
                public void put(int value){
                        while(true){
                                try{
                                        Thread.sleep(1000);
                                }catch (InterruptedException e){
                                        e.printStackTrace();;
                                }
                                synchronized (this){
                                        while(list.size() == maxCapacity){
                                                System.out.println("容器满了！！");
                                                try {
                                                        wait();
                                                }catch (InterruptedException e){
                                                        e.printStackTrace();
                                                }
                                        }
                                        System.out.println("生产了"+value+"号产品");
                                        list.add(value++);
                                        notifyAll();
                                }
                        }
                }
                public void take(){
                        int val = 0;
                        while (true){
                                try {
                                        Thread.sleep(1000);
                                }catch (InterruptedException e){
                                        e.printStackTrace();
                                }
                                synchronized (this){
                                        while (list.size() == 0){
                                                System.out.println("没东西");
                                                try {
                                                        wait();
                                                }catch (InterruptedException e){
                                                        e.printStackTrace();
                                                }
                                        }
                                        val = list.removeFirst();
                                        System.out.println("消费了"+val+"号产品");
                                        notifyAll();
                                }
                        }
                }
        }
        static class Producer implements Runnable{
                private Container container;
                public Producer(Container container){
                        this.container = container;
                }
                @Override
                public void run(){
                        container.put(0);
                }
        }
        static class Consumer implements Runnable{
                private Container container;
                public Consumer(Container container){
                        this.container = container;
                }
                @Override
                public void run(){
                        container.take();
                }
        }


}
