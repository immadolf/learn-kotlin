package org.adolf.kotlin.demo10;

import java.io.IOException;

/**
 * @author 40313
 * @date 2020/6/29
 * @since
 */
public class MyException {

    public void myMethod() throws IOException {
        throw new IOException("myMethod");
    }

}
