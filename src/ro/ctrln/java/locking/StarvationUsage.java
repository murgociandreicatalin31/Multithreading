package ro.ctrln.java.locking;

public class StarvationUsage {

    public static void main(String[] args) {

        Starvation starvation = new Starvation();
        for (int i = 0; i < 10; i++) {
            new Thread(starvation::starve).start();
        }
    }
}
