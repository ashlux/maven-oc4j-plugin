package com.ashlux.mavenoc4jplugin;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class StartApplicationMojoTest {
  @Test
  public void testBuildCommand() {
    StartApplicationMojo startApplicationMojo = new StartApplicationMojo();
    startApplicationMojo.setAdminJar("adminJar");
    startApplicationMojo.setConnectionUri("connectionUri");
    startApplicationMojo.setApplicationName("applicationName");
    startApplicationMojo.setJ2eeHome("j2eeHome");
    startApplicationMojo.setJavaHome("javaHome");
    startApplicationMojo.setPassword("password");
    startApplicationMojo.setUsername("username");

    String statement = startApplicationMojo.buildCommand();

    assertEquals(statement, "javaHome/bin/java -jar j2eeHome/adminJar connectionUri username password -start applicationName");
  }
}
