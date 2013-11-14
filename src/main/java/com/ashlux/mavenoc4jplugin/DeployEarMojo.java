package com.ashlux.mavenoc4jplugin;

import java.io.File;

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

	@Override
	protected String buildCommand() {
		String command = getJavaHome() + CALL_JAVA_JAR_RUN + getJ2eeHome() + File.separator + getAdminJar() + " " + getConnectionUri() + " " + getUsername() + " " + getPassword() + " -deploy " + "-file " + earDirectory + File.separator + earFile + " " + "-deploymentName " + applicationName + " -bindAllWebApps";
		showCommandOutput(command);
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
