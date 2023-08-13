package com.ebay;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class AppTest {
    App app = new App();

    @BeforeMethod
    @Parameters("Chrome")
    public void setup(String browser) {
        app.setup(browser);
    }

    @Test
    public void searchAndPrintResultTest() {
        app.searchProduct();
        app.printResult();
    }

    @Test
    public void searchAndPrintNthProductTest() {
        app.searchProduct();
        app.printNthProduct(10);
    }

    @Test
    public void searchAndPrintAllProductsFromPageTest() {
        app.searchProduct();
        app.printAllProductsFromPage();
    }

    @Test
    public void searchAndPrintAllProductsWithScrollingTest() {
        app.searchProduct();
        app.printAllProductsWithScrolling();
    }

    @AfterMethod
    public void quit() {
        app.quit();
    }
}
