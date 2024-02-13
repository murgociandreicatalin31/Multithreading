package ro.ctrln.java;

public class AtomicReference {

    public static void main(String[] args) {

        java.util.concurrent.atomic.AtomicReference<String> atomicReference = new java.util.concurrent.atomic.AtomicReference("initial");

        String value = atomicReference.get();

        System.out.println("Valoarea initiala este: " + value);

        atomicReference.set("one");

        System.out.println("Valoarea setata este: " + atomicReference.get());

        value = atomicReference.getAndSet("two");

        System.out.println("Valoarea veche de dinaintea apelului getAndSet: " + value);
        System.out.println("Valoarea noua de dupa apelul getAndSet: " + atomicReference.get());

        boolean compareAndSet = atomicReference.compareAndSet("four", "three");
        System.out.println("compareAndSet: " + compareAndSet);
        System.out.println("Valoarea de dupa apelul compareAndSet: " + atomicReference.get());

        atomicReference.lazySet("six");
        System.out.println("Valoarea dupa lazySet: " + atomicReference.get());
    }
}
