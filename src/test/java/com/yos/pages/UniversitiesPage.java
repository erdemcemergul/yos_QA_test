package com.yos.pages;

import com.yos.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniversitiesPage {
    public UniversitiesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]")
    public WebElement unicersityCard;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div[1]/div[1]/div/p[1]")
    public WebElement unicersityCardName;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/div[2]/div[2]")
    public WebElement unicersityCardPhone;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div[1]/div[3]/div[2]")
    public WebElement unicersityCardDepartments;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/button[1]")
    public WebElement unicersityCardFaculties;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[1]/p")
    public WebElement unicersityCardCity;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/a[1]/div/div/img")
    public WebElement unicersityCardLogo;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/a[1]/div/div/div/p[2]")
    public WebElement forContinue;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]")
    public WebElement unicersityCardAdress;


}
