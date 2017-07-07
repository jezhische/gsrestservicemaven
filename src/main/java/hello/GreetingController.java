package hello;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ежище on 29.06.2017.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
//
//    @RequestMapping(value = "/{some message}", method = RequestMethod.GET)
//    public String message(@PathVariable("some message") String message) {
//        return message.isEmpty()? "Hou-ou, home page!" : String.format("Hey, %s, what's the matter?", message);
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/simple1")
    public String simple1() {
        return "simple";
    }

    @RequestMapping (method = RequestMethod.GET, value = "simple2")
    public ModelAndView simple2() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("simple");
        return mav;
    }
}
