package ro.ctrln.java.atomic_variables;

public class AtomicInteger {

    public static void main(String[] args) {

        java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(10);

        int value = atomicInteger.get();

        System.out.println("Valoarea initiala este: " + value);

        atomicInteger.set(1);

        System.out.println("Valoarea setata este: " + atomicInteger.get());

        value = atomicInteger.getAndSet(2);

        System.out.println("Valoarea veche de dinaintea apelului getAndSet: " + value);
        System.out.println("Valoarea noua de dupa apelul getAndSet: " + atomicInteger.get());

        boolean compareAndSet = atomicInteger.compareAndSet(9, 3);
        System.out.println("compareAndSet: " + compareAndSet);
        System.out.println("Valoarea de dupa apelul compareAndSet: " + atomicInteger.get());
    }
}
