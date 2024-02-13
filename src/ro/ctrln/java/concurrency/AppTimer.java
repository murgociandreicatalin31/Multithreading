package ro.ctrln.java.concurrency;

import ro.ctrln.java.concurrency.model.AppTimerTask;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Timer;
import java.util.TimerTask;

public class AppTimer {

    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();
        AppTimerTask appTimerTask = new AppTimerTask();

        //timer.schedule(appTimerTask, 1000);
        Thread.sleep(3000);

        //timer.schedule(appTimerTask, Date.from(LocalDate.of(2023, 8, 10).atStartOfDay().toInstant(ZoneOffset.UTC)));

        //timer.schedule(appTimerTask, Date.from(LocalDate.of(2023, 8, 10).atStartOfDay().toInstant(ZoneOffset.UTC)), 5000);

        timer.schedule(appTimerTask, 1000L, 1000L * 60L * 60L * 24L * 7L);
        //timer.cancel();
    }
}
