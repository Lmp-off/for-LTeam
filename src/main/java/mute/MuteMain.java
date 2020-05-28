package mute;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import settings.CONSTS;

import java.util.ArrayList;
import java.util.Date;

public class MuteMain {
    public ArrayList<Muted> userArrayList = new ArrayList<>();
    Date current;
    //TODO:if mute f will stopped write in the main channel info about muted members(если админы выключат функцию мута то вывести список замученых в главный канал)
    //TODO:finish Check(){}.Make normal filters and test(доделать функцию и затестить)
    public void Check(MessageReceivedEvent message){
        if (message.getMessage().getContentRaw().replaceAll(CONSTS.prefix,"").equals("test")){
            System.out.println("test");
            current = new Date();
            userArrayList.add(new Muted(message.getAuthor(),message.getChannel(),current,new Date(current.getYear(),current.getMonth(),current.getDate(),current.getHours(),current.getMinutes()+1)));
            MuteThread mt = new MuteThread(userArrayList,new Date());
            mt.start();
        }
    }
    public void UnMute(int index){
        userArrayList.remove(index);
        System.out.println("success");
    }

}
