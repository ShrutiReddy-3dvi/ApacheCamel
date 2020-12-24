package com.camel.poc.routes;

import org.apache.camel.builder.RouteBuilder;

public class CamelRouteToCopyFiles extends RouteBuilder{
    @Override
    public void configure() throws Exception {
from("file:data/input?noop=true")
        .to("log:?level=INFO&showBody=true&showHeaders=true")
        .to("file:data/output");
    }
}
