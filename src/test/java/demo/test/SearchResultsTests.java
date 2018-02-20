package demo.test;

import org.testng.Assert;
import pages.HomePage;
import pages.MenuItems;
import pages.WorkPage;
import webdriver.BaseTest;



public class SearchResultsTests extends BaseTest {

    int modelPercentCoincidence = 80;
    int percent = 100;
    private final String search_Text ="Специалист по тестированию";

        WorkPage workPage;
        HomePage homePage;

    @Override
    public void runTest() {


            homePage = new HomePage();

            logStep("navigate to page work");
            homePage.navigateToPageWork(MenuItems.JOB);

            workPage = new WorkPage();

            logStep("fill in the search field");
            workPage.fillJobVacancy(search_Text);

            logStep("click button searh");
            workPage.jobVacancySearchclick();

            Assert.assertTrue( WorkPage.isCountCoincidence(modelPercentCoincidence, percent), "quantity coincidence: < " + modelPercentCoincidence + "%");
        }
    }
