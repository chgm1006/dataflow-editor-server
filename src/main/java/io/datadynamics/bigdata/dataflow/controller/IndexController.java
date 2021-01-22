package io.datadynamics.bigdata.dataflow.controller;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/service")
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
//    @Autowired
//    FreeMarkerConfigurer configurer;

//    @GetMapping("/index")
//    public ResponseEntity index() throws IOException, TemplateException {
//        Template template = configurer.getConfiguration().getTemplate("blogpost.ftl");
//        Map<String, String> message = new HashMap<>();
//        message.put("message", "Hello, World");
//        template.process(message, new StringWriter());
//        System.out.println(template.getSourceName());
//        return ResponseEntity.ok().build();
//    }
//
    @GetMapping("/index")
    public String index(Map model) throws IOException, TemplateException {
        model.put("message", "World");
        logger.info("model :: {}", model);
        return "blogpost";
    }

}
