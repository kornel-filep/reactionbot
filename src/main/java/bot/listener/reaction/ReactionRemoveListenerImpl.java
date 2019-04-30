package bot.listener.reaction;

import org.javacord.api.entity.permission.Role;
import org.javacord.api.event.message.reaction.ReactionRemoveEvent;
import org.javacord.api.listener.message.reaction.ReactionRemoveListener;

public class ReactionRemoveListenerImpl implements ReactionRemoveListener {

    private String Y_REACT_EMOJI;
    private long messageID;
    private String roleToAward;

    /**
     * The constructor
     * @param y_REACT_EMOJI the Y emoji code or any other emoji code for the reaction
     * @param messageID the message id of the message to look for
     * @param roleToAward the NAME of the role to remove (dont confuse with the role ID)
     */
    public ReactionRemoveListenerImpl(String y_REACT_EMOJI, long messageID, String roleToAward) {
        Y_REACT_EMOJI = y_REACT_EMOJI;
        this.messageID = messageID;
        this.roleToAward = roleToAward;
    }

    @Override
    public void onReactionRemove(ReactionRemoveEvent reactionRemoveEvent) {
        if (reactionRemoveEvent.getMessageId() == messageID
                && reactionRemoveEvent.getEmoji().equalsEmoji(Y_REACT_EMOJI)) {
            Role role = reactionRemoveEvent.getServer().get().getRolesByName(roleToAward).get(0);
            reactionRemoveEvent.getUser().removeRole(role);
        }
    }

}
