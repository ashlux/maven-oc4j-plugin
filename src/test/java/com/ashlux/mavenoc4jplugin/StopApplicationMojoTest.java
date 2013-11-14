package com.ashlux.mavenoc4jplugin;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class StopApplicationMojoTest {

	@Test
	public void testBuildCommand() {
		StopApplicationMojo stopApplicationMojo = new StopApplicationMojo();
		stopApplicationMojo.setAdminJar("adminJar");
		stopApplicationMojo.setConnectionUri("connectionUri");
		stopApplicationMojo.setApplicationName("applicationName");
		stopApplicationMojo.setJ2eeHome("j2eeHome");
		stopApplicationMojo.setJavaHome("javaHome");
		stopApplicationMojo.setPassword("password");
		stopApplicationMojo.setUsername("username");

		String statement = stopApplicationMojo.buildCommand();

		Assert.assertEquals(statement,"javaHome" + File.separator + "bin" + File.separator + "java -jar j2eeHome" + File.separator + "adminJar connectionUri username password -stop applicationName");
	}
}
