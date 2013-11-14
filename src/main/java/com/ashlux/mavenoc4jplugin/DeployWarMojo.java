package com.ashlux.mavenoc4jplugin;

import java.io.File;

/**
 * Deploy war to OC4J.
 * 
 * @goal deployWar
 */
public class DeployWarMojo extends AbstractOc4jMojo {

	/**
	 * Directory where the ear file for deploying is located.
	 * 
	 * @parameter expression="${oc4j.warDirectory}" default-value="${project.build.directory}"
	 */
	private String warDirectory;

	/**
	 * War file to deploy.
	 * 
	 * @parameter expression="${oc4j.warFile}" default-value="${project.build.finalName}.${project.packaging}"
	 */
	private String warFile;

	/**
	 * Application name when deploying the ear.
	 * 
	 * @parameter expression="${oc4j.deploymentName}" default-value="${project.artifactId}"
	 */
	private String applicationName;

	/**
	 * Context root.
	 * 
	 * @parameter expression="${oc4j.contextRoot}"
	 * @required
	 */
	private String contextRoot;

	@Override
	protected String buildCommand() {
		String command = getJavaHome() + CALL_JAVA_JAR_RUN + getJ2eeHome() + File.separator + getAdminJar() + " " + getConnectionUri() + " " + getUsername() + " " + getPassword() + " -deploy " + "-file " + warDirectory + File.separator + warFile + " " + "-deploymentName " + applicationName + " -contextRoot " + contextRoot;
		showCommandOutput(command);
		return command;
	}

	public String getWarDirectory() {
		return warDirectory;
	}

	public void setWarDirectory(String warDirectory) {
		this.warDirectory = warDirectory;
	}

	public String getWarFile() {
		return warFile;
	}

	public void setWarFile(String warFile) {
		this.warFile = warFile;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}

	public String getContextRoot() {
		return contextRoot;
	}
}
