package com.nat.jenkins.qa.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuElement extends PageElement {
    private By menu = By.id("tasks");
    private WebElement wrapper;

    public MenuElement(WebDriver driver) {
        super(driver);
        wrapper = driver.findElement(menu);
    }

    /**
     * Click the specified menu item.
     *
     * @param itemName - text of the item
     */
    public void clickMenuItem(String itemName) {
        wrapper.findElement(By.xpath("//*[text()='" + itemName + "']")).click();
    }
}
