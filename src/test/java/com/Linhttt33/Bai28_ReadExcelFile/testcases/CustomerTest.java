package com.Linhttt33.Bai28_ReadExcelFile.testcases;

import com.Linhttt33.Bai28_ReadExcelFile.pages.LoginPage;
import com.Linhttt33.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testAddNewCustomer() {
        String CUSTOMER_NAME = "Viettel AI";

        loginPage = new LoginPage();

        //Fluent design pattern
        loginPage.loginCRM("admin@example.com", "123456")
                .openCustomerPage()
                .verifyRedirectToCustomerPage()
                .addNewCustomer(CUSTOMER_NAME)
                .verifyAddNewCustomer(CUSTOMER_NAME);
    }
}
