package com.nat.jenkins.qa.page;

import com.nat.jenkins.qa.annotation.QAComponent;
import com.nat.jenkins.qa.element.CheckboxElement;
import com.nat.jenkins.qa.element.TextElement;
import org.openqa.selenium.By;

@QAComponent
public class ConfigurationPage extends AbstractPage {
    private By nameTextField = By.name("name");
    private By descriptionTextArea = By.name("description");
    private By discardOldBuildsCheckBoxElement = By.name("specified");

    public TextElement getNameTextField() {
        return factory.getElement(TextElement.class, nameTextField);
    }

    public TextElement getDescriptionTextArea() {
        return factory.getElement(TextElement.class, descriptionTextArea);
    }

    public CheckboxElement getDiscardOldBuildsCheckBoxElement() {
        return factory.getElement(CheckboxElement.class, discardOldBuildsCheckBoxElement);
    }

}
