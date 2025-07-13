package Runner;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlGroups; // Make sure this import is present
import org.testng.xml.XmlRun;   // Make sure this import is present

import java.util.ArrayList;
import java.util.List;

public class GenerateTestNGXMLAndRun {
    public static void main(String[] args) {
        // Create an XmlSuite
        XmlSuite suite = new XmlSuite();
        suite.setName("PracticeSuite");

        // Create an XmlTest
        XmlTest test = new XmlTest(suite);
        test.setName("MyDynamicTest");

        // Create XmlClass objects for your test classes
        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass("testngBasics.TestngPractice")); // Replace with your actual package and class name
        //classes.add(new XmlClass("your.package.YourTestClass2")); // Replace with your actual package and class name
        test.setXmlClasses(classes);

        // --- Optional: Configure groups (if you want to run specific groups) ---
        // Example: To include only the "sanity" group
         XmlGroups groups = new XmlGroups();
         XmlRun run = new XmlRun();
         run.onInclude("minor");
         groups.setRun(run);
         test.setGroups(groups);

        // Add the suite to a list of suites
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        // Create a TestNG object and run the suites
        TestNG testng = new TestNG();
        testng.setXmlSuites(suites);
        testng.run();

        System.out.println("\n--- Generated testng.xml content ---");
        System.out.println(suite.toXml());
        System.out.println("------------------------------------");

        // Optional: To save the generated XML to a file
        // String xmlContent = suite.toXml();
        // try (FileWriter writer = new FileWriter("dynamic_testng.xml")) {
        //     writer.write(xmlContent);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}