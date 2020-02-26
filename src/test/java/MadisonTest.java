import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class MadisonTest {
    WebDriver driver;

    @Before
    public void goToMadison() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://qa1.dev.evozon.com/");

    }

    @Ignore
    public void close() {
        driver.close();
        driver.quit();
    }


    @Test
    public void madisonTest() {
        String title = driver.getTitle();
        System.out.println(title);
        String goodTitle = "Madison Island";
        assertEquals(goodTitle, title);
        String url = driver.getCurrentUrl();
        String goodUrl = "http://qa1.dev.evozon.com/";
        assertEquals(goodUrl, url);
        System.out.println(url);
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        assertTrue(logo.isDisplayed());
        logo.click();
        String homePageUrl = "http://qa1.dev.evozon.com/";
        assertEquals(homePageUrl, url);
        driver.manage().window().maximize();
        driver.navigate().to("http://google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @Test
    public void accountTest() {
        WebElement accountButton = driver.findElement(By.cssSelector(".skip-account"));
        accountButton.click();
        WebElement dropDownList = driver.findElement(By.cssSelector("#header-account"));
        assertTrue(dropDownList.isDisplayed());
        String goodAccount = "ACCOUNT";
        assertEquals(goodAccount, accountButton.getText());
    }


    @Test
    public void language() {
        Select languageOption = new Select(driver.findElement(By.cssSelector("#select-language")));
        List<WebElement> elementCount = languageOption.getOptions();
        System.out.println(elementCount.size());
        int actual = elementCount.size();
        int expectedSize = 3;
        assertTrue(actual == expectedSize);

        driver.manage().window().maximize();
        languageOption.selectByVisibleText("French");
    }

    @Test
    public void searchTest() {
        WebElement searchField = driver.findElement(By.cssSelector("#search"));
        searchField.clear();
        searchField.sendKeys("dress");
        searchField.submit();
        WebElement searchTitle = driver.findElement(By.cssSelector(".page-title h1"));
        String wordInSearch = "DRESS";
        assertTrue(searchTitle.getText().contains(wordInSearch));


    }

    @Test
    public void newProducts() {
        List<WebElement> newProducts = driver.findElements(By.cssSelector(".item.last"));
        System.out.println(" Number of new products is: " + newProducts.size());
        Iterator<WebElement> itr = newProducts.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().getText() + " ");
        }
    }


    @Test
    public void navigation() {
        List<WebElement> headerElements = driver.findElements(By.cssSelector(".level0.parent"));
        Iterator<WebElement> itr = headerElements.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().getText() + " ");
        }
        WebElement sales = driver.findElement(By.cssSelector(".nav-5"));
        sales.click();
        String currentSalesURL = driver.getCurrentUrl();
        String corectSaleURL = "http://qa1.dev.evozon.com/sale.html";
        assertEquals(currentSalesURL, corectSaleURL);
    }


    public WebElement getInputByTitle(String title){
        return driver.findElement(By.cssSelector("li.active input[title='" + title + "']"));
    }




    @Test
    public void checkout() {
        WebElement sales = driver.findElement(By.cssSelector(".nav-5"));
        sales.click();
        WebElement productFromSales = driver.findElement(By.cssSelector("#product-collection-image-338"));
        productFromSales.click();
        WebElement searchField = driver.findElement(By.cssSelector("#search"));
        searchField.sendKeys("dress");
        searchField.submit();
        WebElement category = driver.findElement(By.cssSelector("#narrow-by-list"));
        assertTrue(category.isDisplayed());
        WebElement productFromDresses = driver.findElement(By.cssSelector("#product-collection-image-425"));
        productFromDresses.click();
        WebElement colorFilter = driver.findElement(By.cssSelector("#option27"));
        colorFilter.click();
        WebElement sizeFilter = driver.findElement(By.cssSelector("#option73"));
        sizeFilter.click();
        WebElement addToCart = driver.findElement(By.cssSelector(".add-to-cart-buttons"));
        addToCart.click();
        String corectCartURL = "http://qa1.dev.evozon.com/checkout/cart/";
        String currentCartURL = driver.getCurrentUrl();
        assertEquals(corectCartURL, currentCartURL);
        WebElement productsInCart = driver.findElement(By.cssSelector("#shopping-cart-table"));
        assertTrue(productsInCart.isDisplayed());
        WebElement checkoutButton = driver.findElement(By.cssSelector(".checkout-types.top"));
        checkoutButton.click();
        WebElement continueButton = driver.findElement(By.cssSelector("#onepage-guest-register-button"));
        continueButton.click();

        getInputByTitle("First Name").sendKeys("Vasi");
        getInputByTitle("Middle Name/Initial").sendKeys("VasiLica");
        getInputByTitle("Last Name").sendKeys("VasiLica");
        getInputByTitle("Email Address").sendKeys("VasiLica@yahoo.com");
        getInputByTitle("Street Address").sendKeys("Muncii");
        getInputByTitle("City").sendKeys("Cluj");
        getInputByTitle("Zip/Postal Code").sendKeys("123456789");
        getInputByTitle("Telephone").sendKeys("0745123456");

        WebElement state = driver.findElement(By.cssSelector("#billing\\:region_id"));
        state.click();
        Select selectState = new Select(state);
        selectState.selectByVisibleText("Alabama");

        WebElement country = driver.findElement(By.cssSelector("#billing\\:country_id"));
        country.click();
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("Tanzania");

        WebElement shipToDifferentAddress = driver.findElement(By.cssSelector("#billing\\:use_for_shipping_no"));
        shipToDifferentAddress.click();

        WebElement continueBilling = driver.findElement(By.cssSelector("#billing-buttons-container>button"));
        continueBilling.click();


        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#shipping\\:firstname"))).click();
            getInputByTitle("First Name").sendKeys("Vasi");
            getInputByTitle("Middle Name/Initial").sendKeys("VasiLica");
            getInputByTitle("Last Name").sendKeys("VasiLica");
            getInputByTitle("Street Address").sendKeys("Muncii");
            getInputByTitle("City").sendKeys("Cluj");
            getInputByTitle("Zip/Postal Code").sendKeys("123456789");
            getInputByTitle("Telephone").sendKeys("0745123456");


            WebElement countryFromShipping = driver.findElement(By.cssSelector("#shipping\\:country_id"));
            countryFromShipping.click();
            Select selectCountryFromShipping = new Select(countryFromShipping);
            selectCountryFromShipping.selectByVisibleText("Tanzania");

//            WebElement stateFromShipping = driver.findElement(By.cssSelector("#shipping\\:region"));
//            stateFromShipping.click();
//            Select selectStateFromShipping = new Select(stateFromShipping);
//            selectStateFromShipping.selectByVisibleText("Alabama");


            WebElement continueFromShipping = driver.findElement(By.cssSelector("#shipping-buttons-container button[title='Continue']"));
            continueFromShipping.click();

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#s_method_freeshipping_freeshipping"))).click();
            driver.findElement(By.cssSelector("#shipping-method-buttons-container .button")).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#payment-buttons-container .button"))).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#review-buttons-container .button"))).click();

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sub-title")));
            WebElement confirmationMessage = driver.findElement(By.cssSelector(".sub-title"));
            assertTrue(confirmationMessage.isDisplayed());



























    }
}







