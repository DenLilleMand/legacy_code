<?xml version="1.0" encoding="UTF-8"?>
<web-app id="WebApp_9" version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
         http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">

    <servlet>
        <servlet-name>HelloService</servlet-name>
        <servlet-class>com.zenjava.jfxee7.HelloServiceImpl</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>HelloService</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>

</web-app>