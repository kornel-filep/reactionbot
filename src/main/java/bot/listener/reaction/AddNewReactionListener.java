package bot.listener.reaction;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class AddNewReactionListener implements MessageCreateListener {

    private String prefix;
    private String reactionId;

    public AddNewReactionListener(String prefix, String reactionId) {
        this.prefix = prefix;
        this.reactionId = reactionId;
    }

    //FIRES ON prefix + reaction + role mention message, grabs its id and sets the add and remove stuff.
    //eg: "pls reaction @SomeRole"
    //Then you can edit the message for whatever else you want to.
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().startsWith(prefix + " reaction")
                && messageCreateEvent.getMessage().getAuthor().isServerAdmin()) {
            long messageId = messageCreateEvent.getMessage().getId();
            String rolename = messageCreateEvent.getMessage().getMentionedRoles().get(0).getName();
            messageCreateEvent.getApi().addReactionAddListener(new ReactionAddListenerImpl(reactionId, messageId, rolename));
            messageCreateEvent.getApi().addReactionRemoveListener(new ReactionRemoveListenerImpl(reactionId, messageId, rolename));

        }
    }

}
