package com.nat.jenkins.qa.page;

import com.nat.jenkins.qa.annotation.QAComponent;
import com.nat.jenkins.qa.element.PageElement;

@QAComponent
public class JobDetailsPage extends AbstractPage {

    public PageElement getJobNamePageElement() {
        return factory.getElement(PageElement.class, getBy(BY_XPATH, "jobDetailsPage.jobNamePageElement"));
    }

    public PageElement getJobDescriptionPageElement() {
        return factory.getElement(PageElement.class, getBy(BY_XPATH, "jobDetailsPage.jobDescriptionPageElement"));
    }


}
