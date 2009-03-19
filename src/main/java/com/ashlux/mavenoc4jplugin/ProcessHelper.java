package com.ashlux.mavenoc4jplugin;

import org.apache.maven.plugin.logging.Log;

import java.io.IOException;

public class ProcessHelper {
  private ProcessHelper() {
  }

  public static void startProcess(String command, Log log) throws InterruptedException, IOException {
    Process process = Runtime.getRuntime().exec(command);
    Thread processErrorLoggingThread =
        new Thread(new LogStreamGobbler(process.getErrorStream(), log, LogLevel.ERROR));
    Thread processStdinLoggingThread =
        new Thread(new LogStreamGobbler(process.getInputStream(), log, LogLevel.INFO));
    processErrorLoggingThread.start();
    processStdinLoggingThread.start();
    processStdinLoggingThread.join();
    processErrorLoggingThread.join();
    process.waitFor();
  }
}
