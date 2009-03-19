package com.ashlux.mavenoc4jplugin;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

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

    assertEquals(command,
        "javaHome/bin/java -jar j2eeHome/adminJar connectionUri username password -shutdown");
  }

}
