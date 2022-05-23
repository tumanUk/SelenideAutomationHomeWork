import Pages.*;
import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class WishListTest {
    BasePage basePage = new BasePage();
    MyStorePage myStorePage = new MyStorePage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    WishListPage wishListPage = new WishListPage();
    Logger logger = LoggerFactory.getLogger(WishListTest.class);

    private final String AUTH_URL = "http://automationpractice.com/index.php?controller=authentication&email=coursemail@gmail.com&passwd=123456789Q&back=my-account&SubmitLogin=";

    @Parameters({"browserName"})
    @BeforeMethod
    public void setBrowser(String browserName) {
        Configuration.browser = browserName;
    }

    @Test
    public void addToWishListTest() {
        open(AUTH_URL);
        basePage.navigateToSummerDresses();
        myStorePage.viewShopItemDetailsPage(0);
        logger.info("adding shop item to wish list");
        productDetailsPage.checkWishLabel();
        productDetailsPage.addShopItemToWishList();
        productDetailsPage.viewWishPopUp().shouldBe(visible);
        productDetailsPage.closeWihPopUp();
        logger.info("move to wish list page");
        basePage.openAccountPage();
        myAccountPage.openWishItems();
        wishListPage.openWishList();
        productDetailsPage.checkShopItem().shouldBe(visible);
        wishListPage.deleteItem();
        productDetailsPage.checkShopItem().shouldNot(visible);
    }
}