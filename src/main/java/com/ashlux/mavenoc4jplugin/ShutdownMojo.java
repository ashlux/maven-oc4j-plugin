package com.ashlux.mavenoc4jplugin;

import java.io.File;

/**
 * Shutdown OC4J.
 * 
 * @goal shutdown
 */
public class ShutdownMojo extends AbstractOc4jMojo {

	@Override
	protected String buildCommand() {
		String command = getJavaHome() + CALL_JAVA_JAR_RUN + getJ2eeHome() + File.separator + getAdminJar() + " " + getConnectionUri() + " " + getUsername() + " " + getPassword() + " -shutdown";
		showCommandOutput(command);
		return command;
	}
}
