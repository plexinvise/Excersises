package com.company;

import org.apache.commons.io.FileUtils;
import org.apache.commons.text.StrBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by plexinvise on 12/26/17.
 */
public class DictionaryWorker {

    public boolean doesFileExist (String fileURI) {
        boolean fileExist = false;
        File file = new File(fileURI);
        if (!file.isFile()) {
            System.out.println("File " + file.getName() + " is not a file");
            return false;
        } if (!file.canRead()) {
            System.out.println("File " + file.getName() + " is not readable");
            return false;
        }
        return true;
    }

    public StringBuilder dictionaryValues (String fileURI) throws IOException {
        File file = new File(fileURI);
        StringBuilder builder = new StringBuilder();
        List <String> dictionary = new ArrayList(FileUtils.readLines(file, "UTF-8"));
        for (String raw : dictionary) {
            String[] tempString = raw.split("-");
            builder.append(tempString[0]+"\n");
            tempString = tempString[1].split(",");
            for (String string : tempString) {
                builder.append(string+"\n");
            }
        }
        return builder;
    }
}
