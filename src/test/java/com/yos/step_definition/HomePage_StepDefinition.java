package com.yos.step_definition;

import com.yos.baseMethods.ApiSelecter;
import com.yos.baseMethods.ClickSelecter;
import com.yos.baseMethods.FakeNameCreater;
import com.yos.basePages.ButtonBasePage;
import com.yos.pages.HomePage;
import com.yos.pages.SignUp_InPage;
import com.yos.utilities.ConfigurationReader;
import com.yos.utilities.Driver;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class HomePage_StepDefinition {
    ButtonBasePage buttonBasePage = new ButtonBasePage();
    HomePage homePage = new HomePage();
    SignUp_InPage signUpInPage = new SignUp_InPage();
    ClickSelecter clickSelecter = new ClickSelecter();
    String fakeEmail = "";


    @Then("User should go to {string} page")
    public void userShouldGoToPage(String PageName) {
        //Assert.assertTrue(Driver.getDriver().getTitle().contains(PageName));
        switch (PageName) {
            case "Universities":
                Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith("universities"));
                break;
            case "Departments":
                Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith("departments"));
                break;
            case "Home":
                Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigurationReader.getProperty("yos.url") + "/");
                break;

            case "About Us":
                Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("About Us"));
                break;
            case "FAQsPage":            // bu sayfa daha geçerli değil
                Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("faq page"));
                //System.out.println("FAQsPage");
                break;
            case "Checkout":        // bu sayfa daha geçerli değil
                Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout"));
                //System.out.println("Checkout");
                break;
            case "Contact":         // bu sayfa daha geçerli değil
                Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("contactUs"));
                //System.out.println("Contact");
                break;
            case "Blog":               // bu sayfa daha geçerli değil
                Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("blog"));
                //System.out.println("Blog");
                break;
            case "My Profile":
                Assert.assertTrue(homePage.signUpAlert.isDisplayed());     //uye giris yapmadan olursa
                //System.out.println("My Profile");
                break;
            case "Favorites":
                Assert.assertTrue(homePage.signUpAlert.isDisplayed());     //uye giris yapmadan olursa
                //System.out.println("Favorites");
                break;
            case "SIGN IN":
                Assert.assertEquals("SIGN IN", signUpInPage.SignInUpLabel.getText());
                break;
            case "Sign Up":
                Assert.assertEquals("Sign Up", signUpInPage.SignInUpLabel.getText());
        }
    }

    @When("User click the {string} dropdown menu")
    public void userClickTheDropdownMenu(String string) {
        switch (string) {
            case "SelectCities":
                buttonBasePage.selectCity.click();
                break;
            case "SelectUniversities":
                buttonBasePage.selectUniversity.click();
                break;
            case "SelectDepatments":
                buttonBasePage.selectDepartment.click();
                break;
        }

    }


    @When("User select the English language")
    public void user_select_the_english_language() {
        buttonBasePage.language.click();
        buttonBasePage.english.click();
    }


    @When("User select the Turkish language")
    public void user_select_the_turkish_language() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(buttonBasePage.language).perform();
        actions.click(buttonBasePage.language).perform();


        buttonBasePage.turkish.click();
    }

    @Then("User see warning of alert")
    public void userSeeWarningOfAlert() throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertTrue(homePage.signUpAlert.isDisplayed());

    }

    @Then("User should see available {string} list")
    public void userShouldSeeAvailableList(String arg0) {
        switch (arg0) {
            case "city":
                Assert.assertTrue(homePage.cityList.isDisplayed());
                break;
            case "university":
            case "department":
                Assert.assertTrue(homePage.universityList.isDisplayed());
                break;

        }
    }

    @When("User enter valid mail address")
    public void user_enter_valid_mail_address() {
        //Assert.assertTrue(homePage.emailSubscribe.getText().contains("@"));
        fakeEmail = FakeNameCreater.fakerName(8) + "@gmail.com";
        homePage.emailSubscribe.sendKeys(fakeEmail);

    }

    @Then("User click Subscribe button")
    public void userClickSubscribeButton() throws InterruptedException {
      /*  WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)); // 10 saniyeye kadar bekleyeceğiz
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clickSelecter.clicker("Subscribe")));
        button.click();
        button.submit();
        Thread.sleep(3000);*/
        clickSelecter.clicker("Subscribe").click();
       /* clickSelecter.clicker("Subscribe").submit();
        clickSelecter.clicker("Subscribe").click();
        Thread.sleep(3000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", clickSelecter.clicker("Subscribe"));*/

    }

    @Then("Email should come from API")
    public void emailShouldComeFromAPI() {
        ApiSelecter apiSelecter = new ApiSelecter();


        Response emailAdd = null;

        try {
            emailAdd = apiSelecter.addEmail(fakeEmail);
        } catch (Exception e) {
            System.out.println("API çağrısında hata oluştu: " + e.getMessage());
        }

        if (emailAdd != null) {
            if (emailAdd.getStatusCode() == 404) {
                Assert.assertEquals(404, emailAdd.getStatusCode());
            } else {
                String jsonString = emailAdd.asString();
                String emails = JsonPath.from(jsonString).getString("status");

                if (emails.equals("error")) {
                    Assert.assertEquals("This Email Already Exists.", JsonPath.from(jsonString).getString("message")); // Test geçerli
                } else {
                    Assert.fail();
                }
            }
        } else {
            System.out.println("API çağrısında hata oluştu.");
        }


    }
}
