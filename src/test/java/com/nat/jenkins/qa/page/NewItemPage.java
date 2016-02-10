package com.nat.jenkins.qa.page;


import com.nat.jenkins.qa.annotation.QAComponent;
import com.nat.jenkins.qa.element.RadioElement;
import com.nat.jenkins.qa.element.TextElement;
import org.openqa.selenium.By;

@QAComponent
public class NewItemPage extends AbstractPage {
    private By itemNameTextField = By.id("name");
    private By itemTypeRadioButton = By.name("createItem");

    public TextElement getItemNameTextField() {
        return factory.getElement(TextElement.class, itemNameTextField);
    }

    public RadioElement getItemTypeRadioButton() {
        return factory.getElement(RadioElement.class, itemTypeRadioButton);
    }
}
