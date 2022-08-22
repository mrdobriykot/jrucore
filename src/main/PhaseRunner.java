package main;

import java.util.concurrent.Phaser;

public class PhaseRunner implements Runnable {

    Phaser phaser;
    String name;



    @Override
    public void run() {
        phaser.register();
    }
}
