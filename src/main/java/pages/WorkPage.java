package pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.ElementFactory;
import webdriver.elements.TextBox;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WorkPage extends BaseForm {

    private TextBox search_field = new TextBox(By.xpath("//input[contains(@data-qa,'vacancy-serp__query')]"), "search_field");
    private Button search_button = new Button(By.xpath("//button[@data-qa='navi-search__button']"), "search_button");

    private static By title = (By.xpath("//div[@class='vacancy-serp-item__title']"));
    private static By work_page = (By.xpath("//div[@class='index-dashboard-header-wrapper']"));

    private static String expression = "(QA|[С|с]пециалист по тестированию|Test Automation|Automation Test|[Т|т]естировщик)";

    private static String messageValid = "coincidence";
    private static String messageNoValid = "non-coincidence";
    private static String messageNumberCoincidence = "number coincidence: ";

    public WorkPage() {
        super((work_page), "Work page");
    }

    public void fillJobVacancy(String searchStr) {
        search_field.setText(searchStr);
    }

    public void jobVacancySearchclick() {
        search_button.click();
    }

    public static boolean isRegExp(String titleName) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(titleName);
        boolean resultFind = matcher.find();
        return resultFind;
    }

    public static int countJobVacancyTitle() {
        List<Button> linksList = ElementFactory.getDataFromElements(title);
        int coincidence = 0;
        for (Button webElement : linksList) {
            logger.info(String.format("Title text = %1$s", webElement.getText()));
            if (isRegExp(webElement.getText()) == true) {
                logger.info(String.format(messageValid));
                coincidence++;
            } else {
                logger.info(String.format(messageNoValid));
            }
        }
        logger.info(messageNumberCoincidence + coincidence);

        return coincidence;
    }

    public static boolean isCountCoincidence(int model, int percent) {
        List<Button> linksList = ElementFactory.getDataFromElements(title);
        int sizeList = linksList.size();
        double result = (countJobVacancyTitle() * percent) / sizeList;
        if (result > model) {
            return true;
        } else {
            return false;
        }
    }
}
