package org.kiragram.ui.Stories;

import org.kiragram.messenger.MessagesController;
import org.kiragram.messenger.UserConfig;
import org.kiragram.tgnet.AbstractSerializedData;
import org.kiragram.tgnet.TLRPC;
import org.kiragram.tgnet.tl.TL_stories;

public class MessageMediaStoryFull extends TLRPC.TL_messageMediaStory {

    public static int constructor = 0xc79aee1d;

    public void readParams(AbstractSerializedData stream, boolean exception) {
        user_id = stream.readInt64(exception);
        id = stream.readInt32(exception);
        storyItem = TL_stories.StoryItem.TLdeserialize(stream, stream.readInt32(exception), exception);
        via_mention = stream.readBool(exception);
        peer = MessagesController.getInstance(UserConfig.selectedAccount).getPeer(user_id);
    }

    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(user_id);
        stream.writeInt32(id);
        storyItem.serializeToStream(stream);
        stream.writeBool(via_mention);
    }
}