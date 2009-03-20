package com.ashlux.mavenoc4jplugin;

/**
 * Shutdown OC4J.
 *
 * @goal shutdown
 */
public class ShutdownMojo extends AbstractOc4jMojo {
  protected String buildCommand() {
    String command = getJavaHome() + "/bin/java -jar " + getJ2eeHome() + "/" + getAdminJar() + " " +
        getConnectionUri() + " " + getUsername() + " " + getPassword() + " -shutdown";
    getLog().debug("Going to run command [" + command + "].");
    return command;
  }
}