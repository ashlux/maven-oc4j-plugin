package com.ashlux.mavenoc4jplugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.io.IOException;

/**
 * Stop an application running in OC4J.
 *
 * @goal stopApplication
 */
public class StopApplicationMojo extends AbstractOc4jMojo {
  /**
   * Application name when deploying the ear.
   *
   * @parameter expression="${oc4j.deploymentName}" default-value="${project.artifactId}"
   */
  private String applicationName;

  public void execute() throws MojoExecutionException, MojoFailureException {
    String command = buildCommand();
    try {
      ProcessHelper.startProcess(command, getLog());
    } catch (IOException e) {
      getLog().error(e);
      throw new MojoExecutionException("Failed to wait for java process.  Sad Panda. :-(", e);
    } catch (InterruptedException e) {
      getLog().error(e);
      throw new MojoExecutionException("Could not start java process.  Sad Panda. :-(", e);
    }
  }

  protected String buildCommand() {
    String command = getJavaHome() + "/bin/java -jar " + getJ2eeHome() + "/" + getAdminJar() + " " +
        getConnectionUri() + " " + getUsername() + " " + getPassword() +
        " -stop " + applicationName;
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