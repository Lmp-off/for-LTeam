package mute;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.Date;

public class Muted {
    private User user;
    private MessageChannel messageChannel;
    private Date muteDate;
    private Date unMuteDate;

    Muted(User user,MessageChannel messageChannel,Date muteDate,Date unMuteDate){
        this.user=user;
        this.messageChannel=messageChannel;
        this.muteDate=muteDate;
        this.unMuteDate=unMuteDate;
    }

    public User getUser() {
        return user;
    }

    public MessageChannel getMessageChannel() {
        return messageChannel;
    }

    public Date getMuteDate() {
        return muteDate;
    }

    public Date getUnMuteDate() {
        return unMuteDate;
    }
}
