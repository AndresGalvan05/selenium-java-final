package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static WebDriver driver;
    private static Actions actions;

    //*[@id="nav"]/ol/li[6]/a[title='MEN']
    //*[@id="nav"]/ol/li[6]/a[text() = 'MEN']
    //*[@id="nav"]/ol/li[6]/a[contains(text(), 'MEN')]
//    @FindBy(linkText = "MEN")
//    @FindBy(xpath = "//*[@id=\"nav\"]/ol/li[2]/a[title='MEN']")
//    @FindBy(css = "#nav > ol > li.level0.nav-2.parent > a[title='MEN']")
    @FindBy(css = "#nav > ol > li.level0.nav-2.parent > a")
    private WebElement menCategory;

    public HomePage(WebDriver driver, Actions actions) {
        HomePage.driver = driver;
        HomePage.actions = actions;
        PageFactory.initElements(driver, this);
    }

//    public void selectCategory(String category) {
//        WebElement categoryElement = driver.findElement(By.linkText(category));
//        actions.moveToElement(categoryElement).perform();
//    }

    @Step("Click a subcategory of the Men category")
    public ProductSubCategoryPage clickMenSubCategory(String subCategory) {
        actions.moveToElement(menCategory).perform();
        WebElement menSubCategory = driver.findElement(By.linkText(subCategory));
        menSubCategory.click();
        return new ProductSubCategoryPage(driver);
    }
}
