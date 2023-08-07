package com.yos.baseMethods;


import io.restassured.response.Response;


import static io.restassured.RestAssured.given;


public class ApiSelecter {

    public final String URL = "https://www.xn--tr-ys-mua.com/api/v1/";
    public final String TOKEN = "mBbAINPS8DwIL5J9isMwnEJGr4OgSkC55SCm2BqnVeJ8r1gxGFlrl8mFN7Q18GA9D/HsXeDS5arTZx6l974b31678f8f18db56809a16f9728baf";


    // Kullanıcının Login Olması

    public Response loginUser(String email, String password) {


        return given()

                .multiPart("email", email) // email bilgisini form-data olarak gönder
                .multiPart("password", password)
                .post(URL + "users/login.php?token=" + TOKEN);
    }

    // Kullanıcı ID'ye Göre Kullanıcı Bilgisini Getirme

    public Response getUserById(String userId) {

        return given()
                .param("id", userId)
                .param("token", TOKEN)
                .get(URL + "users/user.php");
    }

    // Kullanıcının Bilgilerini Güncelleme

    public Response updateUser(String userId, String name, String country, String city, String phone, String about) {


        return given()
                .multiPart("name", name)
                .multiPart("country", country)
                .multiPart("city", city)
                .multiPart("phone", phone)
                .multiPart("about", about)
                .post(URL + "users/updateuser.php" + "?user_id=" + userId + "&token=" + TOKEN);
    }

    // Yeni Kullanıcı Oluşturma

    public Response createNewUser(String name, String email, String password1, String password2) {


        return given()
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password1", password1)
                .multiPart("password2", password2)
                .post(URL + "users/newuser.php" + "?token=" + TOKEN);
    }

    // Tüm Kullanıcı Favori Listesi

    public Response getAllFavorites(String userId) {

        return given()
                .param("user_id", userId)
                .param("token", TOKEN)
                .get(URL + "users/allfavorites.php");
    }

    // Favori Ekleme

    public Response addFavorite(String departmentId, String userId) {

        return given()
                .param("id", departmentId)
                .param("user_id", userId)
                .param("token", TOKEN)
                .get(URL + "users/addfavorite.php");
    }

    // Favori Silme

    public Response deleteFavorite(String departmentId, String userId) {

        return given()
                .param("id", departmentId)
                .param("user_id", userId)
                .param("token", TOKEN)
                .get(URL + "users/deletefavorite.php");
    }

    // Tüm Kullanıcı Karşılaştırma Listesi

    public Response getAllCompares(String userId) {

        return given()
                .param("user_id", userId)
                .param("token", TOKEN)
                .get(URL + "users/allcompares.php");
    }

    // Karşılaştırma Ekleme

    public Response addCompare(String departmentId, String userId) {

        return given()
                .param("id", departmentId)
                .param("user_id", userId)
                .param("token", TOKEN)
                .get(URL + "users/addcompare.php");
    }

    // Karşılaştırma Silme

    public Response deleteCompare(String departmentId, String userId) {

        return given()
                .param("id", departmentId)
                .param("user_id", userId)
                .param("token", TOKEN)
                .get(URL + "users/deletecompare.php");
    }

    // Tüm Bölümleri Getirme

    public Response getAllDepartments() {

        return given()
                .param("token", TOKEN)
                .get(URL + "record/alldepartments.php");
    }

    // Bölüm ID'sine Göre Bölümü Getirme

    public Response getDepartmentById(String departmentId) {

        return given()
                .param("id", departmentId)
                .param("token", TOKEN)
                .get(URL + "record/department.php");
    }

    // Üniversite Koduna göre Tüm Bölümleri Getirme

    public Response getDepartmentsByUniversityCode(String universityCode) {

        return given()
                .param("uni_code", universityCode)
                .param("token", TOKEN)
                .get(URL + "record/departmentsbyuni.php");
    }

    // Tüm Slider Bilgilerini Getirme

    public Response getAllSliders() {

        return given()
                .param("token", TOKEN)
                .get(URL + "record/sliders.php");
    }

    // Email Ekleme

    public Response addEmail(String email) {

        return given()
                .multiPart("email", email)
                .post(URL + "record/addemail.php?token=" + TOKEN);
    }

    public Response getAllCities() {

        return given()
                .queryParam("token", TOKEN)
                .get(URL + "location/allcities.php");
    }

    // Şehir ID'sine Göre Şehir Getirme

    public Response getCityById(String cityId) {

        return given()
                .param("id", cityId)
                .param("token", TOKEN)
                .get(URL + "location/city.php");
    }

    // Tüm İlçeleri Getirme

    public Response getAllDistricts() {

        return given()
                .param("token", TOKEN)
                .get(URL + "location/alldistricts.php");
    }

    // İlçe ID'sine Göre İlçe Getirme

    public Response getDistrictById(String districtId) {

        return given()
                .param("id", districtId)
                .param("token", TOKEN)
                .get(URL + "location/district.php");
    }

    // Şehrin İlçelerini Getirme

    public Response getDistrictsByCityId(String cityId) {

        return given()
                .param("city_id", cityId)
                .param("token", TOKEN)
                .get(URL + "location/districtsbycity.php");
    }

    // Tüm Üniversiteleri Getirme

    public Response getAllUniversities() {

        return given()
                .param("token", TOKEN)
                .get(URL + "education/alluniversities.php");
    }

    // Üniversite ID'sine Göre Üniversite Getirme

    public Response getUniversityById(String universityId) {

        return given()
                .param("id", universityId)
                .param("token", TOKEN)
                .get(URL + "education/university.php");
    }

    // Tüm Fakülteleri Getirme

    public Response getAllFaculties() {

        return given()
                .param("token", TOKEN)
                .get(URL + "education/allfaculties.php");
    }

    // Fakülte ID'sine Göre Fakülte Getirme

    public Response getFacultyById(String facultyId) {

        return given()
                .param("id", facultyId)
                .param("token", TOKEN)
                .get(URL + "education/faculty.php");
    }

    // Tüm Bölümleri Getirme

    public Response getAllDepartmentsEducation() {

        return given()
                .param("token", TOKEN)
                .get(URL + "education/alldepartmentsname.php");
    }

    // Bölüm ID'sine Göre Bölüm Getirme

    public Response getDepartmentByIdEducation(String departmentId) {

        return given()
                .param("id", departmentId)
                .param("token", TOKEN)
                .get(URL + "education/departmentname.php");
    }


}

