package ExodusBot.Origin.GuildMembers;

import ExodusBot.Origin.Other.Logging;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.GuildUnbanEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;



/**
 * Created by josep on 11/10/2017.
 */
public class GuildUnban extends ListenerAdapter {
    @Override
    public void onGuildUnban(GuildUnbanEvent e) {
        User user = e.getUser();
        Guild guild = e.getGuild();

        try {
            Logging.DataLog( e.getGuild().getName(), user.getName()
                    , "has been unbanned from the discord server!", true, guild);

        }catch (PermissionException er){}
    }
}
