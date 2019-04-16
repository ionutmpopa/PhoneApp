package com.iopo;

import java.util.LinkedList;
import java.util.List;

public abstract class Huawei implements Phone {

    private static final int MESSAGE_LENGTH = 500;

    private double batteryLife;
    private String color;
    private String material;
    private final String imei;
    private List<Contact> contactListP20;
    private List<String> callHistoryP20;
    private List<MessageHistory> messageHistory;
    private double remainingBattery;


    public Huawei(String color, String material, String imei, double batteryLife) {
        this.color = color;
        this.material = material;
        this.imei = imei;
        this.batteryLife = batteryLife;
        this.remainingBattery = batteryLife;
        this.contactListP20 = new LinkedList<>();
        this.callHistoryP20 = new LinkedList<>();
        this.messageHistory = new LinkedList<>();
    }

    public double getRemainingBattery() {
        return remainingBattery;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public String getColor() {

        return color;
    }

    public String getMaterial() {
        return material;
    }

    public boolean addContacts(String indexPos, String firstName, String lastName, String phoneNumber) {

        try {
            Contact contact = new Contact(indexPos, firstName, lastName, phoneNumber);
            checkDuplicateContact(contact);
            contactListP20.add(contact);
            return true;
        } catch (DuplicateContactException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void listContacts() {

        System.out.println("You have " + contactListP20.size() + " contacts in your contact list");
        for(int i=0; i< contactListP20.size(); i++) {
            System.out.println( contactListP20.get(i).getIndexPos() + ". " + contactListP20.get(i).toString() + " -> "
                    + contactListP20.get(i).getPhoneNumber());
        }
    }

    public void removeContact (String item) {

        int position = findContact(item);
        if (position >= 0) {
            removeContact(position);
            System.out.println("The position " + (position+1) + " has been removed!");
        } else {
            System.out.println("This person is not in your contact list!");
        }
    }

    private void removeContact(int position) {
        contactListP20.remove(position);
    }

    private int findContact (String contactName) {

        for (int i = 0; i < contactListP20.size(); i++) {
            Contact contact = contactListP20.get(i);
            if (contact.toString().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    private String findContactPhone (String phoneNumber) {

        for (int i = 0; i < contactListP20.size(); i++) {
            Contact contact = contactListP20.get(i);
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact.toString();
            }
        }
        return null;
    }

    public void sendMessage(String phoneNumber, String messageContent) {

        String phoneList = findContactPhone(phoneNumber);
        if (messageContent.length() <= MESSAGE_LENGTH) {
            if (phoneList != null) {
                System.out.println("Sending the message to " + phoneList);
                if (this.remainingBattery > 0) {
                    this.remainingBattery = this.remainingBattery - 1;
                } else {
                    this.remainingBattery = 0;
                    System.out.println("The battery is empty, consider charging your phone!");
                }
                System.out.println("Remaining battery: " + this.getRemainingBattery());
            } else {
                System.out.println("Sending the message to " + phoneNumber);
                if (this.remainingBattery > 0) {
                    this.remainingBattery = this.remainingBattery - 1;
                } else {
                    this.remainingBattery = 0;
                    System.out.println("The battery is empty, consider charging your phone!");
                }
                System.out.println("Remaining battery: " + this.getRemainingBattery());
            }
        } else {
            System.out.println("The message is too long, it could not be sent!");
        }
        messageHistory.add(new MessageHistory(phoneNumber, messageContent));
    }

    public void listMessages(String phoneNumber) {

        int position = findPhoneNumberInMessages(phoneNumber);
        if (position < 0) {
            System.out.println("No messages for " + phoneNumber);
        }
        for (int i = 0; i < messageHistory.size(); i++) {
            if (messageHistory.get(i).getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Message sent to: " + messageHistory.get(i).getPhoneNumber() + " -> " + messageHistory.get(i).getMessageContent());
            }
        }
    }

    private int findPhoneNumberInMessages (String phoneNumber) {

        for (int i = 0; i < messageHistory.size(); i++) {
            MessageHistory messages = messageHistory.get(i);
            if (messages.getPhoneNumber().equals(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }

    private void checkDuplicateContact (Contact contact) {

        if (contactListP20.contains(contact)) {
            throw new DuplicateContactException("The phone number is already in the list!");
        }
    }

    public void call(String phoneNumber) {

        String phoneInList = findContactPhone(phoneNumber);
        if (phoneInList != null) {
            System.out.println("Calling..." + phoneInList);
            if (this.remainingBattery > 1) {
                this.remainingBattery = this.remainingBattery - 2;
                callHistoryP20.add(phoneNumber);
            } else {
                this.remainingBattery = 0;
                System.out.println("The battery is empty, consider charging your phone!");
            }
            System.out.println("Remaining battery: " + this.getRemainingBattery());
        } else {
            System.out.println("Calling..." + phoneNumber);
            if (this.remainingBattery > 1) {
                this.remainingBattery = this.remainingBattery - 2;
                callHistoryP20.add(phoneNumber);
            } else {
                this.remainingBattery = 0;
                System.out.println("The battery is empty, consider charging your phone!");
            }
            System.out.println("Remaining battery: " + this.getRemainingBattery());
        }
    }

    public void viewHistory() {

        System.out.println("The following numbers have been called:");
        for (String myModel : callHistoryP20) {
            String contactName = findContactPhone(myModel);
            if (contactName != null) {
                System.out.println(contactName + ": " + myModel);
            } else {
                System.out.println("No name: " + " " + myModel);
            }
        }
    }
}
