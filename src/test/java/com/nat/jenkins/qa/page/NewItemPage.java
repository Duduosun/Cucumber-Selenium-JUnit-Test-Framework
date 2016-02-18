package com.nat.jenkins.qa.page;


import com.nat.jenkins.qa.annotation.QAComponent;
import com.nat.jenkins.qa.element.RadioElement;
import com.nat.jenkins.qa.element.TextElement;

@QAComponent
public class NewItemPage extends AbstractPage {

    public TextElement getItemNameTextField() {
        return factory.getElement(TextElement.class, getBy(BY_ID, "newItemPage.itemNameTextField"));
    }

    public RadioElement getItemTypeRadioButton() {
        return factory.getElement(RadioElement.class, getBy(BY_NAME, "newItemPage.itemTypeRadioButton"));
    }
}
