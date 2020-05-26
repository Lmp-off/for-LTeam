package mute;

import java.util.ArrayList;
import java.util.Date;

public class MuteThread extends Thread {
    ArrayList<Muted> muteds;
    Date currDate;
    Date date;
    public MuteThread(ArrayList<Muted> muteds,Date date){
        this.muteds=muteds;
        this.date=date;
    }
    @Override
    public void run(){
        while (!isInterrupted()){
            try {
                sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currDate=new Date();
            if(date.before(currDate)){
                System.out.println(date+"-before-"+currDate);
            }
            else{
                System.out.println("after");
            }
        }
    }
}
