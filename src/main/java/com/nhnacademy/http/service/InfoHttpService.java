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

package com.nhnacademy.http.service;

import com.nhnacademy.http.request.HttpRequest;
import com.nhnacademy.http.response.HttpResponse;
import com.nhnacademy.http.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Slf4j
public class InfoHttpService implements HttpService {
    /*TODO#3 InfoHttpService 구현
       - Request : http://localhost:8080/info.html?id=marco&age=40&name=마르코
       - 요청을 처리하고 응답하는 InfoHttpService 입니다.
       - IndexHttpService를 참고하여 doGet을 구현하세요.
       - info.html 파일은 /resources/info.html 위치 합니다.
       - info.html을 읽어 parameters{id,name,age}를 replace 후 응답 합니다.
       - ex)
            ${id} <- marco
            ${name} <- 마르코
            ${age} <- 40
    */

    @Override
    public void doGet(HttpRequest httpRequest, HttpResponse httpResponse) {
        //doGet 구현
        String responseBody = null;

        try (PrintWriter printWriter = httpResponse.getWriter();){
            responseBody = ResponseUtils.tryGetBodyFormFile(httpRequest.getRequestURI());

            String id = "${" + httpRequest.getParameter("id") +"}";
            String name = "${" + URLDecoder.decode(httpRequest.getParameter("name")) +"}";
            String age = "${" + httpRequest.getParameter("age") +"}";

            responseBody = responseBody.replace("${id}",id);
            responseBody = responseBody.replace("${name}",name);
            responseBody = responseBody.replace("${age}",age);




            String responseHeader = ResponseUtils.createResponseHeader(200, "UTF-8",responseBody.getBytes().length);
            printWriter.write(responseHeader);
            printWriter.write(responseBody);
            printWriter.flush();
            printWriter.close();
            log.debug("Header: {}",responseHeader);
            log.debug("Body: {}",responseBody);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
