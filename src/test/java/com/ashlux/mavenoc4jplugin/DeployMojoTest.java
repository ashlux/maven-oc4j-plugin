package com.ashlux.mavenoc4jplugin;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DeployMojoTest {
  @Test
  public void testBuildCommand() {
    DeployMojo deployMojo = new DeployMojo();
    deployMojo.setApplicationName("applicationName");
    deployMojo.setEarDirectory("earDirectory");
    deployMojo.setEarFile("earFile");
    deployMojo.setJ2eeHome("j2eeHome");
    deployMojo.setJavaHome("javaHome");
    deployMojo.setOrmiUrl("ormiUrl");
    deployMojo.setPassword("password");
    deployMojo.setUsername("username");

    String command = deployMojo.buildCommand();

    assertEquals(command,
        "javaHome/bin/java -jar j2eeHome/admin.jar ormiUrl username password -deploy -file earDirectory/earFile -deploymentName applicationName");
  }
}
