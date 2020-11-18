package singleton;

/**
 * @autor qiuchunhui
 * @Description 饿汉单例模式
 * 类加载时就初始化对象，jvm保证线程安全
 * 缺点：无论有无使用到该对象都会加载到内存
 * @since 2020/11/18
 */
public class SingletonHungery {
  /**
   * private 必须私有
   * static  必须静态变量，也就是类变量，否则getInstance无法获取
   * final   确保唯一性
   */
  private static final SingletonHungery instance = new SingletonHungery();

  /**
   * 单例模式的构造方法都应该是私有的
   * 阻止被其他对象new
   */
  private SingletonHungery() {

  }

  /**
   * public 保证其他类能调用该方法获取该类实例
   * static 只有static才能通过类名调用
   *
   * @return
   */
  public static SingletonHungery getInstance() {
    return instance;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      new Thread(() -> System.out.println(SingletonHungery.getInstance().hashCode())).start();
    }
  }

}
