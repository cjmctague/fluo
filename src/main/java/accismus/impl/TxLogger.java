package accismus.impl;

import org.apache.log4j.Logger;

public class TxLogger {
  private static Logger log = Logger.getLogger(TxLogger.class);

  static void logTx(String status, String clazz, TxStats stats) {
    logTx(status, clazz, stats, null);
  }

  static void logTx(String status, String clazz, TxStats stats, String trigger) {
    if (log.isTraceEnabled()) {
      String triggerMsg = "";
      if (trigger != null)
        triggerMsg = "trigger:" + trigger + " ";

      // TODO need better names for #read and #ret... these indicate the number the user looked up and the number looked up that existed

      String msg = String.format("tx info status:%s time:%d #read:TODO #ret:%,d #set:%,d #collisions:%,d waitTime:%,d %sclass:%s", status, stats.getTime(),
          stats.getEntriesReturned(), stats.getEntriesSet(), stats.getCollisions(), stats.getLockWaitTime(), triggerMsg, clazz);
      log.trace(msg);
    }
  }

  public static boolean isLoggingEnabled() {
    return log.isTraceEnabled();
  }
}
