package com.example.demo.beans;

public class DependentBeanImpl implements DependentBean {
    private SimpleBean simpleBean;

    public DependentBeanImpl(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}
