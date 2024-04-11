package com.nhnacademy.http.context;

//TODO#3 - Context에 접근할 수 있도록 ContextHolder를 Singleton 구현 합니다.
public class ContextHolder {
    private Context context;

    public static synchronized ApplicationContext getApplicationContext() {
        return null;
    }
}
