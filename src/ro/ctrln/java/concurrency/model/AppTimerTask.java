package ro.ctrln.java.concurrency.model;

import java.util.TimerTask;

public class AppTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Taskul meu ruleaza!");
    }
}
