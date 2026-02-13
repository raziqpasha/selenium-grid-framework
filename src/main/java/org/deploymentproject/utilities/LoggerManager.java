package org.deploymentproject.utilities;

import org.apache.log4j.Logger;

public class LoggerManager {

    public static Logger getLogger(Class<?> cls) {
        return Logger.getLogger(cls);
    }
}
