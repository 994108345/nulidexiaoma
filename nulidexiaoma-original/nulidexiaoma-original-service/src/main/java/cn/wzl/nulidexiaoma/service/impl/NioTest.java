package cn.wzl.nulidexiaoma.service.impl;

import org.junit.Test;
import org.springframework.data.mongodb.core.mapping.TextScore;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Selector;

/**
 * Created by 99410 on 2018/8/28.
 */
public class NioTest {
    @Test
    public void selectTest() throws IOException {
        CharBuffer charBuffer = CharBuffer.allocate(100);

        Selector selector = Selector.open();

    }

}
