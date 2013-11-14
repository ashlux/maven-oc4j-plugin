package com.ashlux.mavenoc4jplugin;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class DeployWarMojoTest {

	@Test
	public void testBuildCommand() {
		DeployWarMojo deployWarMojo = new DeployWarMojo();
		deployWarMojo.setAdminJar("adminJar");
		deployWarMojo.setConnectionUri("connectionUri");
		deployWarMojo.setApplicationName("applicationName");
		deployWarMojo.setWarDirectory("warDirectory");
		deployWarMojo.setWarFile("warFile");
		deployWarMojo.setJ2eeHome("j2eeHome");
		deployWarMojo.setJavaHome("javaHome");
		deployWarMojo.setPassword("password");
		deployWarMojo.setUsername("username");
		deployWarMojo.setContextRoot("contextRoot");

		String command = deployWarMojo.buildCommand();

		Assert.assertEquals(command,"javaHome" + File.separator + "bin" + File.separator + "java -jar j2eeHome" + File.separator + "adminJar connectionUri username password -deploy -file warDirectory" + File.separator + "warFile -deploymentName applicationName -contextRoot contextRoot");
	}

}
