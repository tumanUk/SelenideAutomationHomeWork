package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductDetailsPage {
    private SelenideElement wishLabel = $x("//*[@id='wishlist_button']");
    private SelenideElement wishPopUp = $x("//*[@class='fancybox-error']");
    private SelenideElement closeButton = $x("//*[@class='fancybox-item fancybox-close']");
    private SelenideElement shopItem = $x("//*[contains(@src,'img/p/1/2/12-home_default')]");


    public void checkWishLabel() {
        $(wishLabel).shouldBe(visible);
    }

    public void addShopItemToWishList() {
        $(wishLabel).click();
    }

    public SelenideElement viewWishPopUp() {
        return $(wishPopUp);
    }

    public void closeWihPopUp() {
        $(closeButton).click();
    }

    public SelenideElement checkShopItem() {
        return $(shopItem);
    }

}