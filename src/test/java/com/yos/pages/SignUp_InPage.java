package com.yos.pages;

import com.yos.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp_InPage {
    public SignUp_InPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='name']")
    public WebElement setYourName;

    @FindBy(xpath = "//input[@placeholder='Your Email']")
    public WebElement setYourEmail;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement setSignInPassword;
    @FindBy(xpath = "//input[@id='password1']")
    public WebElement setSignUpPassword;
    @FindBy(xpath = "//input[@id='password2']")
    public WebElement setRePassword;
    @FindBy(xpath = "(//p[@class='mt-2 text-sm text-green-600 dark:text-black'][1])")
    public WebElement nameMessage;
    @FindBy(xpath = "(//p[@class='mt-2 text-sm text-green-600 dark:text-black'][2])")
    public WebElement emailMessage;
    @FindBy(xpath = "(//p[@class='mt-2 text-sm text-green-600 dark:text-black'][3])")
    public WebElement passwordMessage;
    @FindBy(xpath = "(//p[@class='mt-2 text-sm text-green-600 dark:text-black'][4])")
    public WebElement repasswordMessage;
    @FindBy(xpath = "//input[@id='link-checkbox']")
    public WebElement savePassword;
    @FindBy(xpath = "//*[@id=\"root\"]/div/nav/div/div[1]/div[2]/div/div/div/div[2]/div/div/div[1]/a")
    public WebElement forgetPassword;
    @FindBy(xpath = "//h3[@class='text-xl  font-semibold text-gray-900 dark:text-white']")
    public WebElement SignInUpLabel;


}
