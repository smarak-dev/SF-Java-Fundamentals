package hidingexceptions;

import java.sql.SQLClientInfoException;
import java.sql.SQLData;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class Example {
  public static void doSupportStuff()
      throws SQLDataException, SQLClientInfoException {
    if (Math.random() > 0.5) {
      throw new SQLDataException("DB busted!");
    }
    if (Math.random() > 0.5) {
      throw new SQLClientInfoException();
    }
  }

  public static void doStuff()  {
    try {
      doSupportStuff();
//    } catch (SQLDataException sqle) {
//// this is how the caller can get back to the low-level,
//// implementation-dependent original problem
//// cause is also dumped in the log files with the stack trace
////      sqle.getCause();
//      throw new RuntimeException(sqle); // sqle is now "cause"
//    } catch (SQLClientInfoException sqlcie) {
//
      // called "multi-catch"
    } catch (SQLDataException | SQLClientInfoException sqle) {
      // handle them both the same way
    }

  }

  public static void main(String[] args) throws SQLException {
    doStuff();
  }
}
