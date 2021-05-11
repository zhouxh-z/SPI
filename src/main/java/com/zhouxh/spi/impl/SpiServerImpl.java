package com.zhouxh.spi.impl;


import com.zhouxh.spi.Spi;

/**
 * spi 实现类
 * @author zhouxh
 */
public class SpiServerImpl implements Spi {
    @Override
    public void execute() {
        System.out.println("执行了 SpiServerImpl.execute()方法");
    }
}
