package com.ashlux.mavenoc4jplugin;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class RestartMojoTest {

	@Test
	public void testBuildCommand() {
		RestartMojo restartMojo = new RestartMojo();
		restartMojo.setAdminJar("adminJar");
		restartMojo.setConnectionUri("connectionUri");
		restartMojo.setJ2eeHome("j2eeHome");
		restartMojo.setJavaHome("javaHome");
		restartMojo.setPassword("password");
		restartMojo.setUsername("username");

		String command = restartMojo.buildCommand();

		Assert.assertEquals(command,"javaHome" + File.separator + "bin" + File.separator + "java -jar j2eeHome" + File.separator + "adminJar connectionUri username password -restart");
	}
}
