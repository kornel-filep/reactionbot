package bot;

import bot.config.ConfigWrapper;
import bot.listener.reaction.AddNewReactionListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class App {

    public static void main(String[] args) {
        ConfigWrapper config = new ConfigWrapper("/config.json");

        DiscordApi api = new DiscordApiBuilder().setToken(config.getToken()).login().join();
        //the weird string is the Y emoji.
        api.addMessageCreateListener(new AddNewReactionListener(config.getPrefix(), "\uD83C\uDDFE"));

        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }

}
