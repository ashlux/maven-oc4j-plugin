package com.ashlux.mavenoc4jplugin;

import org.apache.maven.plugin.logging.Log;
import static org.easymock.EasyMock.*;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class LogStreamGobblerTest {
  private static final String lineSeperator = System.getProperty("line.separator");

  @Test
  public void testLog_debug() {
    Log log = createMock(Log.class);
    log.debug("Log statement.");
    replay(log);

    LogStreamGobbler.log(log, LogLevel.DEBUG, "Log statement.");

    verify(log);
  }

  @Test
  public void testLog_info() {
    Log log = createMock(Log.class);
    log.info("Log statement.");
    replay(log);

    LogStreamGobbler.log(log, LogLevel.INFO, "Log statement.");

    verify(log);
  }

  @Test
  public void testLog_warn() {
    Log log = createMock(Log.class);
    log.warn("Log statement.");
    replay(log);

    LogStreamGobbler.log(log, LogLevel.WARN, "Log statement.");

    verify(log);
  }

  @Test
  public void testLog_error() {
    Log log = createMock(Log.class);
    log.error("Log statement.");
    replay(log);

    LogStreamGobbler.log(log, LogLevel.ERROR, "Log statement.");

    verify(log);
  }

  @Test
  public void testWork() throws IOException {
    String testString =
        "This is line one." + lineSeperator +
        "This is line two." + lineSeperator +
        "This is line three without a line seperator at the end.";

    Log log = createMock(Log.class);
    log.error("This is line one.");
    log.error("This is line two.");
    log.error("This is line three without a line seperator at the end.");
    replay(log);

    LogStreamGobbler.work(new ByteArrayInputStream(testString.getBytes()), log, LogLevel.ERROR);

    verify(log);
  }
}
