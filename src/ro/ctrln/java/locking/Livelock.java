package ro.ctrln.java.locking;

public class Livelock {

    public static void main(String[] args) {

        Builder builder = new Builder();
        Supplier supplier = new Supplier();

        Thread threadOne = new Thread(() -> builder.buildComponent(supplier));
        threadOne.start();
        Thread threadTwo = new Thread(() -> supplier.supplyPart(builder));
        threadTwo.start();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> builder.buildComponent(supplier)).start();
        }

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> supplier.supplyPart(builder)).start();
        }
    }
}
