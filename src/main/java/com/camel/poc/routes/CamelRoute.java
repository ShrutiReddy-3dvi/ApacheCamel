package com.camel.poc.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.event.EventRecodingLogger;

public class CamelRoute  {


    public static void main(String[] args) throws Exception {
        Logger log=new EventRecodingLogger();

        CamelContext context=new DefaultCamelContext();
        try {
            context.addRoutes(new RouteBuilder() {

                @Override
                public void configure() throws Exception {
                    //?noop=true
                    from("file:data/input")
                        .to("file:data/output");
                }
            });
            context.start();
            Thread.sleep(5000);
            context.stop();
        }
        catch(Exception e){
            System.out.println("Exception is "+e);
e.printStackTrace();
        }
    }
}
