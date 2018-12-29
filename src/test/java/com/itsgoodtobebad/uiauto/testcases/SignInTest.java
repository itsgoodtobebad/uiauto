package com.itsgoodtobebad.uiauto.testcases;

import com.itsgoodtobebad.uiauto.pages.HomePage;
import com.itsgoodtobebad.uiauto.pages.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author liliangxi.
 *         Created on 2018/12/25.
 */
public class SignInTest {
    private WebDriver driver = null;

    @Before
    public void init() {
        // 这里需要加异常处理
        // 如果setProperty失败了，会吗？
        // 如果get失败了怎么办？
        System.setProperty("webdriver.gecko.driver", "d://gecko//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://testerhome.com/account/sign_in");
    }

    @After
    public void cleanUp(){
            driver.quit();
    }

    @Test
    public void testSignIn() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = signInPage.SignIn("itsgoodtobebad@263.net", "nihao123");
        Assert.assertEquals(true, homePage.returnTestBoolean(false));
    }
}
