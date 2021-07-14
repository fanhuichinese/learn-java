1. native 方法：
    1. private static native void registerNatives();
    2. public final native Class<?> getClass();
    3. public native int hashCode();
    4. protected native Object clone() throws CloneNotSupportedException;
    5. public final native void notify();
    6. public final native void notifyAll();
    7. public final native void wait(long timeout) throws InterruptedException;
2. 非native方法
    1. public boolean equals(Object obj)：用“==”比较
    2. public String toString()：类名加“@”加hashCode转成16进制字符串
    3. public final void wait(long timeout, int nanos) throws InterruptedException：第一个参数和wait(long timeout)一样，第二个参数如果大于0，timeout会++，然后调用wait(long timout)
    4. public final void wait() throws InterruptedException：调用wait(long timeout)，参数是0
    5. protected void finalize() throws Throwable：方法体为空
3. 静态代码块
    1. 执行了 registerNatives() 方法


  

