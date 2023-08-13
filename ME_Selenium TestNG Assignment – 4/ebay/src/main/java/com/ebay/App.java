package com.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class App {
    WebDriver driver;
    String product = "Apple Watches";

    public void setup(String browser) {
        if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
            driver = new FirefoxDriver();
        } else if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\ebay\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("IE")) {
            System.setProperty("webdriver.ie.driver", "path/to/iedriver");
            driver = new InternetExplorerDriver();
        } else if (browser.equals("Safari")) {
            driver = new SafariDriver();
        }
    }

    public void searchProduct() {
        driver.get("https://in.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys(product);
        driver.findElement(By.id("gh-cat")).click();
        driver.findElement(By.linkText("Electronics")).click();
        driver.findElement(By.id("gh-btn")).click();
    }

    public void printResult() {
        WebElement result = driver.findElement(By.className("srp-controls__count-heading"));
        System.out.println(result.getText());
    }

    public void printNthProduct(int n) {
        WebElement nthProduct = driver.findElements(By.xpath("//li[@class='s-item']")).get(n - 1);
        System.out.println(nthProduct.getText());
    }

    public void printAllProductsFromPage() {
        for (WebElement product : driver.findElements(By.xpath("//li[@class='s-item']"))) {
            System.out.println(product.getText());
        }
    }

    public void printAllProductsWithScrolling() {
        WebElement nextButton = driver.findElement(By.xpath("//button[@aria-label='Next page']"));
        while (nextButton.isEnabled()) {
            for (WebElement product : driver.findElements(By.xpath("//li[@class='s-item']"))) {
                System.out.println(product.getText());
            }
            nextButton.click();
        }
    }

    public void quit() {
        driver.quit();
    }
}