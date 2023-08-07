package com.yos.basePages;

import com.yos.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonBasePage {
    public ButtonBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div/div/div[1]/div/div[1]/div[1]/div[2]/input")
    public WebElement selectCity;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/input")
    public WebElement selectUniversity;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div/div/div[3]/div/div[1]/div[1]/div[2]/input")

    public WebElement selectDepartment;


    @FindBy(xpath = "//button[contains(.,'Search')]")
    public WebElement searchButton;
    @FindBy(xpath = "//button[contains(., 'Sign In')]")
    public WebElement signIn;

    @FindBy(xpath = "//button[contains(., 'Sign Up')]")
    public WebElement signUp;
    @FindBy(xpath = "//button[@type='Submit']")
    public WebElement signIn_UpButton;
    @FindBy(xpath = "//*[@id='root']/div/nav/div/div[1]/div[2]/div/div/div/div[1]/button")
    public WebElement signIn_UpExit;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/form/div[3]/button[1]")
    public WebElement subscribe;


    @FindBy(xpath = "//*[@id=\"navbar-language\"]/ul/li[1]/a")
    public WebElement home;
    @FindBy(xpath = "//*[@id=\"navbar-language\"]/ul/li[2]/a")

    public WebElement universities;
    @FindBy(xpath = "//*[@id='navbar-language']/ul/li[3]/a")
    public WebElement departments;

    @FindBy(xpath = "//*[@id='root']/div/nav/div/div[1]/button")
    public WebElement language;
    @FindBy(xpath = "//*[@id='tr']/a/div")
    public WebElement turkish;

    @FindBy(xpath = "//*[@id='en']/a/div")
    public WebElement english;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/main/div/div/form/div/div[5]/button")

    public WebElement save;


}
