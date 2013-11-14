package com.ashlux.mavenoc4jplugin;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

abstract public class AbstractOc4jMojo extends AbstractMojo {

	final public void execute() throws MojoExecutionException,MojoFailureException {
		String command = buildCommand();
		try {
			ProcessHelper.startProcess(command,getLog());
		} catch (IOException e) {
			getLog().error(e);
			throw new MojoExecutionException("Failed to wait for Java process.  Sad Panda. :-(",e);
		} catch (InterruptedException e) {
			getLog().error(e);
			throw new MojoExecutionException("Could not start Java process.  Sad Panda. :-(",e);
		}
	}

	protected static final String CALL_JAVA_JAR_RUN = File.separator + "bin" + File.separator + "java -jar ";

	abstract String buildCommand();

	protected void showCommandOutput(String command) {
		getLog().info("      Running: ");
		getLog().info("--------------------------------------------------------");
		getLog().info(command);
		getLog().info("--------------------------------------------------------");
	}

	private String debug;

	/**
	 * Java home
	 * 
	 * @parameter expression="${java.home}
	 * @readonly
	 */
	private String javaHome;

	/**
	 * J2EE home, directory where admin.jar or admin_client.jar is located.
	 * 
	 * @parameter expression="${oc4j.j2eeHome}"
	 * @required
	 */
	private String j2eeHome;

	/**
	 * Admin jar located in #{oc4j.j2eeHome}. Example: Admin.jar or admin_client.jar.
	 * 
	 * @parameter expression="${oc4j.adminJar}" default-value="admin.jar"
	 */
	private String adminJar;

	/**
	 * ORMI URL.
	 * 
	 * @parameter expression="${oc4j.connectionUri}" default-value="ormi://localhost/"
	 */
	private String connectionUri;

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

	public String getAdminJar() {
		return adminJar;
	}

	public void setAdminJar(String adminJar) {
		this.adminJar = adminJar;
	}

	public String getConnectionUri() {
		return connectionUri;
	}

	public void setConnectionUri(String connectionUri) {
		this.connectionUri = connectionUri;
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

	public String getDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		this.debug = debug;
	}

	public boolean isDebugOn() {
		if (getDebug() != null && getDebug().equalsIgnoreCase("true")) { return true; }
		return false;
	}
}
