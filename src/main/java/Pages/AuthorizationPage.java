package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {
    private SelenideElement emailInput = $("input#email");
    private SelenideElement passwordInput = $x("//input[@id='passwd']");
    private SelenideElement signInButton = $(By.id("SubmitLogin"));


    public MyAccountPage doAuthorize(String login, String password) {

        $(emailInput).setValue(login);
        $(passwordInput).setValue(password);
        $(signInButton).click();
        return page(MyAccountPage.class);
    }
}