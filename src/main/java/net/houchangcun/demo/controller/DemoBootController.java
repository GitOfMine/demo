package net.houchangcun.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boot")
public class DemoBootController {
    @RequestMapping("/")
    public String index() {
        return "index page";
    }
    @RequestMapping("/greeting")
    public String greeting() {
        return "Hello, world!";
    }

    /**
     * 在Web应用中URL通常不是一成不变的，例如微博两个不同用户的个人主页对应两个不同的URL:http://weibo.com/user1，http://weibo.com/user2。
     * 我们不可能对于每一个用户都编写一个被@RequestMapping注解的方法来处理其请求，Spring MVC提供了一套机制来处理这种情况：
     * @param xxy
     * @return
     */
    @RequestMapping("/users/{username}")
    public String userProfile(@PathVariable("username") String username) {
        return String.format("user %s", username);
    }
    @RequestMapping("/posts/{id}")
    public String post(@PathVariable("id") int id) {
        return String.format("post %d", id);
    }
    /**
     * 在上述例子中，URL中的变量可以用{variableName}来表示，同时在方法的参数中加上@PathVariable("variableName")，
     * 那么当请求被转发给该方法处理时，对应的URL中的变量会被自动赋值给被@PathVariable注解的参数（能够自动根据参数类型赋值，例如上例中的int）。
     */

    /**
     * 对于HTTP请求除了其URL，还需要注意它的方法（Method）。
     * 例如我们在浏览器中访问一个页面通常是GET方法，而表单的提交一般是POST方法。@Controller中的方法同样需要对其进行区分：
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "Login GET";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost() {
        return "login POST";
    }
}
