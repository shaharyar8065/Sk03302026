package org.example;

//public class Test {
//
//    private int id;
//    private String name;
//
//    public Test(int id, String name){
//
//        this.id = id;
//        this.name = name;
//
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//
//    @Override
//    public String toString() {
//        return "Test{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//public class main {
//    public static void main(String[] args)
//
//    {
//        System.out.println("My name is Shaharyar");
//
//    }
//}
//object.method()
//
//    public class Test{
//        public static void staticMethod(){
//            System.out.println("object is not needed");
//        }
//    }

import java.util.HashMap;

public  class Test{
        public void devide(int a  , int b){


            try{ int result = a/b;
        }catch (ArithmeticException e){
                System.out.println("you cannot devide with zero");
            }
            finally {
                System.out.println("clean and close");
            }
        }
        public static void main (String[] args){
            Test test = new Test();
            test.devide(10,0);
        }
        public class Test{
            public void checkAge (int age)throws IllegalArgumentException{
                if (age < 18){
                    throw new IllegalArgumentException("Not allowed");
                }else {
                    System.out.println("Allowed");
                }
            }
        }
        HashMap<Integer, String> inventory = new HashMap<>();

    }



