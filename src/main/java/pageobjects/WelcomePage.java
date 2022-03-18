package pageobjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomePage extends Form {

    private IButton btnHere = getElementFactory().getButton(By.cssSelector(".start__link"), "HERE");

    public WelcomePage() {
        super(By.xpath("//a[normalize-space()='HERE']"), "HERE");
    }

    public void clickNext() {
        btnHere.click();
    }

}
