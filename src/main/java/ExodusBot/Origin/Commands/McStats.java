package ExodusBot.Origin.Commands;

import ExodusBot.Origin.Other.Logging;
import ExodusBot.Origin.Other.URLReader;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

import static ExodusBot.Origin.Other.Global_Variables.COMMAND_PREFIX;


/**
 * Created by josep on 02/08/2017.
 */
public class McStats extends ListenerAdapter {
    public String Stats;

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContent();


        if (message.equalsIgnoreCase(COMMAND_PREFIX + "McStats") && !(e.getAuthor().isBot())) {

            try {
                Stats = URLReader.URLRead("https://status.mojang.com/check");
            } catch (Exception ev){}


            Stats = Stats.replaceAll("[{},:\\[\\]]","");


            List<String> ListStats = new ArrayList<>();

           for (String i: Stats.split("\"")){
               ListStats.add(i);
           }


           for (int i = 0; i < ListStats.size(); i ++){
                if (ListStats.get(i).equalsIgnoreCase("green")){
                    ListStats.set(i, "- :green_heart: \n");
                } else if (ListStats.get(i).equalsIgnoreCase("yellow")){
                    ListStats.set(i, "- :yellow_heart: \n");
                } else if (ListStats.get(i).equalsIgnoreCase("red")){
                    ListStats.set(i, "- :heart: \n");
                }
           }


           Stats = ListStats.toString().replaceAll("[,\\[\\]]","");

                e.getTextChannel().sendMessage("Current status of Minecraft services\n" +
                        " :green_heart: - No issues, :yellow_heart: - Some issues, :heart: - Service unavailable. \n " + Stats).queue();







            try {Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}
        }

    }
}