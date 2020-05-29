package mute;

import java.util.ArrayList;
import java.util.Date;

public class MuteThread extends Thread {
    Date currDate;
    Date date;
    public MuteThread(Date date){
        this.date=date;
    }
    @Override
    public void run(){
        while (!isInterrupted()){
            if (MuteVars.muteds.size()==0){
                System.out.println("Muted List is empty");
                MuteVars.current=null;
                return;
            }
            try {
                sleep(6000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread()+"-interrupted");
                return;
            }
            currDate=new Date();
            for (int i = 0; i < MuteVars.muteds.size()-1 ; i++) {
                if (currDate.after(MuteVars.muteds.get(i).getUnMuteDate())) {
                    System.out.println("Unmuted " + MuteVars.muteds.get(i).getUser().getName() + " in thread" + Thread.currentThread());
                    MuteMain.UnMute(i);

                } else {
                    System.out.println("after");
                }
            }
        }
    }
}
