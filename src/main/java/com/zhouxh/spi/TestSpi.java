package com.zhouxh.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author zhouxh
 */
public class TestSpi {
    public static void main(String[] args) {
        ServiceLoader<Spi> load = ServiceLoader.load(Spi.class);
        Iterator<Spi> iterator = load.iterator();
        if(iterator.hasNext()){
            final Spi next = iterator.next();
            next.execute();
        }
    }
}
