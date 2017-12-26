package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by plexinvise on 12/23/17.
 */
public class WebDriverWorker {
    WebDriver driver;
    List<WebElement> title;
    List<WebElement> description;
    Map<String, String> ingredients = new HashMap();

    public WebDriverWorker() {
        driver = new SafariDriver();
        driver.get("file:///"+System.getProperty("user.dir")+"/src/com/company/TestPage.html");
        title = driver.findElements(By.className("title ng-binding"));
        description = driver.findElements(By.className("description ng-binding"));

        for (int i = 0; i < title.size(); i++) {
            ingredients.put(title.get(i).getText(), description.get(i).getText());
        }


    }

    public String show3rdand5th () {
        if (title.size()>=5) {
            return ("3rd element " + title.get(2).getText() + "\n5th element: " + title.get(4).getText());
        }
        return "Not enough values found";
    }

    public StringBuilder allValues () {
        StringBuilder builder = new StringBuilder();
        for (String key : ingredients.keySet()) {
            builder.append(key + ": " + ingredients.get(key) + "\n");
        }
        return builder;
    }

}

