package com.yos.basePages;


import com.yos.utilities.*;

import com.yos.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class yosLogin {

    public yosLogin() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    ButtonBasePage sign = new ButtonBasePage();
    @FindBy(xpath = "//input[@placeholder='Your Email']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPassword;


    public void login() {
        ExcelHelper excelreads = new ExcelHelper("yös_signUp.xlsx");
        excelreads.setSheet("SignUp");
        sign.signIn.click();
        inputUsername.sendKeys(excelreads.readData(6, 1));
        inputPassword.sendKeys(excelreads.readData(14, 2));
        sign.signIn_UpButton.click();

    }

}
