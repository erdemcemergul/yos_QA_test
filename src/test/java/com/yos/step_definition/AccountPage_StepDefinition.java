package com.yos.step_definition;

import com.yos.baseMethods.ApiSelecter;
import com.yos.baseMethods.ClickSelecter;
import com.yos.basePages.ButtonBasePage;
import com.yos.pages.AccountPage;
import com.yos.utilities.Driver;
import com.yos.utilities.ExcelHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage_StepDefinition {
    ApiSelecter apiSelecter = new ApiSelecter();
    AccountPage accountPage = new AccountPage();
    ExcelHelper excelreads = new ExcelHelper("yös_signUp.xlsx");
    ClickSelecter clickSelecter = new ClickSelecter();

    String fakeName = "";
    String fakeEmail = "";
    String fakePass = "";
    int favUniNumb = 0;
    int comUniNumb = 0;


    @When("User clicks {string} section")
    public void userClicksSection(String arg0) throws InterruptedException {
        switch (arg0) {
            case "My Favorite Universities":
                String uniNum = accountPage.favoritesUni.getText();
                favUniNumb = Integer.parseInt(uniNum);
                String comNum = accountPage.compareListNumber.getText();
                comUniNumb = Integer.parseInt(comNum);
                accountPage.favoritesUni.click();
                Thread.sleep(1000);
                break;
            case "My Compare list":

                accountPage.myCompareList.click();
                Thread.sleep(1000);
                break;
        }

    }

    @Then("User should see same amount of My Favorite Universities card")
    public void userShouldSeeSameAmountOfMyFavoriteUniversitiesCard() {

        Assert.assertEquals(accountPage.UniList.size(), favUniNumb);
    }

    @Then("User should see same amount of My Compare List card")
    public void userShouldSeeSameAmountOfMyCompareListCard() {

        Assert.assertEquals(accountPage.UniList.size(), comUniNumb);
    }

    @When("User should fill out the mandatory areas")
    public void userShouldFillOutTheMandatoryAreas() throws InterruptedException {

        excelreads.setSheet("SignUp");
        Thread.sleep(1000);
        accountPage.myProfileButton.click();
        Thread.sleep(1000);
        fakeName = ("Anna" + excelreads.readData(1, 0));

        //fakeEmail = ("B"+excelreads.readData(5, 1) + "@email.com");
        accountPage.yourNameField.sendKeys(Keys.CLEAR, Keys.CONTROL, "A", Keys.DELETE);
        // accountPage.EmailField.clear();
        accountPage.CityField.sendKeys(Keys.CLEAR, Keys.CONTROL, "A", Keys.DELETE);
        accountPage.PhoneField.sendKeys(Keys.CLEAR, Keys.CONTROL, "A", Keys.DELETE);
        accountPage.yourNameField.sendKeys(Keys.chord(fakeName));
        //accountPage.EmailField.sendKeys(Keys.chord(fakeEmail));
        accountPage.CityField.sendKeys(Keys.chord("Batman"));
        accountPage.PhoneField.sendKeys(Keys.chord("444445"));

    }

    @When("User enters {string} into box from the excel sheet")
    public void userEntersIntoBoxFromTheExcelSheet(String arg0) {
        String currentPassword = excelreads.readData(14, 2);
        fakePass = ("A" + excelreads.readData(22, 3));

        switch (arg0) {
            case "Current Password":
                accountPage.currentPasswordField.sendKeys(Keys.chord(currentPassword));
                break;
            case "New Password":
                accountPage.changePasswordButton.sendKeys(Keys.chord(fakePass));
                break;
            case "ReNew Password":
                accountPage.confirmPasswordField.sendKeys(Keys.chord(fakePass));
                break;
        }

    }


    @Then("Profil updates check from API")
    public void profilUpdatesCheckFromAPI() {
        Response response = apiSelecter.loginUser(excelreads.readData(6, 1), excelreads.readData(14, 2));
        JsonPath jsonPath = response.jsonPath();
        String idName = jsonPath.getString("userID");
        System.out.println(idName);
        Response response1 = apiSelecter.getUserById(idName);
        JsonPath jsonPath1 = response1.jsonPath();
        Assert.assertEquals(jsonPath1.getString("user.name"), fakeName);
        Assert.assertEquals(jsonPath1.getString("user.city"), "Batman");
        Assert.assertEquals(jsonPath1.getString("user.phone"), "444445");


    }

    @Then("User click Save button")
    public void userClickSaveButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)); // 10 saniyeye kadar bekleyeceğiz
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clickSelecter.clicker("Save")));
        button.click();
        button.submit();
        Thread.sleep(3000);
        clickSelecter.clicker("Save").click();
        clickSelecter.clicker("Save").submit();
        clickSelecter.clicker("Save").click();
        Thread.sleep(3000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", clickSelecter.clicker("Save"));


    }
}
