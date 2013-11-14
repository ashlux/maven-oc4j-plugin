package com.ashlux.mavenoc4jplugin;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class ShutdownMojoTest {

	@Test
	public void testBuildCommand() {
		ShutdownMojo shutdownMojo = new ShutdownMojo();
		shutdownMojo.setAdminJar("adminJar");
		shutdownMojo.setConnectionUri("connectionUri");
		shutdownMojo.setJ2eeHome("j2eeHome");
		shutdownMojo.setJavaHome("javaHome");
		shutdownMojo.setPassword("password");
		shutdownMojo.setUsername("username");

		String command = shutdownMojo.buildCommand();

		Assert.assertEquals(command,"javaHome" + File.separator + "bin" + File.separator + "java -jar j2eeHome" + File.separator + "adminJar connectionUri username password -shutdown");
	}

}
