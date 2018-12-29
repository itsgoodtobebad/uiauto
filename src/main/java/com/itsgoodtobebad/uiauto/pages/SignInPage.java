package com.itsgoodtobebad.uiauto.pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author liliangxi.
 *         Created on 2018/12/25.
 */
public class SignInPage extends PageObject{

    private final String name = "TesterHome登录页面";
    private final String title = "登录 · TesterHome";

    @FindBy(id="user_login")
    WebElement username;

    @FindBy(id="user_password")
    WebElement password;

    @FindBy(xpath="//form[@id='new_user']//div/input[@type='submit']")
    WebElement signInBtn;

    public SignInPage(WebDriver driver) {
        super(driver);

        // 这里判断title
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        try{
            boolean flag = wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(@NullableDecl WebDriver driver) {
                    String actualTitle = driver.getTitle();
                    return actualTitle.equals(title);
                }
            });
        }catch (TimeoutException e){
            throw new IllegalStateException("网页" + name + "检查Title失败，当前网址是：" + driver.getCurrentUrl());
        }
    }

    public HomePage SignIn(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);

        this.signInBtn.click();

        return new HomePage(driver);
    }
}
