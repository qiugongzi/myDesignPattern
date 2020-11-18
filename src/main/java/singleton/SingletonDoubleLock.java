package singleton;

/**
 * @autor qiuchunhui
 * @Description 双检锁单例模式，实现线程安全
 * @since 2020/11/18
 */
public class SingletonDoubleLock {
  private static SingletonDoubleLock instance = null;

  private SingletonDoubleLock() {

  }

  /**
   * 双检锁，保证线程安全
   *
   * @return
   */
  public static SingletonDoubleLock getInstance() {
    if (instance == null) {
      synchronized (SingletonDoubleLock.class) {
        if (instance == null) {
          instance = new SingletonDoubleLock();
        }
      }
    }
    return instance;
  }

  public static void main(String[] args) {

  }
}
