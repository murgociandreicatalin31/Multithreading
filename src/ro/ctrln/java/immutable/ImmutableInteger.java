package ro.ctrln.java.immutable;

public class ImmutableInteger {

    private int value;

    public ImmutableInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ImmutableInteger increment() {
        return new ImmutableInteger(this.value + 1);
    }
}
