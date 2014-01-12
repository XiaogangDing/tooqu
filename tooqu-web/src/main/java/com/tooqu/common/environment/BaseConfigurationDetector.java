/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.common.environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author guo
 */
public class BaseConfigurationDetector {
    /*
     * Singleton
     */

    private static BaseConfigurationDetector current;
    private static final String CONFIG_PATH = "src/main/resources/config.properties";
    private static Log logger = LogFactory.getLog(BaseConfigurationDetector.class);

    public static BaseConfigurationDetector getInstance() {
        if (current == null) {
            current = new BaseConfigurationDetector();
        }
        return current;
    }
    private String webBaseUrl;

    private BaseConfigurationDetector() {
        logger.debug("+++++++++++++++++++++++++++++++++can't find");
        File configFile = new File(CONFIG_PATH);
        if (configFile.exists()) {
            Properties prop = new Properties();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(configFile);
                prop.load(fis);
                webBaseUrl = prop.getProperty("web.base.url");
            } catch (Exception e) {
                logger.warn(e);
                setDevelopmentEnv();
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    logger.error(ex);
                }
            }
        } else {
            setDevelopmentEnv();
        }
    }

    private void setDevelopmentEnv() {
        webBaseUrl = "http://localhost:8084/tooqu";
    }

    public String getWebBaseUrl() {
        return webBaseUrl;
    }
}
