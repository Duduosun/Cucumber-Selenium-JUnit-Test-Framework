package com.nat.jenkins.qa;

import com.nat.jenkins.qa.element.MenuElement;
import com.nat.jenkins.qa.element.PageElementFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Navigation {
    @Autowired
    private PageElementFactory factory;
    @Autowired
    private WebDriver driver;
    @Value("${applicationURL}")
    private String applicationURL;

    public void clickMenuItem(String item) {
        ((MenuElement) factory.getElement(MenuElement.class, null)).clickMenuItem(item);
    }

    public void clickOkButton() {
        driver.findElement(By.id("ok-button")).click();
    }

    public void clickSaveButton() {
        driver.findElement(By.id("yui-gen2-button")).click();
    }

    public void openHomePage() {
        driver.get(applicationURL);
    }
}
