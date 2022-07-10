package vm;

import java.io.IOException;
import java.io.InputStream;

public class VMTest {
    private volatile static VMTest instance;

    public static VMTest getInstance() {
        if(instance == null){
            synchronized (VMTest.class){
                instance = new VMTest();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        VMTest.getInstance();
    }
}
