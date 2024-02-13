package ro.ctrln.java.locking;

public class StarvationSolutionUsage {

    public static void main(String[] args) {

        StarvationSolution starvation = new StarvationSolution();
        for (int i = 0; i < 10; i++) {
            new Thread(starvation::starve).start();
        }
    }
}
