package mute;

import java.util.ArrayList;

public class MuteThread extends Thread {
    ArrayList<Muted> muteds;
    public MuteThread(ArrayList<Muted> muteds){
    this.muteds=muteds;
    }
    @Override
    public void run(){
        while (true){
            System.out.println("true");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("interrupt");
                return;
            }
        }
    }
}
