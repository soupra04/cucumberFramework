package myHooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import io.cucumber.java.Before;

import driver.DriverManager;
import stepDefinations.BaseClass;

public class Hooks {

    public static Properties configProp;
    // ThreadLocal logger
    private static ThreadLocal<Logger> threadLogger = new ThreadLocal<>();
    private static ThreadLocal<BaseClass> threadBase = new ThreadLocal<>();

    @Before
    public void setup() throws IOException {
        // Load config properties
        configProp = new Properties();
        FileInputStream configPropfile = new FileInputStream("config.properties");
        configProp.load(configPropfile);

        // Initialize logger for this thread
        Logger log = Logger.getLogger("TestLogger");
        PropertyConfigurator.configure("log4j.properties");
        threadLogger.set(log);

        // Initialize driver
        String br = configProp.getProperty("browser");
        DriverManager.init(br);
        getLogger().info("Launching " + br + " browser");

        // Initialize BaseClass for this thread
        threadBase.set(new BaseClass(DriverManager.getDriver()));
    }

    // Getter for logger in steps
    public static Logger getLogger() {
        return threadLogger.get();
    }

    // Optional getter for BaseClass if needed
    public static BaseClass getBaseClass() {
        return threadBase.get();
    }
}
