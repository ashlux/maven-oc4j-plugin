package com.ashlux.mavenoc4jplugin;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class StartApplicationMojoTest {

	@Test
	public void testBuildCommand() {
		StartApplicationMojo startApplicationMojo = new StartApplicationMojo();
		startApplicationMojo.setAdminJar("adminJar");
		startApplicationMojo.setConnectionUri("connectionUri");
		startApplicationMojo.setApplicationName("applicationName");
		startApplicationMojo.setJ2eeHome("j2eeHome");
		startApplicationMojo.setJavaHome("javaHome");
		startApplicationMojo.setPassword("password");
		startApplicationMojo.setUsername("username");

		String statement = startApplicationMojo.buildCommand();

		Assert.assertEquals(statement,"javaHome" + File.separator + "bin" + File.separator + "java -jar j2eeHome" + File.separator + "adminJar connectionUri username password -start applicationName");
	}
}
