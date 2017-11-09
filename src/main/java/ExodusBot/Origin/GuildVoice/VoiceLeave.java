package ExodusBot.Origin.GuildVoice;

import ExodusBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;



/**
 * Created by josep on 13/06/2017.
 */
public class VoiceLeave extends ListenerAdapter {
    @Override
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent e){
        Logging.DataLog( e.getGuild().getName(), e.getMember().getUser().getName() , "left the channel " + e.getChannelLeft().getName());
    }
}
