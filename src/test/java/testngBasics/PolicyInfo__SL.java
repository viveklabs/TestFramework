package testngBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PolicyInfo__SL {


    public enum Enum {

        TITLE_TEST(By.xpath("dfdfg")),
        USER_LABLE(By.id("ewq")),
        ;

        private By by;

         Enum(By by) {
            this.by = by;
        }

        public SeleniumObject getSelector(){
             String[] empty = {};
            return getSelector(empty);
        }

        public SeleniumObject getSelector(String... token){
             SeleniumObject selObj = new SeleniumObject(by);
             selObj.updateElement(token);
             return  selObj;
        }

    }
}
