package introjunit;

public class Gentleman {
    public String name;

    public Gentleman(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String sayHello(/*String name*/) {
        if (name == null) {
            return "Hello Anonymous" ;
        } else {
            return "Hello " + name;
        }
    }

}
