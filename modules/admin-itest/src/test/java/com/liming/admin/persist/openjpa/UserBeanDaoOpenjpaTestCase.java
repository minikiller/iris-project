package com.liming.admin.persist.openjpa;


import com.liming.admin.api.dao.IUserBeanDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.karaf.options.LogLevelOption;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import javax.inject.Inject;
import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.*;

/**
 * Created by dell on 14-1-26.
 */
@RunWith(PaxExam.class)
public class UserBeanDaoOpenjpaTestCase {
    private static final MavenArtifactUrlReference KARAF_URL = maven("org.apache.karaf", "apache-karaf", "3.0.0").type("zip");
    @Inject
    private BundleContext bc;

    @Configuration
    public Option[] config() {
        return new Option[]{
                karafDistributionConfiguration()
                        .frameworkUrl(KARAF_URL)
                        .karafVersion("3.0.0")
                        .unpackDirectory(new File("target/pax"))
                        .useDeployFolder(false), keepRuntimeFolder(),
                // Don't bother with local console output as it just ends up cluttering the logs
                configureConsole().ignoreLocalConsole().startRemoteShell(),
                logLevel(LogLevelOption.LogLevel.INFO),
                // Provision the example feature exercised by this test
                features(
                        "mvn:com.liming.core/karaf-features/1.0/xml/features",
                        new String[]{"derby-driver", "mysql-driver", "openjpa", "iris-admin"})
                // Remember that the test executes in another process.  If you want to debug it, you need
                // to tell Pax Exam to launch that process with debugging enabled.  Launching the test class itself with
                // debugging enabled (for example in Eclipse) will not get you the desired results.
                //debugConfiguration("5000", true),
        };
    }

    /*@Test
    public void checkKarafSystemService() throws Exception {
        assertThat(bc, is(notNullValue()));
        ServiceReference serviceRef = bc
                .getServiceReference("org.apache.karaf.system.SystemService");
        Object service = bc.getService(serviceRef);
        assertThat(service, is(notNullValue()));
    }*/

    @Test
    public void checkUserDaoService() throws Exception {
        assertThat(bc, is(notNullValue()));
        ServiceReference serviceRef = bc
                .getServiceReference(IUserBeanDao.class.getName());
        IUserBeanDao service = (IUserBeanDao) bc.getService(serviceRef);
        assertThat(service, is(notNullValue()));
    }

}
