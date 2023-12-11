package nacos.provider.controller;

import nacos.provider.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/service/hello")
    public String hello(){
        return "hello Spring Cloud. Provider";
    }

    @RequestMapping("/service/user")
    public User user(){
        User user = new User();
        user.setId(1);
        user.setName("Tony");
        return user;
    }

    @GetMapping("/service/getUser")
    public User getUser(@RequestParam("id") Integer id, @RequestParam("name") String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    @PostMapping("/service/setUser")
    public User setUser(@RequestParam("id") Integer id, @RequestParam("name") String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    @PutMapping("/service/updateUser")  // @RequestMapping(value="/web/setUser", method = RequestMethod.PUT)
    public User updateUser(@RequestParam("id") Integer id, @RequestParam("name") String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    @DeleteMapping("/service/delUser")  // @RequestMapping(value="/web/setUser", method = RequestMethod.DEL)
    public User delUser(@RequestParam("id") Integer id, @RequestParam("name") String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }
}
