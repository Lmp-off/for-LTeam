package commands;

import core.Bot;
import core.First_Init;
import core.Languages;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandControl {
    private MessageReceivedEvent event;
    private String message;
    public CommandControl(MessageReceivedEvent event){
        this.event=event;
        this.message=event.getMessage().getContentRaw();
        controller();
    }
    //это мэйн для всех команд. проверять тут
    private void controller(){
        if  (message.equals("&start"))  First_Init.Initialize(event);
        if (message.equals("&rus")) Bot.languages=Languages.RUSSIAN;
        if (message.equals("&eng")) Bot.languages=Languages.ENGLISH;
        if (message.equals("&f"))new ShowCommands().Show(event);

    }
}
