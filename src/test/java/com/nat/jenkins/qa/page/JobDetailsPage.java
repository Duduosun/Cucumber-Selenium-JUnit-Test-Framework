package com.nat.jenkins.qa.page;

import com.nat.jenkins.qa.annotation.QAComponent;
import com.nat.jenkins.qa.element.PageElement;
import org.openqa.selenium.By;

@QAComponent
public class JobDetailsPage extends AbstractPage {
    private By jobNamePageElement = By.xpath("//*[@id='main-panel']/h1");
    private By jobDescriptionPageElement = By.xpath("//*[@id='description']/div[1]");

    public PageElement getJobNamePageElement() {
        return factory.getElement(PageElement.class, jobNamePageElement);
    }

    public PageElement getJobDescriptionPageElement() {
        return factory.getElement(PageElement.class, jobDescriptionPageElement);
    }


}
