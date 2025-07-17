package Runner;

import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.xml.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter; // Import this
import java.io.IOException; // Import this

public class GenerateTestNGXMLAndRun1 {

    @BeforeSuite(alwaysRun = true)
    public void initSuite() {
        System.out.println(System.getProperty("website", "Gmail"));
        System.out.println(System.getProperty("threadCount", "1"));
        System.out.println(System.getProperty("buildBy", "Prasad"));
    }

    @Test
    public void TestRunner () {
        // Create an XmlSuite
        XmlSuite suite = new XmlSuite();
        suite.setName("PracticeSuite");

        // Create an XmlTest
        XmlTest test = new XmlTest(suite);
        test.setName("MyDynamicTest");

        // Create XmlClass objects for your test classes
        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass("testngBasics.TestngPractice")); // Use your fully qualified name
        test.setXmlClasses(classes);

        // --- Configure groups to include only "minor" ---
        XmlGroups groups = new XmlGroups();
        XmlRun run = new XmlRun();
        run.onInclude("minor"); // Keep this as it is
        groups.setRun(run);
        test.setGroups(groups);

        // Add the suite to a list of suites
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        // --- IMPORTANT: Save the generated XML to a file ---
        String xmlContent = suite.toXml();
        String filePath = "temp_testng_with_groups.xml"; // Name of the file

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(xmlContent);
            System.out.println("Generated TestNG XML saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving XML file: " + e.getMessage());
            e.printStackTrace();
        }

        // --- NOW RUN TESTNG USING THE GENERATED FILE ---
        TestNG testng = new TestNG();
        // Clear any previously set programmatic suites
        testng.setXmlSuites(new ArrayList<>());
        // Set the XML file to be executed
        testng.setTestSuites(Arrays.asList(filePath));

        testng.run();

//        System.out.println("\n--- Generated testng.xml content that was used ---");
//        System.out.println(xmlContent);
//        System.out.println("--------------------------------------------------");
    }
}