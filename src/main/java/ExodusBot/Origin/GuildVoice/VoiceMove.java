package ExodusBot.Origin.GuildVoice;

import ExodusBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by josep on 14/06/2017.
 */
public class VoiceMove extends ListenerAdapter{
    @Override
    public void onGuildVoiceMove(GuildVoiceMoveEvent e){
        Logging.DataLog(e.getGuild().getName(),  e.getMember().getUser().getName()   , "joined " + e.getChannelJoined().getName()
            + " and left "  + e.getChannelLeft().getName());
    }
}
