package com.shengwang.example.server;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.Main;

public class ServerRoute extends RouteBuilder {
    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void configure() throws Exception {
        from("netty:tcp://localhost:7000?sync=true&allowDefaultCodec=false&encoder=#stringEncoder&decoder=#stringDecoder")
                .to("bean:echoService");
    }
}