package core;

import com.sun.deploy.security.ruleset.Rule;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class First_Init {
    private User InitUser;
    private boolean isInitialize=false;
    private Rule memberRule;
    private MessageChannel messageChannel;

    public First_Init(Rule memberRule,MessageChannel messageChannel){
        this.memberRule=memberRule;
        this.messageChannel=messageChannel;
    }

    public First_Init(){ }

    public void stopInitialization(MessageReceivedEvent event){
        this.isInitialize=false;
        this.memberRule=null;
        this.messageChannel=null;
        if (InitUser!=null)
            event.getChannel().sendMessage(event.getAuthor().getName()+": is stopped my initialization >:(").queue();
        else event.getChannel().sendMessage("if u want to stop me first of all u need to start initialization by &start >3");
    }

    public Rule getMemberRule() {
        return memberRule;
    }

    public MessageChannel getMessageChannel() {
        return messageChannel;
    }

    public boolean isInitialize() {
        return isInitialize;
    }
}
