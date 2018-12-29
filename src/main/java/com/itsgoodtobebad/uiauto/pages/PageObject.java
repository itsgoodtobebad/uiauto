package com.itsgoodtobebad.uiauto.pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liliangxi.
 *         Created on 2018/12/25.
 */
public abstract class PageObject {
    protected final int TIMEOUT = 30;
    protected final WebDriver driver;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public PageObject(WebDriver driver) {
        this.driver = driver;

        WebDriverWait wait = new WebDriverWait(driver, 30);

        final Boolean complete = wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
        PageFactory.initElements(driver, this);
    }
}
