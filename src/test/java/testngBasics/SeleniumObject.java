package testngBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumObject {

    private By by;
    private WebDriver driver;
    public SeleniumObject(By by){
        this.by = by;
    }

    public String getText(){
        return driver.findElement(by).getText();
    }

    public void updateElement(String... token){
        String a = by.toString().replaceAll("By.xpath","");

        String updatedXpath = "";
        for(int i = 0;i< token.length;i++){
            updatedXpath = updatedXpath.replaceAll("REPLACEME"+i,token[i]);
        }
        this.by = By.xpath(updatedXpath);
    }
}
