package main;

public class Main {
    private static Start start = new Start();
    public static void main(String[] args) {
        Thread newThread = new Thread(new Start());
        newThread.start();
    }
}