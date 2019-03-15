package org.tests.rats.tests;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.tests.rats.workers.AppManager;

import java.lang.reflect.Method;

public class TestBase {

    protected final AppManager app = new AppManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected Gson gson = new Gson();

    @BeforeMethod
    public void logStart(Method method){
        logger.info("Start test " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void logStop(Method method){
        logger.info("Finish test " + method.getName());
        try {
            Thread.sleep(app.pauseTimer);
        } catch(InterruptedException e){
            return;
        }
    }

}
