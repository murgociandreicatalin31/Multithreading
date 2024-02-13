package ro.ctrln.java.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoin {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        StringRecursiveAction stringRecursiveAction =
                new StringRecursiveAction("Un string foarte lung de procesat!");

        forkJoinPool.invoke(stringRecursiveAction);
    }
}
