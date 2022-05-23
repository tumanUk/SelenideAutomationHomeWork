import Pages.AuthorizationPage;
import Pages.BasePage;
import Pages.HomePage;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.exactText;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AuthorizationTest {
    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage();
    AuthorizationPage authorizationPage = new AuthorizationPage();

    Logger logger = LoggerFactory.getLogger(AuthorizationTest.class);


    @Parameters({"browserName"})
    @BeforeMethod
    public void setBrowser(String browserName) {
        Configuration.browser = browserName;
    }

    @Test
    public void authorizeTest() {
        logger.info("do authorization");
        homePage.openHomePage();
        basePage.clickSignInButton();
        authorizationPage.doAuthorize("skillupdemo@gmail.com", "12345");
        basePage.getAuthorizedAccount().shouldHave(exactText("name lasr"));
    }

}
