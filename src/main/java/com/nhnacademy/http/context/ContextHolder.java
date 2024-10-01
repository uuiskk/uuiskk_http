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

package com.nhnacademy.http.context;

//TODO#3 - Context에 접근할 수 있도록 ContextHolder를 Singleton 구현 합니다.
public class ContextHolder {
    private static Context context;

    private ContextHolder(){

    }
    public static synchronized ApplicationContext getApplicationContext() {
        if(context == null){
            context = new ApplicationContext();
        }
        return (ApplicationContext) context;
    }
}
