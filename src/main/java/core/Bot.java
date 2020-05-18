package core;

import com.sun.deploy.security.ruleset.Rule;
import com.sun.deploy.security.ruleset.RuleAction;
import com.sun.deploy.security.ruleset.RuleId;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

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
    public static void main(String[] args) throws Exception {
        JDA jda = new JDABuilder("NzEwNzQzNjQ2Njk3NDIyOTc4.Xr8hCA.DZ82AkPsqFsnnMp9JYEgh7itKh8").addEventListeners(new Bot()).setActivity(Activity.playing("Type &help")).build();
        jda.addEventListener();

        //make by reading file
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        //make if log file is empty (write in docs command &start)
        //&start (set member rule,create new text channel and write this id and write there in file) 1set member rule 2enable mute members(true false) 3how min mute for bad words 3
        //made sure that thi is the current channel else cancel first initialization

        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("710993484986974239")).queue();

        MessageChannel ch=event.getChannel();
        TextChannel tc= event.getTextChannel();
        System.out.println(event.getMember()+"||"+event.getAuthor());
        String message = event.getMessage().getContentRaw().toLowerCase();
        if (message.equals("&start"));
    }
}
