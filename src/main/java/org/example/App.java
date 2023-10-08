package org.example;

import org.example.httprequests.HttpImageStatusCli;


public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        HttpImageStatusCli imageStatusCli = new HttpImageStatusCli();
        imageStatusCli.askStatus();

    }
}
