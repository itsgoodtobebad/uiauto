package com.itsgoodtobebad.uiauto.pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author liliangxi.
 *         Created on 2018/12/25.
 */
public class PersonalPage extends PageObject{

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    public String getUserNameAndNickyName() {
        return driver.findElement(By.xpath("//body//div[@class='item']")).getText();
    }
}
