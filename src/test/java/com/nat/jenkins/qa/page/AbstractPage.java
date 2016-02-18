package com.nat.jenkins.qa.page;

import com.nat.jenkins.qa.Navigation;
import com.nat.jenkins.qa.PropertiesManager;
import com.nat.jenkins.qa.element.PageElementFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPage {
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected PageElementFactory factory;
    @Autowired
    protected Navigation navigation;
    @Autowired
    protected PropertiesManager propertiesManager;

    public static final int BY_CLASS_NAME = 0;
    public static final int BY_CSS_SELECTOR = 1;
    public static final int BY_ID = 2;
    public static final int BY_LINK_TEXT = 3;
    public static final int BY_NAME = 4;
    public static final int BY_PARTIAL_LINK_TEXT = 5;
    public static final int BY_TAG_NAME = 6;
    public static final int BY_XPATH = 7;

    public Navigation getNavigation() {
        return navigation;
    }

    protected By getBy(int type, String name) {
        By result;
        switch (type) {
            case BY_CLASS_NAME:
                result = By.className(propertiesManager.get(name));
                break;
            case BY_CSS_SELECTOR:
                result = By.cssSelector(propertiesManager.get(name));
                break;
            case BY_ID:
                result = By.id(propertiesManager.get(name));
                break;
            case BY_LINK_TEXT:
                result = By.linkText(propertiesManager.get(name));
                break;
            case BY_NAME:
                result = By.name(propertiesManager.get(name));
                break;
            case BY_PARTIAL_LINK_TEXT:
                result = By.partialLinkText(propertiesManager.get(name));
                break;
            case BY_TAG_NAME:
                result = By.tagName(propertiesManager.get(name));
                break;
            case BY_XPATH:
                result = By.xpath(propertiesManager.get(name));
                break;
            default:
                throw new IllegalArgumentException("By type " + type + " is not found.");
        }
        return result;
    }
}
