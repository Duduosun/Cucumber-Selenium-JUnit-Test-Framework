package com.nat.jenkins.qa.element;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioElement extends PageElement {
    private static final Logger logger = Logger.getLogger(CheckboxElement.class);

    public RadioElement(WebDriver driver, By by) {
        super(driver, by);
    }

    /**
     * Sets specified value for the group of radio buttons
     *
     * @param value
     */
    public void setValue(String value) {
        logger.debug("Set value " + value);
        if (value != null) {
            List<WebElement> radioButtons = element.findElements(By.xpath(".//*[@type='radio']"));
            for (WebElement radioButton : radioButtons) {
                String pathToLabel = "./..//b";
                if (isElementPresents(radioButton, By.xpath(pathToLabel))) {
                    if (radioButton.findElement(By.xpath(pathToLabel)).getText().contains(value)) {
                        radioButton.click();
                        logger.debug("RadioElement with value " + value + " is checked");
                        break;
                    }
                }
            }
        }
    }
}
