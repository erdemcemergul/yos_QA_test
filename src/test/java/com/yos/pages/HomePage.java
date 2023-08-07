package com.yos.pages;

import com.yos.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//li[@class='mb-4'])[1]/a")
    public WebElement aboutUs;

    @FindBy(xpath = "(//li[@class='mb-4'])[2]/a")
    public WebElement faqsPage;

    @FindBy(xpath = "(//li[@class='mb-4'])[3]/a")
    public WebElement checkout;

    @FindBy(xpath = "(//li[@class='mb-4'])[4]/a")
    public WebElement contact;

    @FindBy(xpath = "(//li[@class='mb-4'])[5]/a")
    public WebElement blog;

    @FindBy(xpath = "//li[@class='mb-6']")
    public WebElement myProfile;

    @FindBy(xpath = "//a[@href='/favorites']")
    public WebElement favorites;

    @FindBy(xpath = "//*[@id='navbar-language']/ul/li[1]/a")
    public WebElement homeText;

    @FindBy(xpath = "(//div[contains(@class, 'Toastify')]//div[@role='alert'])[1]")
    public WebElement signUpAlert;


    @FindBy(xpath = "//div[@class='select __menu css-1nmdiq5-menu']")
    public WebElement cityList;

    @FindBy(xpath = "//div[@class='select__menu css-1nmdiq5-menu']")
    public WebElement universityList;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailSubscribe;


}
