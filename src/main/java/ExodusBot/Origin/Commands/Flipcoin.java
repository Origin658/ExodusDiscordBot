package ExodusBot.Origin.Commands;

import ExodusBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ExodusBot.Origin.Other.Global_Variables.COMMAND_PREFIX;

/**
 * Created by josep on 11/06/2017.
 */
public class Flipcoin extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String message = e.getMessage().getContent();
        List<String> coin = new ArrayList();
        coin.add("Heads");
        coin.add("Tails");

        if (message.equalsIgnoreCase(COMMAND_PREFIX + "flipcoin") && !(e.getAuthor().isBot())) {
            Random rand = new Random();
            int random = rand.nextInt(2) + 0;
            e.getTextChannel().sendMessage( e.getAuthor().getAsMention() + " flipped " + coin.get(random)).queue();
            try {Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}

        }
    }
}