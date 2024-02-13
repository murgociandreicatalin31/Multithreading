package ro.ctrln.java.locking;


public class Builder {

    private boolean partSupplied = false;

    public void buildComponent(Supplier supplier) {
            while(!supplier.isPartBuilt()) {
                System.out.println("Constructorul asteapta o piesa de la furnizor!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Am terminat de construit piesa!");
                this.partSupplied = true;
            }
    }

    public boolean isPartSupplied() {
        return partSupplied;
    }
}
