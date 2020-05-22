package core;

import com.sun.deploy.security.ruleset.Rule;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class First_Init {
    //vate boolean eng;
    private static User InitUser;
    private static boolean isInitialize=false;
    private static String memberRoleID;
    private static String messageChannelID;
    private static LanguagesAdapter languagesAdapter;

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

    public static void Initialize(MessageReceivedEvent event){
        languagesAdapter=new LanguagesAdapter(Bot.languages);
         if (InitUser==null){//1
            System.out.println(InitUser);
            InitUser=event.getAuthor();
            //if (eng)
                event.getChannel().sendMessage("Ok "+InitUser.getName()+languagesAdapter.getFirstInit(0)).queue();
            //else
            //    event.getChannel().sendMessage("ок "+InitUser.getName()+" начал мою настройку,\nсейчас тебе нужно ввести id канала в который будет доступен только тебе(&f покажет полный список команд)").queue();
            return;
        }

        if(messageChannelID==null&&InitUser!=null){//2
            if (event.getAuthor()!=InitUser){
               // if(eng)
                    event.getChannel().sendMessage(languagesAdapter.getFirstInit(1)+InitUser.getName()+languagesAdapter.getFirstInit(2)).queue();
              //  else
                  //  event.getChannel().sendMessage("настройка может быть продолжена "+InitUser.getName()+"\nif you want to cancel initialization tap &stop").queue();
                return;
            }
            else {
                try {
                    event.getGuild().getTextChannelById(event.getMessage().getContentRaw());
                    messageChannelID = event.getMessage().getContentRaw();
                    event.getChannel().sendMessage(languagesAdapter.getFirstInit(3)).queue();
                    return;
                } catch (Exception e) {
                    event.getChannel().sendMessage(languagesAdapter.getFirstInit(4)).queue();
                    return;
                }
            }
        }
        if (memberRoleID==null&&messageChannelID!=null) { //3
            try {
                event.getGuild().getRoleById(event.getMessage().getContentRaw());
                memberRoleID = event.getMessage().getContentRaw();
                isInitialize = true;
                event.getChannel().sendMessage(languagesAdapter.getFirstInit(5)
                        +InitUser.getName()+languagesAdapter.getFirstInit(6)
                        +event.getGuild().getRoleById(memberRoleID).getName()+languagesAdapter.getFirstInit(7)
                        +event.getGuild().getTextChannelById(messageChannelID).getName()+languagesAdapter.getFirstInit(8)).queue();
            }
            catch (Exception ex){
                event.getChannel().sendMessage(languagesAdapter.getFirstInit(9)).queue();
            }
        }
    }
}
