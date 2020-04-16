package com.ha.qa.web.uiframework.configurations;

import com.ha.qa.web.uiframework.common.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configs {

    private static final Logger logger = LogManager.getLogger(Configs.class);

    public static Properties OR;

    private static Configs configs;

    static {
        try {
            configs = new Configs();
        } catch (IOException e) {
            logger.error("Error while loading the configurations - " + e.getMessage() , e.getStackTrace());
        }
    }

    private Configs() throws IOException {
        File configFile = Utility.getInstance().getResourceFile("configurations/Config.properties");
        FileInputStream fis = new FileInputStream(configFile);
        OR = new Properties();
        OR.load(fis);
        logger.info("Configs loaded from properties file: "+ configFile.getAbsolutePath());
    }
}
