package com.nhnacademy.http.response;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;


public class HttpResponseImpl implements HttpResponse {
    //TODO#4 HttpResponse를 구현 합니다.

    private final Socket socket;


    public HttpResponseImpl(Socket socket){
        this.socket = socket;
    }
    
    @Override
    public PrintWriter getWriter() throws IOException {
        return null;
    }

    @Override
    public void setCharacterEncoding(String charset) {

    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }
}
