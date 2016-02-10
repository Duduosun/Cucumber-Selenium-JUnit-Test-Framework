package com.nat.jenkins.qa.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageElementFactory {

    @Autowired
    private WebDriver driver;

    public <T extends PageElement> T getElement(Class<T> pageElementType, By by) {
        if (TextElement.class.isAssignableFrom(pageElementType)) {
            return pageElementType.cast(getTextElement(by));
        } else if (MenuElement.class.isAssignableFrom(pageElementType)) {
            return pageElementType.cast(getMenuElement(null));
        } else if (RadioElement.class.isAssignableFrom(pageElementType)) {
            return pageElementType.cast(getRadioElement(by));
        } else if (TextAreaElement.class.isAssignableFrom(pageElementType)) {
            return pageElementType.cast(getTextAreaElement(by));
        } else if (CheckboxElement.class.isAssignableFrom(pageElementType)) {
            return pageElementType.cast(getCheckboxElement(by));
        } else {
            return pageElementType.cast(new PageElement(driver, by));
        }
    }

    private Object getCheckboxElement(By by) {
        return new CheckboxElement(driver, by);
    }

    private Object getTextAreaElement(By by) {
        return new TextAreaElement(driver, by);
    }

    private Object getRadioElement(By by) {
        return new RadioElement(driver, by);
    }

    private Object getMenuElement(By by) {
        return new MenuElement(driver);
    }

    private Object getTextElement(By by) {
        return new TextElement(driver, by);
    }


}
