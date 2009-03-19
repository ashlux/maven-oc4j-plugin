package com.ashlux.mavenoc4jplugin;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

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

    assertEquals(command,
        "javaHome/bin/java -jar j2eeHome/adminJar connectionUri username password -deploy -file earDirectory/earFile -deploymentName applicationName -bindAllWebApps");
  }
}
