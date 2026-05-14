package org.example;

public class Main {
    public static void main(String[] args) {
        long startingPaper = 20;
        long extraPaper = 50;

        InkjetPrinter myPrinter = new InkjetPrinter("HP Envy", false, startingPaper, false);

        myPrinter.addPaper(extraPaper);
        myPrinter.toggleConnection();

        myPrinter.refillInk(true);
        myPrinter.connect();

        long currentPaper = myPrinter.getPaperCount();

        System.out.println("Model: " + myPrinter.getModelType());
        System.out.println("Current Paper: " + currentPaper);
        System.out.println("Has Ink? " + myPrinter.isHasInk());

        System.out.println(myPrinter.toString());
    }
}