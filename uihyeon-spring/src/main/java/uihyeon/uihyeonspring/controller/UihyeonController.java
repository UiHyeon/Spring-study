package uihyeon.uihyeonspring.controller;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UihyeonController {

    @GetMapping("hello")
    public String uihyeon(Model model){
        model.addAttribute("data", "hello!!!");
        return "hello";
    }

    @GetMapping("uihyeon-mvc")
    public String uihyeonMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "uihyeon-template";
    }

    @GetMapping("uihyeon-string")
    @ResponseBody
    public String uihyeonString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("uihyeon-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
