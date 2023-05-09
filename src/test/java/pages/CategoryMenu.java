package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryMenu {
    private static WebDriver driver;
    private static Actions actions;

    @FindBy(css = "#nav > ol > li.level0.nav-2.parent > a")
    private WebElement menCategory;

    @FindBy(css = "#nav > ol > li.level0.nav-3.parent > a")
    private WebElement accessoriesCategory;

    @FindBy(css = "#nav > ol > li.level0.nav-4.parent > a")
    private WebElement homeAndDecorCategory;

    public CategoryMenu(WebDriver driver, Actions actions) {
        CategoryMenu.driver = driver;
        CategoryMenu.actions = actions;
        PageFactory.initElements(driver, this);
    }

    @Step("Click a subcategory of the Men category")
    public ProductSubCategoryPage clickMenSubCategory(String subCategory) {
        actions.moveToElement(menCategory).perform();
        WebElement menSubCategory = driver.findElement(By.linkText(subCategory));
        menSubCategory.click();
        return new ProductSubCategoryPage(driver);
    }

    @Step("Click a subcategory of the Accesories category")
    public ProductSubCategoryPage clickAccesoriesSubCategory(String subCategory) {
        actions.moveToElement(accessoriesCategory).perform();
        WebElement accesoriesSubCategory = driver.findElement(By.linkText(subCategory));
        accesoriesSubCategory.click();
        return new ProductSubCategoryPage(driver);
    }

    @Step("Click a subcategory of the Home & Decor category")
    public ProductSubCategoryPage clickHomeAndDecorSubCategory(String subCategory) {
        actions.moveToElement(homeAndDecorCategory).perform();
        WebElement homeAndDecorSubCategory = driver.findElement(By.linkText(subCategory));
        homeAndDecorSubCategory.click();
        return new ProductSubCategoryPage(driver);
    }
}
