package com.ashlux.mavenoc4jplugin;

/**
 * Start an application in OC4J.
 *
 * @goal startApplication
 */
public class StartApplicationMojo extends AbstractOc4jMojo {
  /**
   * Application name when deploying the ear.
   *
   * @parameter expression="${oc4j.deploymentName}" default-value="${project.artifactId}"
   */
  private String applicationName;

  protected String buildCommand() {
    String command = getJavaHome() + "/bin/java -jar " + getJ2eeHome() + "/" + getAdminJar() + " " +
        getConnectionUri() + " " + getUsername() + " " + getPassword() +
        " -start " + applicationName;
    getLog().debug("Going to run command [" + command + "].");
    return command;
  }

  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }
}