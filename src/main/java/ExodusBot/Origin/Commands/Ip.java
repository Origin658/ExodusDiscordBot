package ExodusBot.Origin.Commands;

import ExodusBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static ExodusBot.Origin.Other.Global_Variables.COMMAND_PREFIX;
import static ExodusBot.Origin.Other.Global_Variables.SERVER_IP;

/**
 * Created by josep on 10/06/2017.
 */
public class Ip extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContent();

        if (message.equalsIgnoreCase(COMMAND_PREFIX + "ip") && !(e.getAuthor().isBot())) {
            e.getTextChannel().sendMessage("```The server IP is " + SERVER_IP + "```").queue();


            try {Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}
        }



    }

}
