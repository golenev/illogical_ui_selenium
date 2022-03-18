package pageobjects;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.*;

public class InterestsPage extends Form {
    private ICheckBox unselectAllCheckBoxes = getElementFactory().getCheckBox(By.cssSelector("label[for='interest_unselectall']"), "Unselect all checkboxes");
    private IButton nextBtn = getElementFactory().getButton(By.xpath("//button[contains(@class, 'button--stroked')]"), "NEXT");
    private IButton uploadBtn = getElementFactory().getButton(By.cssSelector(".avatar-and-interests__upload-button"), "upload");
    private Random random = new Random();

    public InterestsPage() {
        super(By.cssSelector(".avatar-and-interests__form"), "Avatar and interests form");
    }

    private List<ICheckBox> getListOfCheckBoxes() {
        return this.getElementFactory().findElements(By.className("checkbox__box"), ElementType.CHECKBOX, ElementsCount.MORE_THEN_ZERO, ElementState.EXISTS_IN_ANY_STATE);
    }

    public void setUnselectAllCheckBoxes() {
        unselectAllCheckBoxes.check();
    }

    public void selectRequiredRandomCheckBox() {
        List<ICheckBox> numbers = new ArrayList<>();
        numbers = this.getListOfCheckBoxes();
        System.out.println( numbers.size());
        numbers.remove(17);
        System.out.println(numbers.size());
        numbers.remove(19);
        System.out.println(numbers.size());
        Set<ICheckBox> sourceListAsSet = new HashSet<>();
        for (int i = 0; sourceListAsSet.size() < 3; i++) {
            sourceListAsSet.add(numbers.get(random.nextInt(this.getListOfCheckBoxes().size()-1)));
        }
        for (ICheckBox iCheckBox : sourceListAsSet) {
            iCheckBox.check();
        }
    }

    public void uploadImageBtnClick() {
        uploadBtn.click();
    }

    public void transitionToQuestionnairePage() {
        nextBtn.getMouseActions().moveMouseToElement();
        nextBtn.state().waitForClickable();
        nextBtn.click();
    }

}

