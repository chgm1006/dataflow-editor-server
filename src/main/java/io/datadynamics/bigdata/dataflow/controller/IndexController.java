package io.datadynamics.bigdata.dataflow.controller;

import freemarker.core.OutputFormat;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/service")
public class IndexController {
    @Autowired
    FreeMarkerConfigurer configurer;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @GetMapping("/blogpost")
    public ResponseEntity blogpost() throws IOException, TemplateException {
        Template template = configurer.getConfiguration().getTemplate("blogpost.ftl");
        Map<String, String> message = new HashMap<>();
        message.put("message", "Hello, World");
        template.process(message, new StringWriter());
        OutputFormat outputFormat = template.getOutputFormat();

        logger.info("template :: {}", outputFormat.toString());
        return ResponseEntity.ok().build();
    }

    //
    @GetMapping("/index")
    public ModelAndView index() throws IOException, TemplateException {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("name", "World");
        logger.info("mav :: {}", mav);
        return mav;
    }

}
