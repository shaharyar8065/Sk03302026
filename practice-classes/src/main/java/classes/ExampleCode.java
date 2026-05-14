package classes;

public class ExampleCode {

    private int id;
    private String name;

    public ExampleCode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExampleCode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    // 1. INTERFACE: Defines a "capability" (What it CAN do)
    interface Swimmable {
        void swim(); // Methods are public and abstract by default
    }

    // 2. ABSTRACT CLASS: Defines a "blueprint" (What it IS)
    abstract class Animal {
        String name;

        // Abstract classes can have constructors
        Animal(String name) { this.name = name; }

        // Abstract method: Force children to implement their own sound
        abstract void makeLowSound();

        // Concrete method: Shared logic for all animals
        void sleep() {
            System.out.println(name + " is sleeping...");
        }
    }

    // 3. INHERITANCE: Combining everything
    class Duck extends Animal implements Swimmable {

        Duck(String name) { super(name); }

        @Override
        void makeLowSound() {
            System.out.println("Quack!");
        }

        @Override
        public void swim() {
            System.out.println("Duck is floating on water.");
        }
    }

    //overloading and overriding

    class Calculator {
        // OVERLOADING: Same name, different parameters (Compile-time)
        int add(int a, int b) { return a + b; }
        int add(int a, int b, int c) { return a + b + c; }
    }

    class AdvancedCalculator extends Calculator {
        // OVERRIDING: Same name and params, changing behavior (Runtime)
        @Override
        int add(int a, int b) {
            System.out.println("Adding with logs...");
            return a + b;
        }


        // Exception handling try catch finally


    }
    public class ExceptionDemo {
        public void divide(int a, int b) {
            try {
                int result = a / b;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                // Handle the specific error
                System.out.println("Error: Cannot divide by zero!");
            } finally {
                // ALWAYS runs (used for closing resources)
                System.out.println("Cleanup: Closing connection...");
            }
        }
    }

    public class ExceptionExpert {

        // THROWS: Declares that this method *might* fail (The Warning)
        public void checkAge(int age) throws IllegalArgumentException {

            if (age < 18) {
                // THROW: Actually triggers the error right now (The Action)
                throw new IllegalArgumentException("Access Denied: Must be 18+");
            } else {
                System.out.println("Access Granted");
            }
        }
    }


}
