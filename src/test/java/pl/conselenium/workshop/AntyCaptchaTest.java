package pl.conselenium.workshop;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AntyCaptchaTest {
    Logger log = LoggerFactory.getLogger(LogTest.class);

    @Test(groups = "smoke")
    public void antyCaptchaPageTest() throws IOException {
        WebDriver okno1 = new ChromeDriver();
        okno1.get("https://antycaptcha.amberteam.pl:5443/");
        okno1.manage().window().maximize();
        WebDriver okno2 = new ChromeDriver();
        okno2.get("https://wykop.pl");
        okno2.manage().window().maximize();
        String Url = okno1.getCurrentUrl();
        String Title = okno1.getTitle();
        String Url2 = okno2.getCurrentUrl();
        String Title2 = okno2.getTitle();
        Assert.assertEquals(Url, "https://antycaptcha.amberteam.pl:5443/");
        Assert.assertEquals(Title, "AntyCaptcha");
        Assert.assertEquals(Url2, "https://www.wykop.pl/");
        Assert.assertEquals(Title2, "Wykop.pl - newsy, aktualności, gry, wiadomości, muzyka, ciekawostki, filmiki");
        log.info("adres pierwszej strony to: " + Url +", a tytuł: " + Title +", adres drugiej strony to: " + Url2 +", a tytuł: " + Title2);
        File f = ((TakesScreenshot)okno1).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File("C:\\Users\\LWlosek\\IdeaProjects\\conSelenium\\screens\\s.png"));
        okno1.quit();
        okno2.quit();
    }
}

