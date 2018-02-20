package webdriver.elements;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import webdriver.Browser;

public class ElementFactory {

	private final static WebDriver DRIVER = Browser.getInstance().getDriver();

	public static List<Button> getDataFromElements(By locator) {

		List<WebElement> elements = DRIVER.findElements(locator);
		List<Button> listOfButtons = new ArrayList<Button>();

		for (WebElement e : elements)
			listOfButtons.add(new Button(e, "Button: " + e.getText()));

		return listOfButtons;
	}

	public static Button getButtonByLocator(String format) {
		return new Button(By.xpath(format));
	}
}
