package ExodusBot.Origin.Commands;

import ExodusBot.Origin.Other.Global_Variables;
import ExodusBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by josep on 10/11/2017.
 */
public class Ducky extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String message = e.getMessage().getContent();
        if (message.equalsIgnoreCase(Global_Variables.COMMAND_PREFIX + "ducky") && !(e.getAuthor().isBot())) {
            e.getTextChannel().sendMessage(e.getAuthor().getAsMention() + ", ducky").queue();
            try {
                Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());
            } catch (PermissionException er) {
            }
        }
    }
}
