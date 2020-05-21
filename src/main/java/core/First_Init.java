package core;

import com.sun.deploy.security.ruleset.Rule;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class First_Init {
    private boolean eng;
    private User InitUser;
    private boolean isInitialize=false;
    private String memberRoleID;
    private String messageChannelID;

    public First_Init(){ }

    public void stopInitialization(MessageReceivedEvent event){
        this.isInitialize=false;
        this.memberRoleID=null;
        this.messageChannelID=null;
        if (InitUser!=null)
            event.getChannel().sendMessage(event.getAuthor().getName()+": is stopped my initialization >:(").queue();
        else event.getChannel().sendMessage("if u want to stop me first of all u need to start initialization by &start >3");
    }

    public String getMemberRule() {
        return memberRoleID;
    }

    public String getMessageChannel() {
        return messageChannelID;
    }

    public boolean isInitialized() {
        return isInitialize;
    }

    public void Initialize(MessageReceivedEvent event){
        if (InitUser==null&&event.getMessage().getContentRaw().equals("&rus")){
            eng = false;
            event.getChannel().sendMessage("язык переключён на русский").queue();
        }


        else if (InitUser==null&&event.getMessage().getContentRaw().equals("&start")){//1
            System.out.println(InitUser);
            InitUser=event.getAuthor();
            if (eng)
                event.getChannel().sendMessage("Ok "+InitUser.getName()+" started my initialization,\nnow you need to enter your private text channel ID where you can control me(&f-to show all my functions)").queue();
            else
                event.getChannel().sendMessage("ок "+InitUser.getName()+" начал мою настройку,\nсейчас тебе нужно ввести id канала в который будет доступен только тебе(&f покажет полный список команд)").queue();
            return;
        }

        if(messageChannelID==null&&InitUser!=null){//2
            if (event.getAuthor()!=InitUser){
                if(eng)
                    event.getChannel().sendMessage("Initialization can be continued by "+InitUser.getName()+"\nif you want to cancel initialization tap &stop").queue();
                else
                    event.getChannel().sendMessage("настройка может быть продолжена "+InitUser.getName()+"\nif you want to cancel initialization tap &stop").queue();
                return;
            }
            else {
                try {
                    event.getGuild().getTextChannelById(event.getMessage().getContentRaw());
                    messageChannelID = event.getMessage().getContentRaw();
                    event.getChannel().sendMessage("Now the last you need to write member role").queue();
                    return;
                } catch (Exception e) {
                    event.getChannel().sendMessage("This is not channel ID\n(right click to your private text channel and click to copy chanel ID ").queue();
                    return;
                }
            }
        }
        if (memberRoleID==null&&messageChannelID!=null) { //3
            try {
                event.getGuild().getRoleById(event.getMessage().getContentRaw());
                memberRoleID = event.getMessage().getContentRaw();
                isInitialize = true;
                event.getChannel().sendMessage("init was correct\n••••••••••••••••••\n"
                        +InitUser.getName()+" - is the main administrator\n"
                        +event.getGuild().getRoleById(memberRoleID).getName()+" - is the default rule\n"
                        +event.getGuild().getTextChannelById(messageChannelID).getName()+" - if the root text channel\n").queue();
            }
            catch (Exception ex){
                event.getChannel().sendMessage("incorrect role id").queue();
            }
        }
    }
}
