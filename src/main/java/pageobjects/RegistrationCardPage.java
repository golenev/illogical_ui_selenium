package pageobjects;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import helpers.DataGenerator;
import org.openqa.selenium.By;

import java.util.List;

public class RegistrationCardPage extends Form {

    private ITextBox passwordBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Password')]"), "Password");
    private ITextBox emailBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "email");
    private ITextBox domainBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "domain");
    private ICheckBox termsConditionsChkBx = getElementFactory().getCheckBox(By.xpath("//span[contains(@class, 'checkbox__check')]"), "terms and Conditions");
    private IButton nextBtn = getElementFactory().getButton(By.cssSelector("a[class='button--secondary']"), "next");
    private IButton openDropDown = getElementFactory().getButton(By.cssSelector(".dropdown__field"), "Dropdown field");
    private IButton hideFormBtn = getElementFactory().getButton(By.xpath("//span[@class='discrete']"), "Send to bottom");
    private IButton confirmCookiesBtn = getElementFactory().getButton(By.xpath("//button[contains(@class, 'button--transparent')]"), "Confirm cookies");
    private ITextBox timerData = getElementFactory().getTextBox(By.xpath("//div[contains(@class, 'timer--center')]"), "timer");

    public RegistrationCardPage() {
        super(By.xpath("//input[@placeholder='Choose Password']"), "Field for entering password");
    }

    public List<IComboBox> getListOfComboBoxes() {
        Logger.getInstance().info("Got the list of locators");
        return this.getElementFactory().findElements(By.className("dropdown__list-item"), ElementType.COMBOBOX, ElementsCount.MORE_THEN_ZERO, ElementState.EXISTS_IN_ANY_STATE);
    }

    public void hideForm() {
        hideFormBtn.click();
    }

    public void clickConfirmCookies() {
        confirmCookiesBtn.click();
    }

    public String getInfoFromTimer() {
        return timerData.getText();
    }

    public boolean waitUntilHelpFormIsHidden() {
        return hideFormBtn.state().waitForNotDisplayed();
    }

    public boolean checkStateCookies() {
        return confirmCookiesBtn.state().waitForNotDisplayed();
    }

    public void fillPasswordField(int count) {
        passwordBox.clearAndType(DataGenerator.createPassword(count));
    }

    public void fillEmailField() {
        emailBox.clearAndType(DataGenerator.dataForEmail());
    }

    public void fillEmailField(int count) {
        emailBox.clearAndType(DataGenerator.createString(count));
    }

    public void fillEmailFieldWithRandom (int count) {
        emailBox.clearAndType(DataGenerator.createRandomNumbersAsString(count));
    }
    public void fillPasswordFieldWithRandom (int count){

        passwordBox.clearAndType(DataGenerator.createRandomNumbersAsString(count));
    }

    public void fillDomainFieldWithRandom (int count) {
        domainBox.clearAndType(DataGenerator.createRandomNumbersAsString(count));
    }

    public void fillDomainNameField(int count) {
        domainBox.clearAndType(DataGenerator.createString(count));
    }

    public void getDropDownDomain() {
        openDropDown.click();
    }

    public void selectRequiredComboBox(int index) {
        this.getListOfComboBoxes().get(index).click();
    }

    public void checkTermsConditions() {
        termsConditionsChkBx.check();
    }

    public void nextBtnClick() {
        nextBtn.click();
    }

    public void writeWhatYouWantToPassword(String password){
        passwordBox.clearAndType(password);
            }
    public void writeWhatYouWantToEmail(String email){
        emailBox.clearAndType(email);
    }
    public void writeWhatYouWantToDomain(String domain) {
        domainBox.clearAndType(domain);
    }


}
