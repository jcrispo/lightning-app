package com.dtn.app.utility;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtility {
    private String fileName;

    public FileUtility(String fileName) {
        System.out.println("File Name : " + fileName);
        this.fileName = fileName;
    }

    public String getFileAsJsonString() {
        String returnValue = "";
        System.out.println("fileName: " + this.fileName);
        try (InputStream inputStream = getClass().getResourceAsStream(this.fileName)) {
            returnValue = convertInputStreamToString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Issue with file! " + fileName);
        }
        return returnValue;
    }

    private String convertInputStreamToString(InputStream in) {
        if (in == null) System.out.println("inputstream is null");
        String returnValue = "";
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(in, writer, StandardCharsets.UTF_8);
            returnValue = writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnValue;
    }

}
