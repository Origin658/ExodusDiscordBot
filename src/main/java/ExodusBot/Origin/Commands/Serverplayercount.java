package ExodusBot.Origin.Commands;

import ExodusBot.Origin.Other.Logging;
import ExodusBot.Origin.Other.Global_Variables;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by josep on 12/06/2017.
 */
public class Serverplayercount extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String message = e.getMessage().getContent();

        if (message.equalsIgnoreCase(Global_Variables.COMMAND_PREFIX + "playercount") && !(e.getAuthor().isBot())) {

            try {
                Socket sock = new Socket("exodusnetwork.anvil.pw", 25565);

                DataOutputStream out = new DataOutputStream(sock.getOutputStream());
                DataInputStream in = new DataInputStream(sock.getInputStream());

                out.write(0xFE);

                int b;
                StringBuffer str = new StringBuffer();
                while ((b = in.read()) != -1) {
                   if (b > 1) {
                        str.append((char) b);
                  //      System.out.println((char)b);
                   }
                }

                String[] data = str.toString().split("§");

                //System.out.println(str);


                int onlinePlayers = Integer.parseInt(data[1]);
                int maxPlayers = Integer.parseInt(data[2]);

                e.getTextChannel().sendMessage(e.getAuthor().getAsMention() + " There are currently " +
                        onlinePlayers + "/" + maxPlayers +  " players online on the Minecraft Server!").queue();
                try {
                    Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}


            } catch (UnknownHostException ev) {
               ev.printStackTrace();
            } catch (IOException ev) {
                e.getTextChannel().sendMessage(e.getAuthor().getAsMention() + " The server is currently down or restarting, please try again later.").queue();
            }
        }
    }
}