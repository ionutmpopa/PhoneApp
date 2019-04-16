package com.iopo;

public class MessageHistory {

    private String phoneNumber;
    private String messageContent;

    public MessageHistory(String phoneNumber, String messageContent) {

        this.phoneNumber = phoneNumber;
        this.messageContent = messageContent;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
