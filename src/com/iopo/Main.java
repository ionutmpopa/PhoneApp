package com.iopo;

import java.util.logging.Logger;

public class Main {

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        instantiateSamsungGalaxy6();
        System.out.println("###############################");
        instantiateSamsungGalaxyNote9();
        System.out.println("###############################");
        instantiateHuaweiP9Lite();
        System.out.println("###############################");
        instantiateHuaweiP20();
    }

    public static void instantiateSamsungGalaxy6() {

        Phone phone = new SamsungGalaxy6("Black", "Plastic", "12345678977");
        phone.addContacts("1", "George", "Stamate", "0756-454-333");
        phone.addContacts("2", "Claudiu", "Grenea", "0754-441-324");
        phone.addContacts("2", "Claudiu", "Grenea", "0754-441-324");
        phone.listContacts();
        phone.removeContact("George Stamate");
        phone.removeContact("George Cretu");
        phone.listContacts();

        LOGGER.info("writing to log!");

        // send a message to the first contact from the previous listed
        // max number of characters - 100
        phone.sendMessage("0723-121-661", "Ce faci?");
        phone.sendMessage("0756-454-333", "Ai primit mesajul anterior?");
        phone.listMessages("0723-121-661");
        phone.listMessages("0756-454-333");
        phone.listMessages("0756-454-332");
        // send a message to the second contact from the previous listed
        phone.call("0756-454-333");
        phone.call("0754-441-324");
        phone.call("0754-441-320");
        phone.viewHistory();
    }

    public static void instantiateSamsungGalaxyNote9() {

        Phone phone = new SamsungGalaxyNote9("White", "Plastic", "32343442634343");
        phone.addContacts("1", "Stan", "SiBran", "112-211-133");
        phone.addContacts("2", "Mihai", "Eminescu", "232-332-154");
        phone.listContacts();
        phone.sendMessage("112-211-133", "Ce faci?");
        phone.sendMessage("0756-454-333", "Ai primit mesajul anterior?");
        phone.sendMessage("0756-454-333", "Nu?");
        phone.sendMessage("232-332-154", "Ai primit mesajul anterior?");
        phone.listMessages("0756-454-333");
        phone.call("112-211-133");
        phone.call("0756-454-333");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("112-211-133");
        phone.call("112-211-133");
        phone.sendMessage("112-211-133", "Ce faci?");
        phone.sendMessage("112-211-132", "Ce, faci?");
        phone.viewHistory();
        phone.listMessages("112-211-133");
        phone.listMessages("112-211-132");
        phone.listMessages("112-211-131");
    }

    public static void instantiateHuaweiP9Lite(){

        Phone phone = new HuaweiP9Lite("Golden", "Aluminium", "132455554556");
        phone.addContacts("1", "John", "Doe", "111-222-333");
        phone.addContacts("1", "John", "Doe", "111-222-333");
        phone.listContacts();
        phone.sendMessage("111-222-333", "Cum te cheama?");
        phone.listMessages("111-222-333");
        phone.listMessages("111-000-333");
        phone.call("111-222-333");
        phone.viewHistory();
    }

    public static void instantiateHuaweiP20() {
        Phone phone = new HuaweiP20("White", "Plastic", "1212323243456");
        phone.addContacts("1", "Stan", "SiBran", "112-211-133");
        phone.addContacts("2", "Mihai", "Eminescu", "232-332-154");
        phone.listContacts();
        //phone.sendMessage("112-211-133", "Ce faci?");
        phone.sendMessage("0756-454-333", "Ai primit mesajul anterior?");
        phone.sendMessage("0756-454-333", "Nu?");
        phone.sendMessage("232-332-154", "Ai primit mesajul anterior?");
        phone.listMessages("0756-454-333");
        phone.call("112-211-133");
        phone.call("0756-454-333");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("232-332-154");
        phone.call("112-211-133");
        phone.call("112-211-133");
        phone.sendMessage("112-211-133", "Ce faci?");
        phone.sendMessage("112-211-132", "Ce, faci?");
        phone.sendMessage("112-211-132", "Ce, faci?");
        phone.sendMessage("112-211-132", "Ce, faci?");
        phone.sendMessage("112-211-132", "Ce, faci?");
        phone.sendMessage("112-211-133", "Ce faci?");
        phone.viewHistory();
        phone.listMessages("112-211-133");
        phone.listMessages("112-211-132");
        phone.listMessages("112-211-134");
    }
}
