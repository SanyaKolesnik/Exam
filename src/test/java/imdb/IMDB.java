package imdb;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by stale on 20.11.2016.
 */
public class IMDB {
    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() {
        System.out.println("SetUp Chrome");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Constants.DEFAULT_WAIT_LONG_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void favorit() throws InterruptedException {
        String text = ".//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr[";
        String text1 = "]/td[2]/a";
        String text2 = ".//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr[";
        String text3 = "]/td[3]/strong";



        driver.get("http://www.imdb.com/chart/top");
        Map<String,String> map=new HashMap<>();

        for (int i = 0; i <= 250; i++) {
            String key = text+i+text1;
            String value= text2+i+text3;

//Обрабатывается элемент которого нет .//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr[0]/td[2]/a
            try {
            map.put(driver.findElement(By.xpath(key)).getText(),driver.findElement(By.xpath(value)).getText());
            }catch (NoSuchElementException e){}
            for(Map.Entry<String,String>zalupa:map.entrySet()) {
                String key1=zalupa.getKey();
                String value1=zalupa.getValue();
                value1.replace(",",".");
                Double value2=Double.parseDouble(value1.replace(",","."));
                if (value2>8.5 & value2<9)
                System.out.println(key1+"."+value2);
            }
        }
    }
}