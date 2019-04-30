package bot.listener.reaction;

import org.javacord.api.entity.permission.Role;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.listener.message.reaction.ReactionAddListener;

public class ReactionAddListenerImpl implements ReactionAddListener {
    private String Y_REACT_EMOJI;
    private long messageID;
    private String roleToAward;

    /**
     * The constructor
     * @param y_REACT_EMOJI the Y emoji code or any other emoji code for the reaction
     * @param messageID the message id of the message to look for
     * @param roleToAward the NAME of the role to award (dont confuse with the role ID)
     */
    public ReactionAddListenerImpl(String y_REACT_EMOJI, long messageID, String roleToAward) {
        Y_REACT_EMOJI = y_REACT_EMOJI;
        this.messageID = messageID;
        this.roleToAward = roleToAward;
    }

    @Override
    public void onReactionAdd(ReactionAddEvent reactionAddEvent) {

        if (reactionAddEvent.getMessageId() == messageID
                && reactionAddEvent.getEmoji().equalsEmoji(Y_REACT_EMOJI)) {
            Role role = reactionAddEvent.getServer().get().getRolesByName(roleToAward).get(0);
            reactionAddEvent.getUser().addRole(role);
        }
    }
}