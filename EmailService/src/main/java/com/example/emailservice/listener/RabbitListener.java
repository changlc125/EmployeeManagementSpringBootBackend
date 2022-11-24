package com.example.emailservice.listener;

import com.example.emailservice.domain.Email;
import com.example.emailservice.util.SerializeUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        Email newEmail = SerializeUtil.deserialize(new String(message.getBody()));

        // sending email
        SendEmail(newEmail);
    }

    public void SendEmail(Email email){
        System.out.println("Title: " + email.getTitle());
        System.out.println("Time Sent: " + email.getTimeSent());
        System.out.println("From: " + email.getSender());
        System.out.println("To: " + email.getReceiver());
        System.out.println("Message: " + email.getBody());

        System.out.println();
    }
}
