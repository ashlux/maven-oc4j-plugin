package com.ashlux.mavenoc4jplugin;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class UndeployApplicationMojoTest {

	@Test
	public void testBuildCommand() {
		UndeployApplicationMojo undeployMojo = new UndeployApplicationMojo();
		undeployMojo.setAdminJar("adminJar");
		undeployMojo.setConnectionUri("connectionUri");
		undeployMojo.setApplicationName("applicationName");
		undeployMojo.setJ2eeHome("j2eeHome");
		undeployMojo.setJavaHome("javaHome");
		undeployMojo.setPassword("password");
		undeployMojo.setUsername("username");

		String statement = undeployMojo.buildCommand();

		Assert.assertEquals(statement,"javaHome" + File.separator + "bin" + File.separator + "java -jar j2eeHome" + File.separator + "adminJar connectionUri username password -undeploy applicationName");
	}
}
