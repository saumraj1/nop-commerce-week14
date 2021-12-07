package com.nopcommerce.testsuite;

import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.LoginPage;
import com.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(groups = {"smoke","sanity", "regression"})
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully(){
        homePage.clickOnLoginLink();
        loginPage.verifyWelcomeMessage();

    }
    @Test(groups = {"sanity", "regression"})
    @Parameters({"email","password"})
    public void verifyTheErrorMessageWithInValidCredentials(String email,String password ){
        homePage.clickOnLoginLink();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        loginPage.verifyErrorMessage();

    }
    @Test(groups = {"sanity", "regression"})
    @Parameters({"email1","password1"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials( String email1,String password1){
        homePage.clickOnLoginLink();
        loginPage.enterEmail(email1);
        loginPage.enterPassword(password1);
        loginPage.clickOnLoginButton();
        loginPage.verifyLogOutOption();
    }
    @Test(groups = {"regression"})
    @Parameters({"email1","password1"})
    public void VerifyThatUserShouldLogOutSuccessFully(String email1,String password1){

        homePage.clickOnLoginLink();
        loginPage.enterEmail(email1);
        loginPage.enterPassword(password1);
        loginPage.clickOnLoginButton();
        loginPage.clickOnLogOutButton();
        loginPage.verifyLoginOption();
    }





}
