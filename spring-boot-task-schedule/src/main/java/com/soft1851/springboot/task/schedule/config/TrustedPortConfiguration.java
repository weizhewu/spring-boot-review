package com.soft1851.springboot.task.schedule.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zw_w
 * @Date: 2020/5/17 22:37
 * @Description:
 */
@Configuration
public class TrustedPortConfiguration {

    // 提供给外部接口使用的端口
    @Value("${server.port}")
    private String serverPort;

    @Value("${management.port:${server.port}}")
    private String managementPort;

    // 提供给内部接口使用的端口
    @Value("${server.trustedPort}")
//    @Value("${server.trustedPort:null}")
    private String trustedPort;

    @Bean
    public WebServerFactoryCustomizer servletContainer() {
        Connector[] additionalConnectors = this.additionalConnector();

        ServerProperties serverProperties = new ServerProperties();
        return new TomcatMultiConnectorServletWebServerFactoryCustomizer(serverProperties, additionalConnectors);
    }

    private Connector[] additionalConnector() {
        if (StringUtils.isEmpty(this.trustedPort) || "null".equals(trustedPort)) {
            return null;
        }

        Set<String> defaultPorts = new HashSet<>();
        defaultPorts.add(serverPort);
        defaultPorts.add(managementPort);

        if (!defaultPorts.contains(trustedPort)) {
            Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
            connector.setScheme("http");
            connector.setPort(Integer.valueOf(trustedPort));
            return new Connector[]{connector};
        } else {
            return new Connector[]{};
        }
    }

    private class TomcatMultiConnectorServletWebServerFactoryCustomizer extends TomcatServletWebServerFactoryCustomizer {
        private final Connector[] additionalConnectors;

        TomcatMultiConnectorServletWebServerFactoryCustomizer(ServerProperties serverProperties, Connector[] additionalConnectors) {
            super(serverProperties);
            this.additionalConnectors = additionalConnectors;
        }

        @Override
        public void customize(TomcatServletWebServerFactory factory) {
            super.customize(factory);

            if (additionalConnectors != null && additionalConnectors.length > 0) {
                factory.addAdditionalTomcatConnectors(additionalConnectors);
            }
        }
    }
}