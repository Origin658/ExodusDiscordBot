package ExodusBot.Origin.Commands;

import ExodusBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static ExodusBot.Origin.Other.Global_Variables.COMMAND_PREFIX;


/**
 * Created by josep on 10/06/2017.
 */
public class Vote extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContent();

        if (message.equalsIgnoreCase(COMMAND_PREFIX + "vote") && !(e.getAuthor().isBot())) {
            e.getTextChannel().sendMessage("```We appreciate all the votes we can get, it really has a huge impact on the server!" +
                    "\n-----------" +
                    "\nMinecraft MP: http://minecraft-mp.com/server/179254/vote/" +
                    "\nMinecraftServers: http://minecraftservers.org/server/467508" +
                    "\n-----------```"  ).queue();




            try {Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}
        }



    }


}
