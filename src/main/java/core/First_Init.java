package core;

import com.sun.deploy.security.ruleset.Rule;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class First_Init {
    private User InitUser;
    private boolean isInitialize=false;
    private String memberRuleID;
    private String messageChannelID;

    public First_Init(){ }

    public void stopInitialization(MessageReceivedEvent event){
        this.isInitialize=false;
        this.memberRuleID=null;
        this.messageChannelID=null;
        if (InitUser!=null)
            event.getChannel().sendMessage(event.getAuthor().getName()+": is stopped my initialization >:(").queue();
        else event.getChannel().sendMessage("if u want to stop me first of all u need to start initialization by &start >3");
    }

    public String getMemberRule() {
        return memberRuleID;
    }

    public String getMessageChannel() {
        return messageChannelID;
    }

    public boolean isInitialize() {
        return isInitialize;
    }

    public void Initialize(MessageReceivedEvent event){
        if (InitUser==null&&event.getMessage().getContentRaw().equals("&start")){
            InitUser=event.getAuthor();
            event.getChannel().sendMessage("Ok you've started my initialization,\nnow you need to enter your private text channel ID where you can control me(&f-to show all my functions)").queue();
        }
        else if(messageChannelID==null){
            try{
                event.getGuild().getTextChannelById(event.getMessage().getContentRaw());
                messageChannelID=event.getMessage().getContentRaw();
            }
            catch (Exception e){
                event.getChannel().sendMessage("This is not channel ID\n(right click to your private text channel and click to copy chanel ID ").queue();
            }
        }

    }
}
