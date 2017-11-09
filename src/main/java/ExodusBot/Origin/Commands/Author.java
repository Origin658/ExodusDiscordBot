package ExodusBot.Origin.Commands;

import ExodusBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static ExodusBot.Origin.Other.Global_Variables.COMMAND_PREFIX;


/**
 * Created by josep on 29/07/2017.
 */
public class Author extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContent();

        if (message.equalsIgnoreCase(COMMAND_PREFIX + "author") && !(e.getAuthor().isBot())) {
            e.getTextChannel().sendMessage("```" +
                    "Developed by Origin#9142" +
                    "\nSource Code - https://github.com/Origin658/ExodusDiscordBot" +
                    "```").queue();



            try {Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}
        }

    }
}
