package core;

import commands.CommandControl;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import settings.CONSTS;
/*
*
*
*
*  BOT ID IS 710743646697422978
*
*
*
*/
public class Bot extends ListenerAdapter {
    private static First_Init first_init;
    public static Languages languages;
    public int current=0;
    static {
        languages=Languages.ENGLISH;
        first_init= new First_Init();
    }
    public static void main(String[] args) throws Exception {
        JDA jda = new JDABuilder(CONSTS.token).addEventListeners(new Bot()).setActivity(Activity.playing("Type &help")).build();
       // System.out.println(jda.getInviteUrl(Permission.getFromOffset(8)));
        jda.addEventListener();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        //make if log file is empty (write in docs command &start)^^
        //&start (set member rule,create new text channel and write this id and write there in file) 1set member rule 2enable mute members(true false) 3how min mute for bad words 3
        //made sure that thi is the current channel else cancel first initialization
        //MuteMain mn= new MuteMain();

        //event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("710993484986974239")).queue();

        if(event.getAuthor().isBot())return;
      //  mn.Check(event.getMessage().getContentRaw());
        if(event.getMessage().getContentRaw().startsWith(CONSTS.prefix)){
            new CommandControl(event);
        }
        else if (!first_init.isInitialized()&&first_init.isStart()) {
            first_init.Initialize(event);
        }
    }
}
