package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class WishListPage {
    private SelenideElement wishTableItem = $x("//*[@id='block-history']//child::*[contains(text(),'My wishlist')]");
    private SelenideElement deleteButton = $x("//*[@class='icon-remove-sign']");
    private SelenideElement shopItemInWishList = $x("//*[contains(@src,'img/p/1/2/12-home_default')]");


    public void openWishList() {
        $(wishTableItem).click();

    }

    public SelenideElement getAddedItem() {
        return $(shopItemInWishList);
    }

    public void deleteItem() {
        $(deleteButton).click();
    }
}