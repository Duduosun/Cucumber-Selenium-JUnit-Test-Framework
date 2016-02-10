package com.nat.jenkins.qa.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageElement {

    protected WebDriver driver;
    protected By by;
    protected WebElement element;

    public PageElement(WebDriver driver) {
        this.driver = driver;
    }

    public PageElement(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
        element = driver.findElement(by);
    }

    /**
     * Returns the text of this element.
     *
     * @return
     */
    public String getText() {
        return element.getText();
    }

    /**
     * Clicks this element.
     */
    public void click() {
        element.click();
    }


    /**
     * Returns if this element is visible or not.
     *
     * @return
     */
    public boolean isVisible() {
        return element.isDisplayed();
    }


    /**
     * Returns if element can be found by the specified locator in the container
     *
     * @param container
     * @param locator
     * @return
     */
    public boolean isElementPresents(WebElement container, By locator) {
        return container.findElements(locator).size() > 0;
    }


    /**
     * Returns the value for the specified attribute.
     *
     * @param attributeName
     * @return
     */
    public String getAttribute(String attributeName) {
        return element.getAttribute(attributeName);
    }

    /**
     * Returns the native web element for this page element.
     *
     * @return
     */
    public WebElement getWebElement() {
        return this.element;
    }
}
