package com.ashlux.mavenoc4jplugin;

import java.io.File;

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

	@Override
	protected String buildCommand() {
		String command = getJavaHome() + CALL_JAVA_JAR_RUN + getJ2eeHome() + File.separator + getAdminJar() + " " + getConnectionUri() + " " + getUsername() + " " + getPassword() + " -stop " + applicationName;
		showCommandOutput(command);
		return command;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
}
