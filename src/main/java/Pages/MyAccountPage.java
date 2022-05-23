package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MyAccountPage {
    public SelenideElement myWishLabel = $x("//*[@class='icon-heart']");

    public WishListPage openWishItems() {
        $(myWishLabel).click();
        return page(WishListPage.class);
    }
}