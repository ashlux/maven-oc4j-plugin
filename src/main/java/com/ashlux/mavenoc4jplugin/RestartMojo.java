package com.ashlux.mavenoc4jplugin;

/**
 * Restart OC4J.
 *
 * @goal restart
 */
public class RestartMojo extends AbstractOc4jMojo {
  protected String buildCommand() {
    String command = getJavaHome() + "/bin/java -jar " + getJ2eeHome() + "/" + getAdminJar() + " " +
        getConnectionUri() + " " + getUsername() + " " + getPassword() + " -restart";
    getLog().debug("Going to run command [" + command + "].");
    return command;
  }
}
