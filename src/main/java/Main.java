import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {

        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "NDM1NzkwMTAwMzM3NjU1ODA4.DbeEsA.bvn3ZmwGmK8nnQvmpRWxo-0COB0";
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.buildAsync();

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("We received a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay()
        );

        if (event.getAuthor().isBot()) {
            return;
        }

        //using raw so we have the content exactly as the user sent it
        if(event.getMessage().getContentRaw().equals("!ping")) {
            //remember to call queue
            //otherwise our message will never be sent
            event.getChannel().sendMessage("Pong!").queue();
        }

        if(event.getMessage().getContentRaw().equalsIgnoreCase("paul is")) {
            event.getChannel().sendMessage("Awesome!").queue();
        }

        if(event.getMessage().getContentRaw().equals("!gitinfo")) {
            event.getChannel().sendMessage("https://github.com/Setak/ProjectOasis.git").queue();
        }
    }
}