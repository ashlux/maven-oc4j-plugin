package com.ashlux.mavenoc4jplugin;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class DeployEarMojoTest {

	@Test
	public void testBuildCommand() {
		DeployEarMojo deployMojo = new DeployEarMojo();
		deployMojo.setAdminJar("adminJar");
		deployMojo.setConnectionUri("connectionUri");
		deployMojo.setApplicationName("applicationName");
		deployMojo.setEarDirectory("earDirectory");
		deployMojo.setEarFile("earFile");
		deployMojo.setJ2eeHome("j2eeHome");
		deployMojo.setJavaHome("javaHome");
		deployMojo.setPassword("password");
		deployMojo.setUsername("username");

		String command = deployMojo.buildCommand();

		Assert.assertEquals(command,"javaHome" + File.separator + "bin" + File.separator + "java -jar j2eeHome" + File.separator + "adminJar connectionUri username password -deploy -file earDirectory" + File.separator + "earFile -deploymentName applicationName -bindAllWebApps");
	}
}
