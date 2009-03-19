package com.ashlux.mavenoc4jplugin;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class UndeployMojoTest {
  @Test
  public void testBuildCommand() {
    UndeployMojo undeployMojo = new UndeployMojo();
    undeployMojo.setApplicationName("applicationName");
    undeployMojo.setJ2eeHome("j2eeHome");
    undeployMojo.setJavaHome("javaHome");
    undeployMojo.setOrmiUrl("ormiUrl");
    undeployMojo.setPassword("password");
    undeployMojo.setUsername("username");

    String statement = undeployMojo.buildCommand();

    assertEquals(statement, "javaHome/bin/java -jar j2eeHome/admin.jar ormiUrl username password -undeploy applicationName");
  }
}
