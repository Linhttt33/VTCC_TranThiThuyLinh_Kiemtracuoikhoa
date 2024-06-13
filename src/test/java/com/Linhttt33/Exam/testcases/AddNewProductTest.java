package com.Linhttt33.Exam.testcases;

import com.Linhttt33.Exam.pages.LoginPage;
import com.Linhttt33.Exam.pages.ProductListPage;
import com.Linhttt33.common.BaseTest;
import org.testng.annotations.Test;

public class AddNewProductTest extends BaseTest {

    LoginPage loginPage;
    ProductListPage productPage;

    @Test
    public void testAddNewProduct() {
        String PRODUCT_NAME = "Linhttt33";


        loginPage = new LoginPage();
        productPage = new ProductListPage();

        //Fluent design pattern
        loginPage.loginCRM("admin@example.com", "123456")
                .openAddNewProductPage()
                .verifyRedirectToProductPage()
                .addNewProduct(PRODUCT_NAME);
        productPage.verifyAddProduct(PRODUCT_NAME);
    }

}
