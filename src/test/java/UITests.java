import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import helpers.ConstantUtils;
import helpers.DataGenerator;
import helpers.RobotUtils;
import helpers.TestingConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.PersonalDetailsPage;
import pageobjects.RegistrationCardPage;
import pageobjects.InterestsPage;
import pageobjects.WelcomePage;

public class UITests extends BaseTest {

    private final WelcomePage welcomePage = new WelcomePage();
    private final RegistrationCardPage registrationCardPage = new RegistrationCardPage();
    private final InterestsPage interestsPage = new InterestsPage();
    private final PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
    public Browser browser;
    public String testUrl = TestingConfiguration.getStartUrl();

    @Test
    public void firstCase() {
        browser = AqualityServices.getBrowser();
        browser.goTo(testUrl);
        Assert.assertTrue(welcomePage.state().isDisplayed(), "Sorry, the WelcomePage is unreachable!");
        welcomePage.clickNext();
        Assert.assertTrue(registrationCardPage.state().isDisplayed(), "Sorry, the RegistrationPage is unreachable!");
        registrationCardPage.fillPasswordField(ConstantUtils.RANGE_OF_PASSWORD);
        registrationCardPage.fillEmailField();
        registrationCardPage.fillDomainNameField(ConstantUtils.RANGE_OF_DOMAIN_NAME);
        registrationCardPage.getDropDownDomain();
        registrationCardPage.selectRequiredComboBox(DataGenerator.selectRandomFromRange(ConstantUtils.LOWER_BOUND_OF_COMBO_BOXES, ConstantUtils.UPPER_BOUND_OF_COMBO_BOXES));
        registrationCardPage.checkTermsConditions();
        registrationCardPage.nextBtnClick();
        Assert.assertTrue(interestsPage.state().waitForDisplayed(), "Sorry, the InterestsPage is unreachable");
        interestsPage.setUnselectAllCheckBoxes();
        interestsPage.selectRequiredRandomCheckBox();
        interestsPage.uploadImageBtnClick();
        RobotUtils.putToClipBoard(ConstantUtils.PATH_TO_FILE_FOR_DOWNLOAD);
        RobotUtils.copyPasteByRobo();
        interestsPage.transitionToQuestionnairePage();
        Assert.assertTrue(personalDetailsPage.state().waitForDisplayed(), "Sorry, the PersonalDetailsPage is unreachable");
    }

    @Test
    public void secondCase() {
        browser = AqualityServices.getBrowser();
        browser.goTo(testUrl);
        Assert.assertTrue(welcomePage.state().isDisplayed(), "Sorry, the WelcomePage is unreachable");
        welcomePage.clickNext();
        registrationCardPage.hideForm();
        Assert.assertTrue(registrationCardPage.waitUntilHelpFormIsHidden(), "Sorry, this form is still displaying");
    }

    @Test
    public void thirdCase() {
        browser = AqualityServices.getBrowser();
        browser.goTo(testUrl);
        Assert.assertTrue(welcomePage.state().isDisplayed(), "Sorry, the WelcomePage is unreachable");
        welcomePage.clickNext();
        registrationCardPage.clickConfirmCookies();
        Assert.assertTrue(registrationCardPage.checkStateCookies(), "Sorry, this form is still displaying");
    }

    @Test
    public void fourthCase() {
        browser = AqualityServices.getBrowser();
        browser.goTo(testUrl);
        Assert.assertTrue(welcomePage.state().isDisplayed(), "Sorry, the WelcomePage is unreachable");
        welcomePage.clickNext();
        Assert.assertEquals(registrationCardPage.getInfoFromTimer(), ConstantUtils.START_VALUE_OF_TIMER);
    }

    @Test
    public void fifthCase(){
        browser = AqualityServices.getBrowser();
        browser.goTo(testUrl);
        Assert.assertTrue(welcomePage.state().isDisplayed(), "Sorry, the WelcomePage is unreachable!");
        welcomePage.clickNext();
        Assert.assertTrue(registrationCardPage.state().isDisplayed(), "Sorry, the RegistrationPage is unreachable!");
        registrationCardPage.fillPasswordFieldWithRandom(ConstantUtils.RANGE_OF_RANDOM);
        registrationCardPage.fillEmailFieldWithRandom(ConstantUtils.RANGE_OF_RANDOM);
        registrationCardPage.fillDomainFieldWithRandom(ConstantUtils.RANGE_OF_RANDOM);
        registrationCardPage.getDropDownDomain();
        registrationCardPage.selectRequiredComboBox(DataGenerator.selectRandomFromRange(ConstantUtils.LOWER_BOUND_OF_COMBO_BOXES, ConstantUtils.UPPER_BOUND_OF_COMBO_BOXES));
        registrationCardPage.checkTermsConditions();
        registrationCardPage.nextBtnClick();
    }

    @Test
    public void sixthCase(){
        browser = AqualityServices.getBrowser();
        browser.goTo(testUrl);
        Assert.assertTrue(welcomePage.state().isDisplayed(), "Sorry, the WelcomePage is unreachable!");
        welcomePage.clickNext();
        Assert.assertTrue(registrationCardPage.state().isDisplayed(), "Sorry, the RegistrationPage is unreachable!");
        registrationCardPage.writeWhatYouWantToPassword(ConstantUtils.SPECIFIC_PASSWORD_VALUE);
        registrationCardPage.writeWhatYouWantToEmail(ConstantUtils.SPECIFIC_EMAIL_VALUE);
        registrationCardPage.writeWhatYouWantToDomain(ConstantUtils.SPECIFIC_DOMAIN_VALUE);
        registrationCardPage.getDropDownDomain();
        registrationCardPage.selectRequiredComboBox(DataGenerator.selectRandomFromRange(ConstantUtils.LOWER_BOUND_OF_COMBO_BOXES, ConstantUtils.UPPER_BOUND_OF_COMBO_BOXES));
        registrationCardPage.checkTermsConditions();
        registrationCardPage.nextBtnClick();
    }

}
