package com.camel.poc;

import com.camel.poc.routes.CamelRouteToCopyFiles;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelRouteToCopyFilesTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new CamelRouteToCopyFiles();
    }
    @Test
    public void checkFilesExistsInOutputDirectory() throws InterruptedException {
        Thread.sleep(5000);
        File file=new File("data/output");
        assertEquals(2,file.listFiles().length);
        assertTrue(file.isDirectory());
    }
}
