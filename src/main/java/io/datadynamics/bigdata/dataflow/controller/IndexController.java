package io.datadynamics.bigdata.dataflow.controller;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.StringWriter;

@Controller
@RequestMapping("/service")
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();

    @RequestMapping("/blogpost")
    public String blogpost(Model model) throws IOException, TemplateException {
        Template template = configurer.getConfiguration().getTemplate("freemarker/blogpost.ftl");
//        Map<String, String> message = new HashMap<>();
        model.addAttribute("message", "Hello, 경민");
        StringWriter sw = new StringWriter();
        template.process(model, sw);

        logger.info("template.getSourceName() :: {}", template.getSourceName());
        logger.info("template.getName() :: {}", template.getName());
        logger.info("template :: {}", sw.toString());
        logger.info("model :: {}", model);
        return "blogpost";
    }

    //
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("name", "경민");
        logger.info("mav :: {}", mav);
        return mav;
    }

}
