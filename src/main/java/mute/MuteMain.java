package mute;

import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;

public class MuteMain {
    protected static boolean isWorking=true;
    protected ArrayList<Muted> userArrayList;
    //if mute f will stopped write in the main channel info about muted members(если админы выключат функцию мута то вывести список замученых в главный канал)
    public void Check(String message){
        MuteThread mt = new MuteThread(userArrayList);
        mt.start();
        mt.interrupt();
    }
}
