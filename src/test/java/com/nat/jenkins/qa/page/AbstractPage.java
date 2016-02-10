package com.nat.jenkins.qa.page;

import com.nat.jenkins.qa.Navigation;
import com.nat.jenkins.qa.element.PageElementFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPage {
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected PageElementFactory factory;
    @Autowired
    protected Navigation navigation;

    public Navigation getNavigation() {
        return navigation;
    }
}
