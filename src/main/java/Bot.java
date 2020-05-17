import com.sun.deploy.security.ruleset.Rule;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.nio.channels.Channel;

/*
*
*
*
*  BOT ID IS 710743646697422978
*
*
*
*/
111
public class Bot extends ListenerAdapter {
    public static void main(String[] args) throws Exception {
        JDA jda = new JDABuilder("NzEwNzQzNjQ2Njk3NDIyOTc4.Xr8hCA.DZ82AkPsqFsnnMp9JYEgh7itKh8").addEventListeners(new Bot()).setActivity(Activity.playing("Type &help")).build();
        jda.addEventListener();

        //make by reading file
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        //make if log file is empty (write in docs command &start)
        //&start (set member rule,create new text channel and write this id and write there in file)
        //628227546374340630
        MessageChannel ch=event.getChannel();
        TextChannel tc= event.getTextChannel();
        System.out.println(ch);
        String message = event.getMessage().getContentRaw().toLowerCase();
        if (message.equals("&start"));
    }
}
