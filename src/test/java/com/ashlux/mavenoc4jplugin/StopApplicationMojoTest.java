package com.ashlux.mavenoc4jplugin;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class StopApplicationMojoTest {
  @Test
  public void testBuildCommand() {
    StopApplicationMojo stopApplicationMojo = new StopApplicationMojo();
    stopApplicationMojo.setAdminJar("adminJar");
    stopApplicationMojo.setConnectionUri("connectionUri");
    stopApplicationMojo.setApplicationName("applicationName");
    stopApplicationMojo.setJ2eeHome("j2eeHome");
    stopApplicationMojo.setJavaHome("javaHome");
    stopApplicationMojo.setPassword("password");
    stopApplicationMojo.setUsername("username");

    String statement = stopApplicationMojo.buildCommand();

    assertEquals(statement, "javaHome/bin/java -jar j2eeHome/adminJar connectionUri username password -stop applicationName");
  }
}
