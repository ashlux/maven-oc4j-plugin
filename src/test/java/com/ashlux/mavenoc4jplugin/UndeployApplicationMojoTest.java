package com.ashlux.mavenoc4jplugin;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

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

    assertEquals(statement, "javaHome/bin/java -jar j2eeHome/adminJar connectionUri username password -undeploy applicationName");
  }
}
