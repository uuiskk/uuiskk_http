package com.nhnacademy.http.context;

import com.nhnacademy.http.context.exception.ObjectNotFoundException;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

//TODO#2 - Context를 구현합니다.
public class ApplicationContext  implements Context{
    ConcurrentMap<String, Object> objectMap;

    public ApplicationContext() {
        this.objectMap = new ConcurrentHashMap<>();
    }

    @Override
    public void setAttribute(String name, Object object) {
        //구현
    }

    @Override
    public void removeAttribute(String name) {
        //구현
    }

    @Override
    public Object getAttribute(String name) {
        //object가 존재하지 않는다면 ObjectNotFoundException 예외가 발생합니다.
        return null;
    }
}
