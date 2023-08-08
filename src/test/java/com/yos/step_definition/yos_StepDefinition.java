package com.yos.step_definition;

import com.yos.baseMethods.ApiSelecter;
import com.yos.baseMethods.ClickSelecter;
import com.yos.baseMethods.FakeNameCreater;
import com.yos.baseMethods.FakePasswordCreater;
import com.yos.basePages.ButtonBasePage;
import com.yos.basePages.yosLogin;
import com.yos.pages.HomePage;
import com.yos.utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;


public class yos_StepDefinition {
    Random random = new Random();
    ClickSelecter clickSelecter = new ClickSelecter();
    yosLogin login = new yosLogin();
    ApiSelecter apiSelecter = new ApiSelecter();
    ButtonBasePage buttonBasePage = new ButtonBasePage();

    HomePage homePage = new HomePage();

    public int value;


    @Given("User is on the app")
    public void userIsOnTheApp() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("yos.url"));
        Thread.sleep(1500);

    }


    @Given("User is already logged in.")
    public void userIsAlreadyLoggedIn() throws InterruptedException {
        Thread.sleep(2000);
        login.login();
        Thread.sleep(4500);
    }

    @Given("Sign Up datas are created random")
    public static void signUpDatasAreCreatedRandom() throws InterruptedException {

        ExcelHelper excelHelper = new ExcelHelper("yös_signUp.xlsx");
        excelHelper.setSheet("SignUp");
        excelHelper.clearData(1, 23, 0, 3);
        int[] charcount = {0, 11, 8, 0, 8, 8, 0, 5, 15, 15, 15, 15, 25, 15, 0, 5, 15, 15, 15, 15, 25, 15, 15};
        for (int i = 0; i < 3; i++) {
            String fakename = "";
            if (charcount[i] < 2) {
                fakename = "";
                excelHelper.writeData(fakename, i + 1, 0);
                continue;
            }
            fakename = FakeNameCreater.fakerName(charcount[i]);
            excelHelper.writeData(fakename, i + 1, 0);
        }
        for (int i = 3; i < 6; i++) {
            String fakemail = "";
            if (charcount[i] < 2) {
                fakemail = "";
                excelHelper.writeData(fakemail, i + 1, 1);
                continue;
            }
            fakemail = FakeNameCreater.fakerName(charcount[i]);
            if (i == 5) {
                fakemail = (fakemail + "@mail.com");
                excelHelper.writeData(fakemail, i + 1, 1);
            } else excelHelper.writeData(fakemail, i + 1, 1);

        }
        for (int i = 6; i < 13; i++) {
            String pswrd = "";
            if (charcount[i] < 2) {
                pswrd = "";
                excelHelper.writeData(pswrd, i + 1, 2);
                continue;
            }
            pswrd = FakePasswordCreater.generateText(false, false, false, true, 2, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 2);
            i++;
            Thread.sleep(250);
            pswrd = "a" + FakePasswordCreater.generateText(false, false, false, true, 8, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 2);
            i++;
            Thread.sleep(250);
            pswrd = "1A," + FakePasswordCreater.generateText(true, true, true, false, 8, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 2);
            i++;
            Thread.sleep(250);
            pswrd = "1a" + FakePasswordCreater.generateText(true, true, false, true, 8, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 2);
            i++;
            Thread.sleep(250);
            pswrd = "1Aa" + FakePasswordCreater.generateText(false, true, true, true, 8, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 2);
            i++;
            Thread.sleep(250);
            pswrd = FakePasswordCreater.generateText(true, true, true, true, 21, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 2);
            i++;
            if (i >= 13) break;
        }
        Thread.sleep(450);
        String pswrd = "1,Aa" + FakePasswordCreater.generateText(true, true, true, true, 8, charcount[13]);
        excelHelper.writeData(pswrd, 14, 2);
        excelHelper.writeData(pswrd, charcount.length, 3);
        for (int i = 14; i < charcount.length - 1; i++) {
            if (charcount[i] < 2) {
                pswrd = "";
                excelHelper.writeData(pswrd, i + 1, 3);
                continue;
            }

            pswrd = FakePasswordCreater.generateText(false, false, false, true, 2, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 3);
            i++;
            Thread.sleep(250);
            pswrd = "a" + FakePasswordCreater.generateText(false, false, false, true, 8, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 3);
            i++;
            Thread.sleep(250);
            pswrd = "1A," + FakePasswordCreater.generateText(true, true, true, false, 8, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 3);
            i++;
            Thread.sleep(250);
            pswrd = "1a" + FakePasswordCreater.generateText(false, true, false, true, 8, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 3);
            i++;
            Thread.sleep(250);
            pswrd = "1aA" + FakePasswordCreater.generateText(false, true, true, true, 8, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 3);
            i++;
            Thread.sleep(250);
            pswrd = FakePasswordCreater.generateText(true, true, true, true, 21, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 3);
            i++;
            Thread.sleep(250);
            pswrd = "1,Aa" + FakePasswordCreater.generateText(true, true, true, true, 8, charcount[i]);
            excelHelper.writeData(pswrd, i + 1, 3);
            i++;
            if (i >= 22) break;
        }
        excelHelper.save();
        excelHelper.close();


    }


    @When("User click {string} button")
    public void user_click_button(String string) {
        clickSelecter.clicker(string).click();

    }


    @Then("Status should be {int}")
    public void status_should_be(int int1) throws InterruptedException {
        ExcelHelper excelreads = new ExcelHelper("yös_signUp.xlsx");
        excelreads.setSheet("SignUp");
        Thread.sleep(3000);
        //ilgili userID bulma
        Response loginUserresponse = apiSelecter.loginUser(excelreads.readData(6, 1), excelreads.readData(14, 2));
        String jsonResponse = loginUserresponse.asString();
        JsonPath jsonPathuser = new JsonPath(jsonResponse);
        String userID = jsonPathuser.getString("userID");
        //random departmentResponse oluşturmak ve idsini almak
        Response departmentResponse = apiSelecter.getAllDepartments();
        String jsonResponsedep = departmentResponse.asString();
        JsonPath jsonPathdepartment = new JsonPath(jsonResponsedep);
        int result = jsonPathdepartment.getList("id").size();//kaç departmant var
        int randomdepartmentIndex = random.nextInt(result);//herhangi birini seçmek için
        String departmentId = jsonPathdepartment.getString("id[" + randomdepartmentIndex + "]");
        //CRUD için
        String fakeName = ("" + excelreads.readData(2, 0));
        String fakePass = ("" + excelreads.readData(22, 3));
        String fakeEmail = ("" + excelreads.readData(5, 1) + "@email.com");
        //random cityResponse oluşturmak ve idsini almak
        Response cityResponse = apiSelecter.getAllCities();
        String jsonResponsecity = cityResponse.asString();
        JsonPath jsonPathcity = new JsonPath(jsonResponsecity);
        result = jsonPathcity.getList("id").size();//kaç city var
        int randomcityIndex = random.nextInt(result);//herhangi birini seçmek için
        String cityId = jsonPathcity.getString("id[" + randomcityIndex + "]");
        //random districtResponse oluşturmak ve idsini almak
        Response districtResponse = apiSelecter.getAllDistricts();
        String jsonResponsedistrict = districtResponse.asString();
        JsonPath jsonPathdistrict = new JsonPath(jsonResponsedistrict);
        result = jsonPathdistrict.getList("id").size();//kaç district var
        int randomdistrictIndex = random.nextInt(result);//herhangi birini seçmek için
        String districtId = jsonPathdistrict.getString("id[" + randomdistrictIndex + "]");
        String districtcityId = jsonPathdistrict.getString("cityID[" + randomdistrictIndex + "]");
        //random universityResponse oluşturmak ve idsini almak
        Response universityResponse = apiSelecter.getAllUniversities();
        String jsonResponseuniversity = universityResponse.asString();
        JsonPath jsonPathuniversity = new JsonPath(jsonResponseuniversity);
        result = jsonPathuniversity.getList("id").size();//kaç university var
        int randomuniversityIndex = random.nextInt(result);//herhangi birini seçmek için
        String universityId = jsonPathuniversity.getString("id[" + randomuniversityIndex + "]");
        //random facultyResponse oluşturmak ve idsini almak
        Response facultyResponse = apiSelecter.getAllFaculties();
        String jsonResponsefaculty = facultyResponse.asString();
        JsonPath jsonPathfaculty = new JsonPath(jsonResponsefaculty);
        result = jsonPathfaculty.getList("id").size();//kaç faculty var
        int randomfacultyIndex = random.nextInt(result);//herhangi birini seçmek için
        String facultyId = jsonPathfaculty.getString("id[" + randomfacultyIndex + "]");
        //random departmentsnameResponse oluşturmak ve idsini almak
        Response departmentsnameResponse = apiSelecter.getAllDepartmentsEducation();
        String jsonResponsedepartmentsname = departmentsnameResponse.asString();
        JsonPath jsonPathdepartmentsname = new JsonPath(jsonResponsedepartmentsname);
        result = jsonPathdepartmentsname.getList("id").size();//kaç departmentsname var
        int randomdepartmentsnameIndex = random.nextInt(result);//herhangi birini seçmek için
        String departmentsnameId = jsonPathdepartmentsname.getString("id[" + randomdepartmentsnameIndex + "]");


        assertEquals(int1, universityResponse.statusCode());
        assertEquals(int1, cityResponse.statusCode());
        assertEquals(int1, departmentResponse.statusCode());
        assertEquals(int1, loginUserresponse.statusCode());
        assertEquals(int1, districtResponse.statusCode());
        assertEquals(int1, facultyResponse.statusCode());
        assertEquals(int1, departmentsnameResponse.statusCode());
        assertEquals(int1, apiSelecter.getUserById(userID).statusCode());
        assertEquals(int1, apiSelecter.updateUser(userID, excelreads.readData(3, 0), excelreads.readData(5, 1), "Istanbul", "555552222", "about").statusCode());
        // assertEquals(int1, apiSelecter.createNewUser(fakeName.substring(0, fakeName.indexOf(" ")), fakeEmail, fakePass, fakePass).statusCode());
        assertEquals(int1, apiSelecter.addFavorite(departmentId, userID).statusCode());
        assertEquals(int1, apiSelecter.getAllFavorites(userID).statusCode());
        assertEquals(int1, apiSelecter.deleteFavorite(departmentId, userID).statusCode());
        assertEquals(int1, apiSelecter.addCompare(departmentId, userID).statusCode());
        assertEquals(int1, apiSelecter.getAllCompares(userID).statusCode());
        assertEquals(int1, apiSelecter.deleteCompare(departmentId, userID).statusCode());
        assertEquals(int1, apiSelecter.getDepartmentById(departmentId).statusCode());
        assertEquals(int1, apiSelecter.getDepartmentsByUniversityCode(jsonPathdepartment.getString("university.code[" + randomdepartmentIndex + "]")).statusCode());
        assertEquals(int1, apiSelecter.getAllSliders().statusCode());
        assertEquals(int1, apiSelecter.addEmail(("jaga" + fakeEmail)).statusCode());
        assertEquals(int1, apiSelecter.getCityById(cityId).statusCode());
        assertEquals(int1, apiSelecter.getDistrictById(districtId).statusCode());
        assertEquals(int1, apiSelecter.getDistrictsByCityId(districtcityId).statusCode());
        assertEquals(int1, apiSelecter.getUniversityById(universityId).statusCode());
        assertEquals(int1, apiSelecter.getFacultyById(facultyId).statusCode());
        assertEquals(int1, apiSelecter.getDepartmentByIdEducation(departmentsnameId).statusCode());


    }


    @Then("User should see Turkish webpage")
    public void userShouldSeeTurkishWebpage() {
        Assert.assertEquals(homePage.homeText.getText(), "Ana Sayfa");


    }

    @Then("User should see English webpage")
    public void userShouldSeeEnglishWebpage() {

        Assert.assertEquals(homePage.homeText.getText(), "Home");
    }


}
