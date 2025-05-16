package com.web.automation.runner;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFile",
        monochrome= true,
        dryRun = false,

        glue="com.web.automation.stepdefinition",
        plugin = {"html:target/cucumber-report/",
                    "json:target/cucumber.json",
                    "pretty:target/cucumber-pretty.txt",
                    "junit:target/cucumber-results.xml" ,
                    //"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"

        }


)
public class TestRunner {
//    @BeforeClass
//    public static void setReportConfiguration(){
//        ExtentProperties property = ExtentProperties.INSTANCE;
//        property.setReportPath("./Reports/Reports.html");
//        }
//        @AfterClass
//    public static void setConfiguration(){
//            Reporter.loadXMLConfig("./ConfigFiles/extent-config.xml");
//
//
//   }
}
