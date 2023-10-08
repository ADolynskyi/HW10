package org.example.httprequests;


import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    HttpStatusChecker statusChecker = new HttpStatusChecker();


    public void downLoadStatusImage(int code) {

        Path outputPath = Paths.get("HTTP/Cat_" + code + ".jpg");
        if (Files.exists(outputPath)) {
            try {
                Files.delete(outputPath);
            } catch (IOException e) {
                System.err.println("Failed to delete the file: " + e.getMessage());
            }
        }
        try {
            URL url = new URL(statusChecker.getStatusImage(code));
            try (InputStream inputStream = url.openStream()) {
                Files.copy(inputStream, outputPath);
                System.out.println("Downloaded successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
