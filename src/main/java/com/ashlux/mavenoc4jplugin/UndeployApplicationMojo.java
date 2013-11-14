package com.ashlux.mavenoc4jplugin;

import java.io.File;

/**
 * Undeploy application from OC4J.
 * 
 * @goal undeployApplication
 */
public class UndeployApplicationMojo extends AbstractOc4jMojo {

	/**
	 * Application name when deploying the ear.
	 * 
	 * @parameter expression="${oc4j.deploymentName}" default-value="${project.artifactId}"
	 */
	private String applicationName;

	@Override
	protected String buildCommand() {
		String command = getJavaHome() + CALL_JAVA_JAR_RUN + getJ2eeHome() + File.separator + getAdminJar() + " " + getConnectionUri() + " " + getUsername() + " " + getPassword() + " -undeploy " + applicationName;
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
