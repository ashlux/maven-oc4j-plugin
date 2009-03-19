package com.ashlux.mavenoc4jplugin;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

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

    assertEquals(command,
        "javaHome/bin/java -jar j2eeHome/adminJar connectionUri username password -deploy -file warDirectory/warFile -deploymentName applicationName -contextRoot contextRoot");
  }

}
