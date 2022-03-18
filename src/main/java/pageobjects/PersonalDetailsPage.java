package pageobjects;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsPage extends Form {
    public PersonalDetailsPage() {
        super(By.cssSelector(".personal-details__form"), "Personal details");
    }
}
