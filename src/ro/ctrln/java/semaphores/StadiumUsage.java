package ro.ctrln.java.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class StadiumUsage {

    public static void main(String[] args) {

        int places = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(places);

        Stadium stadium = new Stadium(places);

        IntStream.range(0, places).forEach(spectator -> executorService.execute(stadium::tryToAccess));

        executorService.shutdown();

        System.out.println("Mai sunt locuri pe stadion? " + (stadium.availablePlaces() == 0 ? "NU" : "DA"));
        stadium.exitStadium();
        System.out.println("Mai sunt locuri disponibile dupa ce a iesit un spectator? " + (stadium.availablePlaces() > 0 ? "DA" : "NU"));
        System.out.println("Mai este disponibil accesul pe stadion? " + (stadium.tryToAccess() ? "DA" : "NU"));
        System.out.println("Mai este disponibil accesul pe stadion? " + (stadium.tryToAccess() ? "DA" : "NU"));
    }
}
