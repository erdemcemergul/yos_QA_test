package com.yos.pages;

import com.yos.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPage {
    public AccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@href='/favorites'][2])")
    public WebElement favoritesUni;

    @FindBy(xpath = "//*[@id='root']/div/div[1]/div[2]/main/div/div[2]/p")
    public WebElement compareListNumber;

    @FindBy(xpath = "//a[.='My Compare list']")
    public WebElement myCompareList;


    @FindBy(xpath = "(//button[.='My Profile'])")
    public WebElement myProfileButton;
    @FindBy(xpath = "//*[@id=\"user-dropdown\"]/ul/li[2]/a")
    public WebElement myFavouriteDepartments;
    @FindBy(xpath = "//*[@id=\"user-dropdown\"]/ul/li[3]/a")
    public WebElement myCompareDepartments;
    @FindBy(xpath = "(//button[.='Change Password'])")
    public WebElement changePasswordButton;


    @FindBy(xpath = "//button[@id='user-menu-button']")
    public WebElement userMenuButton;

    @FindBy(xpath = "(//li/a[@href='/myprofile'])[1]")
    public WebElement myProfileMenu;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement yourNameField;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement EmailField;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement CityField;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement PhoneField;

    @FindBy(xpath = "//textarea[@type='text']")
    public WebElement aboutField;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement currentPasswordField;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement newPasswordField;

    @FindBy(xpath = "(//input[@type='password'])[3]")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class,'flex flex-col')]")
    public List<WebElement> UniList;

    @FindBy(xpath = "//p[contains(.,'Favorite Universities')]")
    public WebElement favoriteUniversity;


}
