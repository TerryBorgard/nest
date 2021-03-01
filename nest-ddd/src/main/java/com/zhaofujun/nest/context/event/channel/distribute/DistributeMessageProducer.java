package com.zhaofujun.nest.context.event.channel.distribute;

import com.zhaofujun.nest.context.appservice.ServiceContextManager;
import com.zhaofujun.nest.context.event.channel.MessageProducer;
import com.zhaofujun.nest.context.event.message.MessageInfo;

public abstract class   DistributeMessageProducer implements MessageProducer {

    public void send(String messageGroup, MessageInfo messageInfo) {

        ServiceContextManager.get()
                .addMessageBacklog(messageGroup, messageInfo);
    }

    public abstract void commit(String messageGroup,String messageId, String messageInfoString);
}
