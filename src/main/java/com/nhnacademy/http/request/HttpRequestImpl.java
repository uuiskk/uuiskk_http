package com.nhnacademy.http.request;

import lombok.extern.slf4j.Slf4j;


import java.net.Socket;
import java.util.Map;

@Slf4j
public class HttpRequestImpl implements HttpRequest {
    /* TODO#2 HttpRequest를 구현 합니다.
    *  test/java/com/nhnacademy/http/request/HttpRequestImplTest TestCode를 실행하고 검증 합니다.
    */

    private final Socket client;

    public HttpRequestImpl(Socket socket) {
        this.client = socket;
    }


    @Override
    public String getMethod() {
        return null;
    }

    @Override
    public String getParameter(String name) {
        return null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return null;
    }

    @Override
    public String getHeader(String name) {
        return null;
    }

    @Override
    public void setAttribute(String name, Object o) {

    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public String getRequestURI() {
        return null;
    }
}
