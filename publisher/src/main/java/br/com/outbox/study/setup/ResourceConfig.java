package br.com.outbox.study.setup;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Class comments go here...
 *
 * @author Renan Farias Silva
 * @version 1.0 09/11/2020
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.outbox.study")
public class ResourceConfig {
}
