package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        boolean quit = false;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice:");
            int count = scanner.nextInt();
            scanner.nextLine();

            switch (count) {
                case 0 -> printInstructions();
                case 1 -> mobilePhone.printContacts();
                case 2 -> addContact();
                case 3 -> updateContact();
                case 4 -> removeContact();
                case 5 -> findContact();
                case 6 -> quit = true;
            }
        }

    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice option");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a contact to the list.");
        System.out.println("\t 3 - To modify a contact in the list.");
        System.out.println("\t 4 - To remove a contact from the list.");
        System.out.println("\t 5 - To search for a contact in the list.");
        System.out.println("\t 6 - To quit th application.");

    }

    public static void addContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        if (mobilePhone.doesContactExist(name)) {
            System.out.println("Contact already exists");
        } else {
            System.out.println("Enter contact phone number: ");
            int phoneNr = scanner.nextInt();

            mobilePhone.storeContact(name, phoneNr);
            System.out.println("Contact successfully added!");
        }
    }

    public static void updateContact() {

        System.out.println("Enter the name of contact you want to update: ");
        String name = scanner.nextLine();
        if (!mobilePhone.doesContactExist(name)) {
            System.out.println("Contact doesn't exist in the contact list");
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Do you want to modify the phone number? ");
        String modifyPhNr = scanner.nextLine();
        switch (modifyPhNr) {
            case "yes":
                System.out.println("Enter new  contact phone number: ");
                int newPhoneNr = scanner.nextInt();

                mobilePhone.modifyContact(name, newName, newPhoneNr);
                break;
            case "no":
                mobilePhone.modifyContact(name, newName, mobilePhone.getMobilePhone().get(mobilePhone.getContactPosition(name)).getPhoneNr());

        }

    }

    public static void removeContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        mobilePhone.removeContact(name);
    }

    public static void findContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        if (mobilePhone.doesContactExist(name)) {
            System.out.println("Found contact!");
        } else {
            System.out.println("Contact doesn't exist in the contact list");
        }
    }
}
