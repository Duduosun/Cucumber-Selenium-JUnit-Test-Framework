package com.nat.jenkins.qa.element;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxElement extends PageElement {

    private static final Logger logger = Logger.getLogger(CheckboxElement.class);

    public CheckboxElement(WebDriver driver, By by) {
        super(driver, by);
    }

    /**
     * Deselects checkbox.
     */
    public void unCheck() {
        if (this.isChecked()) {
            this.click();
        }
        logger.debug("The " + by + " checkbox is unchecked.");
    }

    /**
     * Selects checkbox.
     */
    public void check() {
        if (!this.isChecked()) {
            this.click();
        }
        logger.debug("The " + by + " checkbox is checked.");
    }

    /**
     * Returns whether or not checkbox is selected.
     *
     * @return true if checkbox is selected.
     */
    public Boolean isChecked() {
        return element.isSelected();
    }
}
