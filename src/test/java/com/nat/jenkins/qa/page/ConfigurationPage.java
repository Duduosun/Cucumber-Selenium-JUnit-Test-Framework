package com.nat.jenkins.qa.page;

import com.nat.jenkins.qa.annotation.QAComponent;
import com.nat.jenkins.qa.element.CheckboxElement;
import com.nat.jenkins.qa.element.TextElement;

@QAComponent
public class ConfigurationPage extends AbstractPage {

    public TextElement getNameTextField() {
        return factory.getElement(TextElement.class, getBy(BY_NAME, "configurationPage.nameTextField"));
    }

    public TextElement getDescriptionTextArea() {
        return factory.getElement(TextElement.class, getBy(BY_NAME, "configurationPage.descriptionTextArea"));
    }

    public CheckboxElement getDiscardOldBuildsCheckBoxElement() {
        return factory.getElement(CheckboxElement.class, getBy(BY_NAME, "configurationPage.discardOldBuildsCheckBoxElement"));
    }

}
