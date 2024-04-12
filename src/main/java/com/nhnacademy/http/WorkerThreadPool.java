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

package com.nhnacademy.http;

import com.nhnacademy.http.channel.RequestChannel;

public class WorkerThreadPool {
    private final int poolSize;

    private final static int DEFAULT_POOL_SIZE=5;

    private final Thread[] workerThreads;
    private final RequestChannel requestChannel;

    public WorkerThreadPool(RequestChannel requestChannel){
        this(DEFAULT_POOL_SIZE, requestChannel);
    }
    public WorkerThreadPool(int poolSize, RequestChannel requestChannel) {
        //TODO#1 poolSize <1 다면 IllegalArgumentException이 발생합니다.

        this.poolSize = poolSize;
        this.requestChannel = requestChannel;
        //TODO#2 requestChannel을 이용하여 httpRequestHandler 객체를 생성 합니다.
        HttpRequestHandler httpRequestHandler = null;

        //TODO#3 workerThreads를 초기화 합니다. poolSize 만큼 Thread를 생성 합니다.
        workerThreads = null;

    }
    public void start(){
        //TODO#4 workerThreads에 초가화된 모든 Thread를 start 합니다.

    }
}
