package com.yos.pages;

import com.yos.baseMethods.ApiSelecter;
import com.yos.utilities.Driver;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class DepartmentsPage {
    public DepartmentsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebDriver driver;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div/div/div[2]/div/a")
    public WebElement cardOfDepartment;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div/div/div[2]/p[1]")
    public WebElement cardOfFaculty;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div/div/div[2]/p[2]")
    public WebElement cardOfUniversity;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div/div/div[5]/div[1]/div[2]")
    public WebElement cardOfCity;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div/div/div[5]/div[2]/div")
    public WebElement cardOfPrice;
    @FindBy(xpath = "(//button[@class='m-2  px-3 flex '])[1]")
    public WebElement compare;
    @FindBy(xpath = "(//button[@class='m-2 px-3 flex'])[1]")
    public WebElement compared;
    @FindBy(xpath = "(//*[@viewBox=\"0 0 576 512\"])[1]")
    public WebElement favourite;
    @FindBy(xpath = "//*[@id=\"user-dropdown\"]/ul/li[4]/a")
    public WebElement logOut;


}
