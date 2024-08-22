import api.user.User;
import api.user.UserSteps;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.time.Duration;

import static api.user.UserGenerate.generateUserData;

public class ConstructorTest {
    String accessToken;
    UserSteps userSteps = new UserSteps();

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @After
    public void tearDown() {
        driver.quit();
        if (accessToken != null) userSteps.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Проверка перехода к разделу булки")
    public void testTransitionTabBuns() {
        Assert.assertTrue(new MainPage(driver)
                .checkIsActiveTabBuns());
    }

    @Test
    @DisplayName("Проверка перехода к разделу соусы")
    public void testTransitionTabSauces() {
        Assert.assertTrue(new MainPage(driver)
                .clickOnTabSauces()
                .checkIsActiveTabSauces());
    }

    @Test
    @DisplayName("Проверка перехода к разделу начинки")
    public void testTransitionTabFillings() {
        Assert.assertTrue(new MainPage(driver)
                .clickOnTabFillings()
                .checkIsActiveTabFillings());
    }
}