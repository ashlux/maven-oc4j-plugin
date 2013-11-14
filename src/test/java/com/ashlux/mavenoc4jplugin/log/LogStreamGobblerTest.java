package com.ashlux.mavenoc4jplugin.log;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.maven.plugin.logging.Log;
import org.junit.Test;

public class LogStreamGobblerTest {

	@Test
	public void testLog_debug() {
		Log log = createMock(Log.class);
		log.debug("Log statement.");
		replay(log);

		LogStreamGobbler.log(log,LogLevel.DEBUG,"Log statement.");

		verify(log);
	}

	@Test
	public void testLog_info() {
		Log log = createMock(Log.class);
		log.info("Log statement.");
		replay(log);

		LogStreamGobbler.log(log,LogLevel.INFO,"Log statement.");

		verify(log);
	}

	@Test
	public void testLog_warn() {
		Log log = createMock(Log.class);
		log.warn("Log statement.");
		replay(log);

		LogStreamGobbler.log(log,LogLevel.WARN,"Log statement.");

		verify(log);
	}

	@Test
	public void testLog_error() {
		Log log = createMock(Log.class);
		log.error("Log statement.");
		replay(log);

		LogStreamGobbler.log(log,LogLevel.ERROR,"Log statement.");

		verify(log);
	}

	@Test
	public void testWork() throws IOException {

		String testString = "This is line one.\nThis is line two.\nThis is line three without a line seperator at the end.";
		Log log = createMock(Log.class);
		log.error("This is line one.");
		log.error("This is line two.");
		log.error("This is line three without a line seperator at the end.");
		replay(log);

		LogStreamGobbler.work(new ByteArrayInputStream(testString.getBytes()),log,LogLevel.ERROR);

		verify(log);
	}
}
