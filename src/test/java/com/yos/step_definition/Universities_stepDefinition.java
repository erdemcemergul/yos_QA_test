package com.yos.step_definition;

import com.yos.baseMethods.ApiSelecter;
import com.yos.pages.UniversitiesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class Universities_stepDefinition {
    ApiSelecter apiSelecter = new ApiSelecter();
    UniversitiesPage universitiesPage = new UniversitiesPage();
    String facultyNumber = "";
    String adress = "";
    String phone = "";
    String departmentNumber = "";
    String name = "";
    String city = "";
    String logo = "";


    @When("User see the city information")
    public void userSeeTheCityInformation() {
        facultyNumber = universitiesPage.unicersityCardCity.getText();
    }

    @And("User see the name information")
    public void userSeeTheNameInformation() {
        name = universitiesPage.unicersityCardName.getText();
    }

    @When("User see the phone information")
    public void user_see_the_phone_information() {
        phone = universitiesPage.unicersityCardPhone.getText();

    }


    @And("User see the department information")
    public void userSeeTheDepartmentInformation() {
        departmentNumber = universitiesPage.unicersityCardDepartments.getText();
    }


    @Then("Information should be same with API from documentation for English")
    public void informationShouldBeSameWithAPIFromDocumentationForEnglish() {
        Response response = apiSelecter.getUniversityById("1687189250711");
        JsonPath jsonPathUniversity = response.jsonPath();
        Response response1 = apiSelecter.getDepartmentsByUniversityCode("1065");
        JsonPath jsonPathUniversityCode = response1.jsonPath();
        String number = Integer.toString(jsonPathUniversityCode.getList("department").size());
        Assert.assertEquals(jsonPathUniversity.getString("data.phone"), phone);
        Assert.assertEquals(jsonPathUniversity.getString("en"), name);
        Assert.assertEquals(number, (departmentNumber + "Department"));
        Assert.assertEquals(jsonPathUniversityCode.getString("city.en[1]"), city);


    }

    @Then("Information should be same with API from documentation for Turkish")
    public void informationShouldBeSameWithAPIFromDocumentationForTurkish() {
        Response response = apiSelecter.getUniversityById("1687189250711");
        JsonPath jsonPathUniversity = response.jsonPath();
        Response response1 = apiSelecter.getDepartmentsByUniversityCode("1065");
        JsonPath jsonPathUniversityCode = response1.jsonPath();
        String number = Integer.toString(jsonPathUniversityCode.getList("department").size());
        Assert.assertEquals(jsonPathUniversity.getString("data.phone"), phone);
        Assert.assertEquals(jsonPathUniversity.getString("data.adress"), adress);
        //Assert.assertEquals(jsonPathUniversity.getString("logo"),logo);
        Assert.assertEquals(jsonPathUniversity.getString("tr"), name);
        Assert.assertEquals(number, departmentNumber);
    }

    @When("User see the logo information")
    public void userSeeTheLogoInformation() {
        logo = universitiesPage.unicersityCardLogo.getAttribute("src");
    }

    @And("User see the adress information")
    public void userSeeTheAdressInformation() {
        adress = universitiesPage.unicersityCardAdress.getText();
    }
}
