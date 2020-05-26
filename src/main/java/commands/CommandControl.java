package commands;

import core.Bot;
import core.First_Init;
import core.Languages;
import mute.MuteMain;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandControl {
    private MessageReceivedEvent event;
    private String message;
    private MuteMain mm;
    {
        mm=new MuteMain();
    }
    public CommandControl(MessageReceivedEvent event){
        this.event=event;
        this.message=event.getMessage().getContentRaw();
        controller();
    }
    //это мэйн для всех команд. проверять тут
    private void controller(){
        if  (message.equals("&start"))  First_Init.Initialize(event);
        if  (message.equals("&rus")) Bot.languages=Languages.RUSSIAN;
        if  (message.equals("&eng")) Bot.languages=Languages.ENGLISH;
        if  (message.equals("&f"))new ShowCommands().Show(event);
        if  (message.equals("&rainbow")) new Rainbow(event).start();
        if  (message.equals("&test")) mm.Check(event);

    }
}
