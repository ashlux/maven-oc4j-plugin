package com.ashlux.mavenoc4jplugin;

import java.io.File;

/**
 * Restart OC4J.
 * 
 * @goal restart
 */
public class RestartMojo extends AbstractOc4jMojo {

	@Override
	protected String buildCommand() {
		String command = getJavaHome() + CALL_JAVA_JAR_RUN + getJ2eeHome() + File.separator + getAdminJar() + " " + getConnectionUri() + " " + getUsername() + " " + getPassword() + " -restart";
		showCommandOutput(command);
		return command;
	}
}
