package com.example.alen.mvvmtest.module.main;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 刘伦
 * @date 2018/10/9
 */
public class MainActivityRepositoryTest {
    @Test
    public void initFunctionList() throws Exception {
        MainActivityRepository repository = new MainActivityRepository();
        assertEquals(repository.initFunctionList().size(), 2);
    }

}