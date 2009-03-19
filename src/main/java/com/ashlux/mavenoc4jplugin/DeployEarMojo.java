package com.ashlux.mavenoc4jplugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.io.IOException;

/**
 * Deploy ear to OC4J.
 *
 * @goal deployEar
 */
public class DeployEarMojo extends AbstractOc4jMojo {
  /**
   * Directory where the ear file for deploying is located.
   *
   * @parameter expression="${oc4j.earDirectory}" default-value="${project.build.directory}"
   */
  private String earDirectory;

  /**
   * Ear file to deploy.
   *
   * @parameter expression="${oc4j.earFile}" default-value="${project.build.finalName}.${project.packaging}"
   */
  private String earFile;

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
        getConnectionUri() + " " + getUsername() + " " + getPassword() + " -deploy " +
        "-file " + earDirectory + "/" + earFile + " " +
        "-deploymentName " + applicationName + " -bindAllWebApps";
    getLog().debug("Going to run command [" + command + "].");
    return command;
  }

  public String getEarDirectory() {
    return earDirectory;
  }

  public void setEarDirectory(String earDirectory) {
    this.earDirectory = earDirectory;
  }

  public String getEarFile() {
    return earFile;
  }

  public void setEarFile(String earFile) {
    this.earFile = earFile;
  }

  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }
}
