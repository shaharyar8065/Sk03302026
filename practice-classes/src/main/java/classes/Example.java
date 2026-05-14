package classes;

import java.util.HashMap;

public class Example {

    public void checkAge(int age) throws IllegalArgumentException{
        if(age < 18){
            throw new IllegalArgumentException("not allowed");
        }else{
            System.out.println("access granted");
        }

    }

    public void devide(int a, int b){
        try{
            int result = a/b;
            System.out.println("Result:" + result);
        }
        catch (ArithmeticException e ){
            System.out.println("cannot devide by zero");
        }
        finally {
            System.out.println("clean up the code");
        }

    }

    //for hashmap
    map<Integer, String>Employee = new HashMap<>();
    // 2. Insert data (put)
        employees.put(101, "Alice");



}
