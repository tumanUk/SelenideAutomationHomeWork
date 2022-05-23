package Pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class MyStorePage {
    private ElementsCollection shopItem = $$x("//div[@class='product-container']");

    private ElementsCollection getShopItems() {
        return $$(shopItem);
    }

    public ProductDetailsPage viewShopItemDetailsPage(int itemIndex) {
        ElementsCollection shopItems = getShopItems();
        shopItems.get(itemIndex).$(".product-name").click();
        return page(ProductDetailsPage.class);
    }
}