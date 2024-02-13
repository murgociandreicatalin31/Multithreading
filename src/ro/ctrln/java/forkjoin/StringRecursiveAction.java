package ro.ctrln.java.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class StringRecursiveAction extends RecursiveAction {

    private String processingString = "";
    private static final int MAXIMUM = 4;

    public StringRecursiveAction(String processingString) {
        this.processingString = processingString;
    }


    @Override
    protected void compute() {
        if(processingString.length() > MAXIMUM) {
            ForkJoinTask.invokeAll(splitWork());
        } else {
            process(processingString);
        }
    }

    private List<StringRecursiveAction> splitWork() {
        List<StringRecursiveAction> workSplit = new ArrayList<>();

        String partOne = processingString.substring(0, processingString.length() / 2);
        String partTwo = processingString.substring(processingString.length() / 2);

        workSplit.add(new StringRecursiveAction(partOne));
        workSplit.add(new StringRecursiveAction(partTwo));

        return workSplit;
    }

    private void process(String workedPiece) {
        System.out.println("Acest rezultat [" + workedPiece.concat("z") + "] a fost procesat de threadul " +
                Thread.currentThread().getName());
    }
}
