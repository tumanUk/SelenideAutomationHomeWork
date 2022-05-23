package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    private SelenideElement signInButton = $x("//*[@class='login']");
    private SelenideElement womenCategory = $("a[title*='Women']");
    private SelenideElement summerDressesCategory = $("a[title='Women'] + ul a[title='Summer Dresses']");
    private SelenideElement accountButton = $x("//*[@class='account']");
    public SelenideElement account = $("a.account span");

    public AuthorizationPage clickSignInButton() {
        $(signInButton).click();
        return page(AuthorizationPage.class);
    }

    public SelenideElement getAuthorizedAccount() {
        return $(account);
    }

    public MyStorePage navigateToSummerDresses() {
        actions().moveToElement(womenCategory).click(summerDressesCategory).perform();
        return page(MyStorePage.class);
    }

    public MyAccountPage openAccountPage() {
        $(accountButton).click();
        return page(MyAccountPage.class);
    }

}