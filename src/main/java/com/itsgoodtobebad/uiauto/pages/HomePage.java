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
public class HomePage extends PageObject{

    private final String name = "TesterHome首页";
    private final String title = "TesterHome";

    @FindBy(xpath = "//body//li[@class='dropdown dropdown-avatar']/ul/button")
    WebElement personalDropDownBtn;

    @FindBy(xpath = "//body//li[@class='dropdown dropdown-avatar']/ul/li[1]/a")
    WebElement personalLink;

    public HomePage(WebDriver driver) {
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

    public PersonalPage toPersonalPage() throws InterruptedException {
        System.out.println(driver.getPageSource());
        personalDropDownBtn.click();
        Thread.sleep(5000);
        personalLink.click();

        return new PersonalPage(driver);
    }

    public boolean returnTestBoolean(boolean flag){
        return flag;
    }
}
