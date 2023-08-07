package com.yos.step_definition;

import com.yos.baseMethods.ApiSelecter;
import com.yos.baseMethods.ClickSelecter;
import com.yos.basePages.ButtonBasePage;
import com.yos.pages.HomePage;
import com.yos.pages.SignUp_InPage;
import com.yos.utilities.ExcelHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Sign_Up_In_StepDefinition {
    ExcelHelper excelreads = new ExcelHelper("yös_signUp.xlsx");
    ApiSelecter apiSelecter = new ApiSelecter();
    ClickSelecter clickSelecter = new ClickSelecter();

    ButtonBasePage basePage = new ButtonBasePage();
    SignUp_InPage signUpInPage = new SignUp_InPage();
    public static String userName = "";
    public static String email = "";
    public static String password = "";
    public static String repassword = "";


    @When("User should see the input entity is {string} on {string}")
    public void userShouldSeeTheInputEntityIsOn(String arg0, String arg1) throws InterruptedException {
        userName = excelreads.readData(3, 0);
        email = excelreads.readData(6, 1);
        password = excelreads.readData(14, 2);
        repassword = excelreads.readData(23, 3);
        ExcelHelper excelreads = new ExcelHelper("yös_signUp.xlsx");
        excelreads.setSheet("SignUp");
        Thread.sleep(3000);
        switch (arg1) {
            case "Name":
                switch (arg0) {
                    case "empty":
                        userName = excelreads.readData(1, 0);
                        break;
                    case "more 10 chars":
                        userName = excelreads.readData(2, 0);
                        break;
                    case "ok":
                        userName = excelreads.readData(3, 0);
                        break;
                }
                if (signUpInPage.SignInUpLabel.getText().equals("Sign Up")) {
                    signUpInPage.setYourName.sendKeys(userName);
                }


                break;
            case "email":
                switch (arg0) {
                    case "empty":
                        email = excelreads.readData(4, 1);
                        break;
                    case "lack":
                        email = excelreads.readData(5, 1);
                        break;
                    case "ok":
                        email = excelreads.readData(6, 1);
                        break;
                }
                if (signUpInPage.SignInUpLabel.getText().equals("Sign Up")) {
                    signUpInPage.setYourName.sendKeys(userName);
                    signUpInPage.setYourEmail.sendKeys(email);
                } else if (signUpInPage.SignInUpLabel.getText().equals("SIGN IN"))
                    signUpInPage.setYourEmail.sendKeys(email);

                break;
            case "password":
                switch (arg0) {
                    case "empty":
                        password = excelreads.readData(7, 2);
                        break;
                    case "less 8 chars":
                        password = excelreads.readData(8, 2);
                        break;
                    case "lack a number":
                        password = excelreads.readData(9, 2);
                        break;
                    case "lack a lower case":
                        password = excelreads.readData(10, 2);
                        break;
                    case "lack a upper case":
                        password = excelreads.readData(11, 2);
                        break;
                    case "lack a special char":
                        password = excelreads.readData(12, 2);
                        break;
                    case "more 20 chars":
                        password = excelreads.readData(13, 2);
                        break;
                    case "ok":
                        password = excelreads.readData(14, 2);
                        break;
                }
                if (signUpInPage.SignInUpLabel.getText().equals("Sign Up")) {
                    signUpInPage.setYourName.sendKeys(userName);
                    signUpInPage.setYourEmail.sendKeys(email);
                    signUpInPage.setSignUpPassword.sendKeys(password);
                } else if (signUpInPage.SignInUpLabel.getText().equals("SIGN IN")) {
                    signUpInPage.setYourEmail.sendKeys(email);
                    signUpInPage.setSignInPassword.sendKeys(password);
                }

                break;
            case "repassword":
                switch (arg0) {
                    case "empty":
                        repassword = excelreads.readData(15, 3);
                        break;
                    case "less 8 chars":
                        repassword = excelreads.readData(16, 3);
                        break;
                    case "lack a number":
                        repassword = excelreads.readData(17, 3);
                        break;
                    case "lack a lower case":
                        repassword = excelreads.readData(18, 3);
                        break;
                    case "lack a upper case":
                        repassword = excelreads.readData(19, 3);
                        break;
                    case "lack a special char":
                        repassword = excelreads.readData(20, 3);
                        break;
                    case "more 20 chars":
                        repassword = excelreads.readData(21, 3);
                        break;
                    case "different":
                        repassword = excelreads.readData(22, 3);
                        break;
                    case "ok":
                        repassword = excelreads.readData(23, 3);
                        break;
                }
                if (signUpInPage.SignInUpLabel.getText().equals("Sign Up")) {
                    signUpInPage.setYourName.sendKeys(userName);
                    signUpInPage.setYourEmail.sendKeys(email);
                    signUpInPage.setSignUpPassword.sendKeys(password);
                    signUpInPage.setRePassword.sendKeys(repassword);
                } else if (signUpInPage.SignInUpLabel.getText().equals("SIGN IN")) {
                    signUpInPage.setYourEmail.sendKeys(email);
                    signUpInPage.setSignInPassword.sendKeys(password);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + arg1);
        }


    }


    @Then("User should see the {string} message on {string}")
    public void userShouldSeeTheMessage(String arg0, String arg1) {
        WebElement actualMessage = null;
        switch (arg1) {
            case "Name":
                actualMessage = signUpInPage.nameMessage;
                break;
            case "email":
                if (signUpInPage.SignInUpLabel.getText().equals("Sign Up"))
                    actualMessage = signUpInPage.emailMessage;
                else if (signUpInPage.SignInUpLabel.getText().equals("SIGN IN"))
                    actualMessage = signUpInPage.nameMessage;
                break;
            case "password":
                if (signUpInPage.SignInUpLabel.getText().equals("Sign Up"))
                    actualMessage = signUpInPage.passwordMessage;
                else if (signUpInPage.SignInUpLabel.getText().equals("SIGN IN"))
                    actualMessage = signUpInPage.emailMessage;
                break;
            default:
                actualMessage = signUpInPage.repasswordMessage;
                break;
        }


        Assert.assertEquals(arg0, actualMessage.getText());


    }

    @Then("User should Sign Up or Sign In")
    public void userShouldSignUpOrSignIn() throws InterruptedException {
        if (signUpInPage.SignInUpLabel.getText().equals("Sign Up")) {
            Thread.sleep(4000);
            basePage.signIn.click();
            signUpInPage.setYourEmail.sendKeys(excelreads.readData(6, 1));
            signUpInPage.setSignInPassword.sendKeys(excelreads.readData(14, 2));
            clickSelecter.clicker("Sign UpIn button").click();
        }
        //clickSelecter.clicker("Sign UpIn button").click();

        Response response = apiSelecter.loginUser(excelreads.readData(6, 1), excelreads.readData(14, 2));
        JsonPath jsonPath = response.jsonPath();
        System.out.println(response.statusCode());
        Assert.assertEquals("success", jsonPath.getString("status"));

    }

    @When("User can switch to Sign In page")
    public void userCanSwitchToSignInPage() {
        basePage.signIn_UpExit.click();
        basePage.signIn.click();

    }

    @When("User can switch to Sign Up page")
    public void userCanSwitchToSignUpPage() {
        basePage.signIn_UpExit.click();
        basePage.signUp.click();

    }
}
