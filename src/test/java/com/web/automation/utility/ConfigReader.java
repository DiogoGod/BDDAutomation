package com.web.automation.utility;

import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String readProjectConfiguration(String keyName) throws IOException {
        try {
            String value = null;
            FileReader file = new FileReader(new File("ConfigFiles/ProjectConfiguration.properties"));
            Properties readproperty = new Properties();
            readproperty.load(file);
            return readproperty.getProperty(keyName).trim();
        }catch(Exception exception){
            exception.printStackTrace();
            throw(new RuntimeException("****ERROR****: - Key with name"+ keyName +"does not exist"));
        }
    }
    public static String readElementLocators(String keyName) throws IOException {
        try {
            String value = null;
            FileReader file = new FileReader(new File("ElementLocators/Locators.properties"));
            Properties readproperty = new Properties();
            readproperty.load(file);
            return readproperty.getProperty(keyName).trim();
        }catch(Exception exception){
            exception.printStackTrace();
            throw(new RuntimeException("****ERROR****: - Key with name"+ keyName +"does not exist"));
        }
    }
}
