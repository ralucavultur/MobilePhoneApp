package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> MobilePhone = new ArrayList<>();
//store,
// modify-am nevoie de pozitie,
// find-sa returneze pozitia pe baza contactului,sa fie private
    //findContact- sa returneze contact pe baza unui String, private
// doesContactExist-sa returneze boolean
// remove-am nevoie de pozitie,
// query-sa verifice daca exista contactul cu numele respectiv si sa printeze informatiile despre el

    public void storeContact(String name, int phoneNr) {
        Contact newContact = new Contact(name, phoneNr);
        MobilePhone.add(newContact);
    }

    private Contact findContactByName(String name) {
        for (int i = 0; i < MobilePhone.size(); i++) {
            if (MobilePhone.get(i).getName().equals(name)) {
                return MobilePhone.get(i);
            }
        }
        return null;
    }

    public int getContactPosition(String name) {
        return MobilePhone.indexOf(findContactByName(name));
    }

    public boolean doesContactExist(String name) {
        return MobilePhone.contains(findContactByName(name));
    }

    public void modifyContact(String name, String newName, int newPhoneNr) {
        Contact newContact = new Contact(newName, newPhoneNr);
        MobilePhone.set(getContactPosition(name), newContact);
    }

    public void removeContact(String name){
        MobilePhone.remove(getContactPosition(name));
    }

    public void printContacts(){
        for (int i = 0; i < MobilePhone.size(); i++) {
            System.out.println((i+1)+ ". " + MobilePhone.get(i).getName());
            System.out.println("Phone number: " + MobilePhone.get(i).getPhoneNr());
        }
    }

    public ArrayList<Contact> getMobilePhone() {
        return MobilePhone;
    }
}
