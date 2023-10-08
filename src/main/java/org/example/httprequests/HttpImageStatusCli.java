package org.example.httprequests;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the status code");
        try {
            int code = scanner.nextInt();
            HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();
            imageDownloader.downLoadStatusImage(code);
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid number");
        }
    }
}
