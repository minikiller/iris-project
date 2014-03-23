package com.liming.admin;

import static org.ops4j.pax.exam.Constants.START_LEVEL_SYSTEM_BUNDLES;
import static org.ops4j.pax.exam.Constants.START_LEVEL_TEST_BUNDLE;
import static org.ops4j.pax.exam.CoreOptions.cleanCaches;
import static org.ops4j.pax.exam.CoreOptions.composite;
import static org.ops4j.pax.exam.CoreOptions.frameworkStartLevel;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;

import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.util.PathUtils;

/**
 * Default configuration for native container regression tests, overriding the default test system
 * configuration.
 * <p>
 * We do not need the Remote Bundle Context for Native Container, and we prefer unified logging with
 * logback.
 * <p>
 * To override the standard options, you need to set the configuration property
 * {@code pax.exam.system = default}.
 * 
 * @author Harald Wellmann
 * @since Dec 2011
 */
public class RegressionConfiguration {

    public static Option regressionDefaults() {
        return composite(

            cleanCaches(),

            // we're running with pax.exam.logging = none, so add SLF4J and logback bundles
            mavenBundle("org.slf4j", "slf4j-api").versionAsInProject().startLevel(
                START_LEVEL_SYSTEM_BUNDLES),
            mavenBundle("ch.qos.logback", "logback-core").versionAsInProject().startLevel(
                START_LEVEL_SYSTEM_BUNDLES),
            mavenBundle("ch.qos.logback", "logback-classic").versionAsInProject().startLevel(
                START_LEVEL_SYSTEM_BUNDLES),

            // Set logback configuration via system property.
            // This way, both the driver and the container use the same configuration
            systemProperty("logback.configurationFile").value(
                "file:" + PathUtils.getBaseDir() + "/src/test/web/logback.xml"),

            frameworkStartLevel(START_LEVEL_TEST_BUNDLE));
    }

    public static boolean isNativeContainer() {
        return "native".equals(System.getProperty("pax.exam.container"));
    }

    public static boolean isEquinox() {
        return "equinox".equals(System.getProperty("pax.exam.framework"));
    }

    public static boolean isFelix() {
        return "felix".equals(System.getProperty("pax.exam.framework"));
    }

    public static boolean isKnopflerfish() {
        return "knopflerfish".equals(System.getProperty("pax.exam.framework"));
    }
}
