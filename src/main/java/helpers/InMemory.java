package helpers;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants.FrameworkConstants;
import dto.TestDataDto;
import utils.ReadJson;

public class InMemory {

    private static final Logger logger = LogManager.getLogger(InMemory.class);
    private static ThreadLocal<TestDataDto> instance = new ThreadLocal<>();

    private static TestDataDto loadConfig() throws Exception {
        String env = FrameworkConstants.ENV;
        TestDataDto obj = null;
        try {
            String path = 
            		//"C:\\Workspace\\CannatrekAutomationFramework\\src\\test\\resources\\testdata\\non\\TestData.json";
            		System.getProperty("user.dir") 
                  + File.separator + "src"
                   + File.separator + "test"
                    + File.separator + "resources"
                   + File.separator + "testdata"
                    + File.separator + env
                    + File.separator + "TestData.json";
            logger.debug("Reading data from " + path);
            obj = ReadJson.getJsonAsPoJo(path, TestDataDto.class);
            logger.debug("Loaded TestDataDto: " + obj);
            logger.debug("Users: " + obj.getUsers());
        } catch (Exception e) {
            logger.fatal("Failed to read: TestData.json", e);
            throw e;
        }
        return obj;
    }

    public static TestDataDto getInstance() throws Exception {
        if (instance.get() == null) {
            setInstance();
        }
        return instance.get();
    }

    public static void setInstance() throws Exception {
        logger.debug("Loading the data from testdata file");
        instance.set(loadConfig());
    }

    public static void setInstance(TestDataDto obj) throws Exception {
        instance.set(obj);
    }

    public static void updateInstance(TestDataDto obj) throws Exception {
        logger.warn("Resetting in memory, updated values will be removed");
        instance.remove();
        setInstance(obj);
    }

    public static void dispose() throws Exception {
        instance.remove();
    }
}
