package pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.ElementFactory;


public class HomePage extends BaseForm {

    private static By home_page = (By.xpath(".//*[@id='title_news_block']"));
    public String sectionButton = ".//*[text()='%s']";

    public HomePage() {
        super((home_page), "Home page");
    }

    public void navigateToPageWork(MenuItems path) {
        ElementFactory.getButtonByLocator(String.format(sectionButton, path.get())).click();
    }
}