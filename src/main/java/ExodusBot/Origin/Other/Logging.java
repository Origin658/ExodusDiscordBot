package ExodusBot.Origin.Other;


import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;
import sun.rmi.runtime.Log;

import java.util.List;


/**
 * Created by josep on 10/06/2017.
 */
public class Logging {

    public static void DataLog(String guildN, String aName, String message){
        /*
        Logs to console
         */
        String log = guildN + ": " + aName + ": " + message;
        System.out.println(log);

    }

    public static void DataLog(String guildN, String aName, String message, Boolean logchat, Guild guild) throws PermissionException {
        /*
        Logs to logging channel within the server
         */
        String log = aName  + ": " + message;
        if (logchat) {

            if (!(guild.getTextChannelsByName("logs", true).isEmpty())) {
                guild.getTextChannelsByName("logs", true).get(0).sendMessage("```" + log + "```").queue();
            }
        }
    }
}