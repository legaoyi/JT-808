package com.legaoyi.iov.protocol.messagebody.encoder;

import org.springframework.stereotype.Component;

import com.legaoyi.iov.protocol.downstream.messagebody.Jt808_8100_MessageBody;
import com.legaoyi.iov.protocol.exception.IllegalMessageException;
import com.legaoyi.iov.protocol.message.MessageBody;
import com.legaoyi.iov.protocol.message.encoder.MessageBodyEncoder;
import com.legaoyi.iov.protocol.util.ByteUtils;
import com.legaoyi.iov.protocol.util.MessageBuilder;

/*
 * 
 * @author <a href="mailto:shengbo.gao@gmail.com;78772895@qq.com">www.legaoyi.com</a>
 * 
 * @version 1.0.0
 * 
 * @since 2020-06-30
 */
@Component(MessageBodyEncoder.MESSAGE_BODY_ENCODER_BEAN_PREFIX + "8100" + MessageBodyEncoder.MESSAGE_BODY_ENCODER_BEAN_SUFFIX)
public class Jt808_8100_MessageBodyEncoder implements MessageBodyEncoder {

    @Override
    public byte[] encode(MessageBody message) throws IllegalMessageException {
        try {
            Jt808_8100_MessageBody messageBody = (Jt808_8100_MessageBody) message;
            MessageBuilder mb = new MessageBuilder();
            mb.addWord(messageBody.getMessageSeq());
            mb.addByte(messageBody.getResult());
            if (messageBody.getResult() == 0) {
                mb.append(ByteUtils.gbk2bytes(messageBody.getAuthCode()));
            }
            return mb.getBytes();
        } catch (Exception e) {
            throw new IllegalMessageException(e);
        }
    }
}
