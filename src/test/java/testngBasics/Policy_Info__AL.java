package testngBasics;

public class Policy_Info__AL {

    public void checkforLocator() {

        PolicyInfo__SL.Enum.TITLE_TEST.getSelector().getText();
        PolicyInfo__SL.Enum.TITLE_TEST.getSelector("test","wert").getText();
    }
}
