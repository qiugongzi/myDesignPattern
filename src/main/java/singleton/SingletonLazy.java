package singleton;

import java.util.concurrent.TimeUnit;

/**
 * @autor qiuchunhui
 * @Description 懒汉模式
 * 获取对象时才初始化对象
 * 缺点：线程不安全，多线程访问有可能不是同一个对象
 * @since 2020/11/18
 */
public class SingletonLazy {
  private static SingletonLazy instance = null;

  private SingletonLazy() {

  }

  /**
   * 单线程访问没有问题
   * 多线程访问，有可能new 多个SingletonLazy对象
   *
   * @return
   */
  public static SingletonLazy getInstance() throws InterruptedException {
    if (instance == null) {
      instance = new SingletonLazy();
      // 模拟创建对象需要耗时
      TimeUnit.MICROSECONDS.sleep(5);
    }
    return instance;
  }

  /**
   * 理论上输出的hashcode不全相同
   * 通过调试可以实现效果
   * 但由于程序过于简单，不容易实现该效果
   *
   * @param args
   */
  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      new Thread(() -> {
        try {
          System.out.println(SingletonLazy.getInstance().hashCode());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }
  }

}
