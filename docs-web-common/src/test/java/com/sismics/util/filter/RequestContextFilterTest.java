package com.sismics.util.filter;

import junit.framework.TestCase;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;


public class RequestContextFilterTest extends TestCase {

    public void testDestroy() {
        RequestContextFilter filter = new RequestContextFilter();
        filter.destroy();
    }
}