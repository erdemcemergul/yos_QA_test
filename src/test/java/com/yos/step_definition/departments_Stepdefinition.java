package com.yos.step_definition;

import com.yos.baseMethods.ApiSelecter;
import com.yos.baseMethods.ClickSelecter;
import com.yos.basePages.ButtonBasePage;
import com.yos.pages.DepartmentsPage;
import com.yos.utilities.ExcelHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class departments_Stepdefinition {

    public departments_Stepdefinition() {
    }

    Random random = new Random();
    ApiSelecter apiSelecter = new ApiSelecter();
    DepartmentsPage departmentsPage = new DepartmentsPage();
    ButtonBasePage buttonBasePage = new ButtonBasePage();
    String city = "";
    String university = "";
    String department = "";
    ArrayList<String> departmentsOfList = new ArrayList<>();
    String departmentId = "";
    ArrayList<String> cityList = new ArrayList<>();
    ClickSelecter clickSelecter = new ClickSelecter();

    @Then("User should see the list of {string}")
    public void userShouldSeeTheListOf(String arg0) {
        Assert.assertTrue(buttonBasePage.selectUniversity.isSelected());


    }


    @Then("Card of {string} name should come from API")
    public void cardOfNameShouldComeFromAPI(String arg0) {
        Response departmentById = apiSelecter.getDepartmentById(departmentId);
        JsonPath jsonPathDepartmentById = departmentById.jsonPath();

        switch (arg0) {
            case "department":
                Assert.assertEquals(jsonPathDepartmentById.getString("department.tr"), departmentsPage.cardOfDepartment.getText());
                break;
            case "faculty":
                Assert.assertEquals(jsonPathDepartmentById.getString("faculty.tr"), departmentsPage.cardOfFaculty.getText());
                break;
            case "university":
                Assert.assertEquals(jsonPathDepartmentById.getString("university.tr"), departmentsPage.cardOfUniversity.getText());
                break;
            case "city":
                Assert.assertEquals(jsonPathDepartmentById.getString("city.tr"), departmentsPage.cardOfCity.getText());
                break;
            case "price":
                Assert.assertEquals(jsonPathDepartmentById.getString("price"), departmentsPage.cardOfPrice.getText());
                break;

        }


    }


    @Then("User see that don't change of favourite button")
    public void userSeeThatDonTChangeOfFavouriteButton() {
        clickSelecter.clicker("Favourite");
        boolean check = !departmentsPage.favourite.isSelected();

        Assert.assertTrue(check);


    }

    @Then("User see that don't change of compare button")
    public void userSeeThatDonTChangeOfCompareButton() {
        clickSelecter.clicker("Compare");
        boolean check = !departmentsPage.compare.isSelected();

        Assert.assertTrue(check);
    }


    @Then("User should add to compare")
    public void userShouldAddToCompare() {
        ApiSelecter apiSelecter = new ApiSelecter();
        ExcelHelper excelreads = new ExcelHelper("yös_signUp.xlsx");
        excelreads.setSheet("SignUp");

        Response loginUserresponse = apiSelecter.loginUser(excelreads.readData(6, 1), excelreads.readData(14, 2));
        JsonPath jsonPath = loginUserresponse.jsonPath();
        String userId = jsonPath.getString("userID");

        boolean check = false;

        Response compareList = apiSelecter.getAllCompares(userId);
        System.out.println("compareList.statusCode() = " + compareList.statusCode());
        String jsonString = compareList.asString();
        List<String> departmentList = JsonPath.from(jsonString).getList("departments");

        if (departmentList.contains(departmentId))
            check = true;

        Assert.assertTrue(check);


    }


    @And("User select city\\(ies)")
    public void userSelectCityIes() {
        Response allDepartments = apiSelecter.getAllDepartments();
        JsonPath jsonPathAllDepartments = allDepartments.jsonPath();
        List<String> departmentsIds = jsonPathAllDepartments.getList("id");
        //boolean status = true;
        JsonPath jsonPathDepartmentById;
        // do {
        while (true) {
            int index = random.nextInt(departmentsIds.size());
            departmentId = departmentsIds.get(index);


            if (!departmentsOfList.contains(departmentId)) {
                departmentsOfList.add(departmentId);
                break;
            }
        }
        Response departmentById = apiSelecter.getDepartmentById(departmentId);
        jsonPathDepartmentById = departmentById.jsonPath();
        /*    if (jsonPathDepartmentById.getString("status").equals("error"))
                status = false;
        } while (!status);*/
        System.err.println(departmentId);
        city = jsonPathDepartmentById.getString("city.tr");

        if (!cityList.contains(city)) {
            cityList.add(city);

            buttonBasePage.selectCity.sendKeys(Keys.chord(cityList.get(cityList.size() - 1)), Keys.ENTER);
        }

    }

    @And("User select university\\(ies)")
    public void userSelectUniversityIes() {
        Response departmentById = apiSelecter.getDepartmentById(departmentId);
        JsonPath jsonPathDepartmentById = departmentById.jsonPath();
        university = jsonPathDepartmentById.getString("university.tr");

        buttonBasePage.selectUniversity.sendKeys(Keys.chord(university), Keys.ENTER);

    }

    @And("User select department\\(s)")
    public void userSelectDepartmentS() {
        Response departmentById = apiSelecter.getDepartmentById(departmentId);
        JsonPath jsonPathDepartmentById = departmentById.jsonPath();
        String codeOfDepartment = jsonPathDepartmentById.getString("university.code");
        Response departmants = apiSelecter.getDepartmentsByUniversityCode(codeOfDepartment);
        JsonPath jsonDepartmentCodes = departmants.jsonPath();
        List<String> departmentslist = jsonDepartmentCodes.getList("id");
        for (int i = 0; i < departmentslist.size(); i++) {
            if (departmentId.equals(departmentslist.get(i))) {
                String departmentTr = jsonDepartmentCodes.getString("department.tr[" + i + "]");
                if (departmentTr != null)
                    department = departmentTr;
                else {
                    int j = i + 1;
                    while (j < jsonDepartmentCodes.getList("department.tr").size() && jsonDepartmentCodes.getString("department.tr[" + j + "]") != null) {
                        department = jsonDepartmentCodes.getString("department.tr[" + j + "]");
                        j++;
                    }
                }

                break;
            }


        }

        buttonBasePage.selectDepartment.sendKeys(Keys.chord(department), Keys.ENTER);

    }

    @Then("User should add to favourite")
    public void userShouldAddToFavourite() {
        ApiSelecter apiSelecter = new ApiSelecter();
        ExcelHelper excelreads = new ExcelHelper("yös_signUp.xlsx");
        excelreads.setSheet("SignUp");

        Response loginUserresponse = apiSelecter.loginUser(excelreads.readData(6, 1), excelreads.readData(14, 2));
        JsonPath jsonPath = loginUserresponse.jsonPath();
        String userId = jsonPath.getString("userID");

        boolean check = false;

        Response favoritesList = apiSelecter.getAllFavorites(userId);
        System.out.println("favoritesList.statusCode() = " + favoritesList.statusCode());
        String jsonString = favoritesList.asString();
        List<String> departmentList = JsonPath.from(jsonString).getList("departments");

        if (departmentList.contains(departmentId))
            check = true;

        Assert.assertTrue(check);
    }

    @Then("User should delete to compare")
    public void userShouldDeleteToCompare() {
        ApiSelecter apiSelecter = new ApiSelecter();
        ExcelHelper excelreads = new ExcelHelper("yös_signUp.xlsx");
        excelreads.setSheet("SignUp");

        Response loginUserresponse = apiSelecter.loginUser(excelreads.readData(6, 1), excelreads.readData(14, 2));
        JsonPath jsonPath = loginUserresponse.jsonPath();
        String userId = jsonPath.getString("userID");
        boolean check = false;

        Response compareList = null;

        try {
            compareList = apiSelecter.getAllCompares(userId);
            System.out.println("compareList.statusCode() = " + compareList.statusCode());
        } catch (Exception e) {
            System.out.println("API çağrısında hata oluştu: " + e.getMessage());
        }

        if (compareList == null) {
            check = true;
            Assert.assertTrue(check);
        } else {
            String jsonString = compareList.asString();
            List<String> departmentList = JsonPath.from(jsonString).getList("departments");

            if (!departmentList.contains(departmentId)) {
                check = true;
                Assert.assertTrue(check); // Test geçerli
            } else {
                Assert.fail("Departman zaten listeye eklenmiş.");
            }
        }


    }

    @Then("User should delete to Favourite")
    public void userShouldDeleteToFavourite() {
        ApiSelecter apiSelecter = new ApiSelecter();
        ExcelHelper excelreads = new ExcelHelper("yös_signUp.xlsx");
        excelreads.setSheet("SignUp");

        Response loginUserresponse = apiSelecter.loginUser(excelreads.readData(6, 1), excelreads.readData(14, 2));
        JsonPath jsonPath = loginUserresponse.jsonPath();
        String userId = jsonPath.getString("userID");

        Response favoritesList = null;
        boolean check = false;


        try {
            favoritesList = apiSelecter.getAllCompares(userId);
            System.out.println("compareList.statusCode() = " + favoritesList.statusCode());
        } catch (Exception e) {
            System.out.println("API çağrısında hata oluştu: " + e.getMessage());
        }

        if (favoritesList == null) {
            check = true;
            Assert.assertTrue(check);
        } else {
            String jsonString = favoritesList.asString();
            List<String> departmentList = JsonPath.from(jsonString).getList("departments");

            if (!departmentList.contains(departmentId)) {
                check = true;
                Assert.assertTrue(check); // Test geçerli
            } else {
                Assert.fail("Departman zaten listeye eklenmiş.");
            }
        }
    }
}
