package org.example;

import data.types.UserFactory;
import data.types.UserType;
import gui.ListActionListener;
import gui.ListActionListenerImpl;
import gui.UI;

public class Main {
    public static void main(String[] args) {
        UserType t = UserFactory.getBuilderByName("Point");
        ListActionListener listActionListener = new ListActionListenerImpl();
        new UI(listActionListener);
    }
}