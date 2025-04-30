package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SeleniumTest {

    public static void main(String[] args) {
        //region Initalize drivers and waits
        WebDriver driver = new ChromeDriver();
        WebDriver driver2 = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverWait wait2 = new WebDriverWait(driver2, Duration.ofSeconds(10));
        //endregion
        //region Navigate to website check whether we reached
        driver.get("https://dijital.gib.gov.tr/");
        driver2.get("https://dijital.gib.gov.tr/");

        String title = driver.getTitle();
        String title2 = driver2.getTitle();

        if (title.equals("Dijital Vergi Dairesi")) {
            System.out.println("Google Chrome girdi : Dijital Vergi Dairesi");
        } else {
            System.out.println("Yanlış site");
        }

        if (title2.equals("Dijital Vergi Dairesi")) {
            System.out.println("Firefox girdi : Dijital Vergi Dairesi");
        } else {
            System.out.println("Yanlış site");
        }
        //endregion
        //region Find the searchbox and send keys
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBox")));
        WebElement searchBox2 = wait2.until(ExpectedConditions.elementToBeClickable(By.id("searchBox")));
        searchBox.sendKeys("Pasaport Bedeli");
        searchBox2.sendKeys("Pasaport Bedeli");
        //endregion
        //region Get currently opened windows
        Set<String> oldWindowsSet = driver.getWindowHandles();
        Set<String> oldWindowsSet2 = driver2.getWindowHandles();
        //endregion
        //region Find item in search list that we wanted
        WebElement searchedListItem = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Pasaport Değerli Kâğıt Bedeli Ödeme")));
        WebElement searchedListItem2 = wait2.until(ExpectedConditions.elementToBeClickable(By.linkText("Pasaport Değerli Kâğıt Bedeli Ödeme")));

        searchedListItem.click();
        searchedListItem2.click();
        //endregion
        //region Change tab to newly opened one
        // Chrome: Focus other tab
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfWindowsToBe(oldWindowsSet.size() + 1));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!oldWindowsSet.contains(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Firefox: Focus other tab
        new WebDriverWait(driver2, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfWindowsToBe(oldWindowsSet2.size() + 1));
        for (String windowHandle2 : driver2.getWindowHandles()) {
            if (!oldWindowsSet2.contains(windowHandle2)) {
                driver2.switchTo().window(windowHandle2);  // ← düzeltilmiş kısım
                break;
            }
        }
        //endregion
        //region Fill the form
        WebElement tcknBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("tckn")));
        WebElement tcknBox2 = wait2.until(ExpectedConditions.elementToBeClickable(By.id("tckn")));

        tcknBox.sendKeys("12345678910");
        tcknBox2.sendKeys("12345678910");

        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.name("ad")));
        WebElement name2 = wait2.until(ExpectedConditions.elementToBeClickable(By.name("ad")));

        WebElement surname = wait.until(ExpectedConditions.elementToBeClickable(By.name("soyad")));
        WebElement surname2 = wait2.until(ExpectedConditions.elementToBeClickable(By.name("soyad")));

        name.sendKeys("Utku - Melis - Furkan");
        name2.sendKeys("Utku - Melis - Furkan");

        surname.sendKeys("Antalya Bilim Üniversitesi");
        surname2.sendKeys("Antalya Bilim Üniversitesi");


        WebElement cities = wait.until(ExpectedConditions.elementToBeClickable(By.id("il")));
        WebElement cities2 = wait2.until(ExpectedConditions.elementToBeClickable(By.id("il")));
        cities.click();
        WebElement antalyaOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(), 'Antalya')]")));  // first option that contains Antalya
        antalyaOption.click();
        cities2.click();
        WebElement antalyaOption2 = wait2.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(), 'Antalya')]")));  // first option that contains Antalya
        antalyaOption2.click();


        WebElement vergiDairesi = wait.until(ExpectedConditions.elementToBeClickable(By.id("vergiDairesi")));
        WebElement vergiDairesi2 = wait2.until(ExpectedConditions.elementToBeClickable(By.id("vergiDairesi")));
        vergiDairesi.click();
        WebElement muratpasaOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'MURATPAŞA')]")));  // first option that contains MURATPAŞA
        muratpasaOption.click();
        vergiDairesi2.click();
        WebElement muratpasaOption2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'MURATPAŞA')]")));  // first option that contains MURATPAŞA
        muratpasaOption2.click();
        //endregion
        //region Submit form
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        WebElement submit2 = wait2.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        submit.click();
        submit2.click();
        //endregion
    }
}
