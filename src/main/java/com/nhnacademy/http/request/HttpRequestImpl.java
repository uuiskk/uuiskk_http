/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.http.request;

import lombok.extern.slf4j.Slf4j;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HttpRequestImpl implements HttpRequest {
    /* TODO#2 HttpRequest를 구현 합니다.
    *  test/java/com/nhnacademy/http/request/HttpRequestImplTest TestCode를 실행하고 검증 합니다.
    */

    private final Socket client;
    private String method;
    private String uri;
    private final Map<String, Object> attribute = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();
    private final Map<String, String> parameters = new HashMap<>();

    public HttpRequestImpl(Socket socket) {
        this.client = socket;
        parseRequest();  // 소켓을 통해 들어온 요청을 파싱
    }

    private void parseRequest() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String line = bufferedReader.readLine();

            if (line != null && !line.isEmpty()) {
                String[] requestLine = line.split(" ");
                method = requestLine[0];  // 메서드 (예: GET, POST)
                uri = requestLine[1].split("\\?")[0];  // URI (쿼리 스트링 제외)

                // 쿼리 스트링 파싱
                if (requestLine[1].contains("?")) {
                    String queryString = requestLine[1].split("\\?")[1];
                    for (String param : queryString.split("&")) {
                        String[] keyValue = param.split("=");
                        if (keyValue.length == 2) {
                            parameters.put(keyValue[0], keyValue[1]);
                        }
                    }
                }

                // 헤더 파싱
                while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                    if (line.contains(": ")) {
                        String[] header = line.split(": ", 2);
                        headers.put(header[0], header[1]);
                    } else {
                        log.warn("Invalid header format: " + line);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public Map<String, String> getParameterMap() {
        return parameters;
    }

    @Override
    public String getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public void setAttribute(String name, Object o) {
        attribute.put(name, o);
    }

    @Override
    public Object getAttribute(String name) {
        return attribute.get(name);
    }

    @Override
    public String getRequestURI() {
        return uri;
    }
}
