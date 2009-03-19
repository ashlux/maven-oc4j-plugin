package com.ashlux.mavenoc4jplugin;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class RestartMojoTest {
  @Test
  public void testBuildCommand() {
    RestartMojo restartMojo = new RestartMojo();
    restartMojo.setAdminJar("adminJar");
    restartMojo.setConnectionUri("connectionUri");
    restartMojo.setJ2eeHome("j2eeHome");
    restartMojo.setJavaHome("javaHome");
    restartMojo.setPassword("password");
    restartMojo.setUsername("username");

    String command = restartMojo.buildCommand();
    
    assertEquals(command,
        "javaHome/bin/java -jar j2eeHome/adminJar connectionUri username password -restart");
  }
}
