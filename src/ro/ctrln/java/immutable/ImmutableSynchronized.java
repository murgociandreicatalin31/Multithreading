package ro.ctrln.java.immutable;

public class ImmutableSynchronized {

    private Immutable bittnetImmutable;

    public synchronized void setBittnetImmutable(Immutable bittnetImmutable) {
        this.bittnetImmutable = bittnetImmutable;
    }

    public synchronized Immutable getBittnetImmutable() {
        return bittnetImmutable;
    }

    public synchronized void append(String extraName) {
        this.bittnetImmutable = this.bittnetImmutable.append(extraName);
    }
}
