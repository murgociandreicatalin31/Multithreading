package ro.ctrln.java.locking;

public class Supplier {

    private boolean partBuilt = false;

    public void supplyPart(Builder builder) {
        while(!builder.isPartSupplied()) {
            System.out.println("Constructorul asteapta componente pentru piesa!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Piesa a fost furnizata!");
            this.partBuilt = true;
        }
    }
    public boolean isPartBuilt() {
            return partBuilt;
    }
}
