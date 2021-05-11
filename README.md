# SPI
```java
public static void main(String[] args) {
    ServiceLoader<Spi> load = ServiceLoader.load(Spi.class);
    Iterator<Spi> iterator = load.iterator();
    if(iterator.hasNext()){
        Spi next = iterator.next();
        next.execute();
    }
}
```
`ServiceLoader.load(Spi.class)` 中其实并没有做什么神奇的事情，只是实例化了`ServiceLoader` 和 `LazyIterator`  

类被加载的核心代码在 `Spi next = iterator.next();`  

该方法经历各种曲折最终都会调用到`ServiceLoader.nextService()` 方法
```java
private S nextService() {
    String cn = nextName;
    nextName = null;
    Class<?> c = null;
    try {
        c = Class.forName(cn, false, loader);
    } catch (ClassNotFoundException x) {
    }
    try {
        S p = service.cast(c.newInstance());
        providers.put(cn, p);
        return p;
    } catch (Throwable x) {
    }
}
```

去掉边角代码后，逻辑其实很简单，就是利用java的反射原理，对spi的实现类进行实例化。
