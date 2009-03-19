package com.ashlux.mavenoc4jplugin.log;

import org.apache.maven.plugin.logging.Log;
import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.io.IOException;

public class LogStreamGobbler implements Runnable {
  private static final String lineSeperator = System.getProperty("line.separator");

  private InputStream inputStream;
  private Log log;
  private LogLevel logLevel;

  public LogStreamGobbler(InputStream inputStream, Log log, LogLevel logLevel) {
    this.inputStream = inputStream;
    this.log = log;
    this.logLevel = logLevel;
  }

  public void run() {
    try {
      work(inputStream, log, logLevel);
      inputStream.close();
    } catch (IOException e) {
      log.error(e);
    }
  }

  // Log one line at a time at the specified log level
  protected static void work(InputStream inputStream, Log log, LogLevel logLevel) throws IOException {
    String line = "";
    int myChar = inputStream.read();
    while (myChar != -1) {
      // concat all chars until we find a line seperator
      if (lineSeperator.equals(String.valueOf((char) myChar))) {
        log(log, logLevel, line);
        line = "";
      } else {
        line += (char) myChar;
      }
      myChar = inputStream.read();
    }

    // log anything left over
    if (StringUtils.isNotEmpty(line)) {
      log.error(line);
    }
  }

  protected static void log(Log log, LogLevel logLevel, String statement) {
    switch (logLevel) {
      case DEBUG:
        log.debug(statement);
        break;
      case INFO:
        log.info(statement);
        break;
      case WARN:
        log.warn(statement);
        break;
      case ERROR:
        log.error(statement);
        break;
    }
  }
}
