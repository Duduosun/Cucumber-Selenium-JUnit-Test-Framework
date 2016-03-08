package com.nat.jenkins.qa.element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TextAreaElement extends PageElement {

    public TextAreaElement(WebDriver driver, By by) {
        super(driver, by);
    }

    /**
     * Sets text for this element.
     *
     * @param text text to enter
     */
    public void enterText(String text) {
        if (text != null) {
            this.element.clear();
            this.element.sendKeys(text);
        }
    }

    /**
     * Sends a specific key action to the element.
     */
    public void sendKey(Keys keys) {
        this.element.sendKeys(keys);
    }
}
