package com.ashlux.mavenoc4jplugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.io.IOException;

/**
 * Deploy ear to OC4J.
 *
 * @goal deploy
 */
public class DeployMojo extends AbstractMojo {
  /**
   * Java home
   *
   * @parameter expression="${java.home}"
   * @readonly
   */
  private String javaHome;

  /**
   * J2EE home, directory where admin.jar is located.
   *
   * @parameter expression="${oc4j.j2eeHome}"
   * @required
   */
  private String j2eeHome;

  /**
   * ORMI URL.
   *
   * @parameter expression="${oc4j.ormiUrl}" default-value="ormi://localhost/"
   */
  private String ormiUrl;

  /**
   * Username used for deploying.
   *
   * @parameter expression="${oc4j.username}"
   * @required
   */
  private String username;

  /**
   * Password used for deploying.
   *
   * @parameter expression="${oc4j.password}"
   * @required
   */
  private String password;

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
      throw new MojoExecutionException("Failed to wait for java process to complete deploying application.  Sad Panda. :-(", e);
    } catch (InterruptedException e) {
      getLog().error(e);
      throw new MojoExecutionException("Could not start java process to deploy application.  Sad Panda. :-(", e);
    }
  }

  protected String buildCommand() {
    String command = javaHome + "/bin/java -jar " + j2eeHome + "/admin.jar " +
        ormiUrl + " " + username + " " + password + " -deploy " +
        "-file " + earDirectory + "/" + earFile + " " +
        "-deploymentName " + applicationName;
    getLog().debug("Going to run command [" + command + "].");
    return command;
  }

  public String getJavaHome() {
    return javaHome;
  }

  public void setJavaHome(String javaHome) {
    this.javaHome = javaHome;
  }

  public String getJ2eeHome() {
    return j2eeHome;
  }

  public void setJ2eeHome(String j2eeHome) {
    this.j2eeHome = j2eeHome;
  }

  public String getOrmiUrl() {
    return ormiUrl;
  }

  public void setOrmiUrl(String ormiUrl) {
    this.ormiUrl = ormiUrl;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
