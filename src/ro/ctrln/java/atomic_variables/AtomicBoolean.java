package ro.ctrln.java.atomic_variables;

public class AtomicBoolean {

    public static void main(String[] args) {

        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean();

        boolean value = atomicBoolean.get();

        System.out.println("Valoarea initiala este: " + value);

        atomicBoolean.set(true);

        System.out.println("Valoarea setata este: " + atomicBoolean.get());

        value = atomicBoolean.getAndSet(false);

        System.out.println("Valoarea veche de dinaintea apelului getAndSet: " + value);
        System.out.println("Valoarea noua de dupa apelul getAndSet: " + atomicBoolean.get());

        boolean compareAndSet = atomicBoolean.compareAndSet(true, true);
        System.out.println("compareAndSet: " + compareAndSet);
        System.out.println("Valoarea de dupa apelul compareAndSet: " + atomicBoolean.get());
    }
}
