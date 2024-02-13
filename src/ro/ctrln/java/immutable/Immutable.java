package ro.ctrln.java.immutable;

public class Immutable {

    private String name;

    public Immutable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Immutable append(String extraName) {
        return new Immutable(this.name.concat(extraName));
    }
}
