package com.yos.baseMethods;

import com.yos.basePages.ButtonBasePage;
import com.yos.pages.AccountPage;
import com.yos.pages.DepartmentsPage;
import com.yos.pages.HomePage;
import com.yos.pages.UniversitiesPage;
import com.yos.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ClickSelecter {
    public ClickSelecter() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    AccountPage accountPage = new AccountPage();
    ButtonBasePage basePage = new ButtonBasePage();
    DepartmentsPage departmentsPage = new DepartmentsPage();
    UniversitiesPage universitiesPage = new UniversitiesPage();
    HomePage homePage = new HomePage();

    public WebElement clicker(String arg) {

        WebElement yourmodule = null;
        switch (arg) {
            case "UserMenu":
                yourmodule = accountPage.userMenuButton;
                break;
            case "MyProfile":
                yourmodule = accountPage.myProfileMenu;
                break;
            case "Compare Departments":
                yourmodule = accountPage.myCompareDepartments;
                break;
            case "Favourite Departments":
                yourmodule = accountPage.myFavouriteDepartments;
                break;
            case "Departments":
                yourmodule = basePage.departments;
                break;
            case "Home":
                yourmodule = basePage.home;
                break;
            case "Universities":
                yourmodule = basePage.universities;
                break;
            case "Search":
                yourmodule = basePage.searchButton;
                break;
            case "Subscribe":
                yourmodule = basePage.subscribe;
                break;
            case "Sign In":
                yourmodule = basePage.signIn;
                break;
            case "Sign Up":
                yourmodule = basePage.signUp;
                break;
            case "Save":
                yourmodule = basePage.save;
                break;
            case "Sign UpIn button":
                yourmodule = basePage.signIn_UpButton;
                break;
            case "Change Password":
                yourmodule = accountPage.changePasswordButton;
                break;
            case "Compare":
                yourmodule = departmentsPage.compare;
                break;
            case "Compared":
                yourmodule = departmentsPage.compared;
                break;
            case "Favourite":
                yourmodule = departmentsPage.favourite;
                break;
            case "Log Out":
                yourmodule = departmentsPage.logOut;
                break;
            case "Continue":
                yourmodule = universitiesPage.forContinue;
                break;
            case "myProfile":
                yourmodule = homePage.myProfile;
                break;
            case "myFavourite":
                yourmodule = homePage.favorites;
                break;
            case "About Us":
                yourmodule = homePage.aboutUs;
                break;
            case "FAQs page":
                yourmodule = homePage.faqsPage;
                break;
            case "Checkout":
                yourmodule = homePage.checkout;
                break;
            case "Contact":
                yourmodule = homePage.contact;
                break;
            case "Blog":
                yourmodule = homePage.blog;
                break;

        }

        return yourmodule;
    }


}
