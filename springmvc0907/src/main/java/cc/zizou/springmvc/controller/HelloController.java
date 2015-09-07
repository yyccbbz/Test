package cc.zizou.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import cc.zizou.springmvc.pojo.User;
import cc.zizou.springmvc.pojo.UserForm;

@RequestMapping("cc")
@Controller
public class HelloController {

    // 定义请求的url路径
    @RequestMapping("hello")
    public ModelAndView hello() {
        // 定义了响应的视图页面
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "我的第一个springmvc工程测试");
        return mv;
    }

    /**
     * 标准的url映射
     * 
     * @return
     */
    @RequestMapping(value = "/show")
    public ModelAndView show() {
        // 定义了响应的视图页面
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "标准的url映射");
        return mv;
    }

    /**
     * Ant风格的Url映射
     * 
     * ?,*,** 三种
     * 
     * @return
     */
    @RequestMapping(value = "test/*/show1")
    public ModelAndView show1() {
        // 定义了响应的视图页面
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "Ant风格的Url映射");
        return mv;
    }

    /**
     * 占位符映射
     * 
     * 获取参数@PathVariable
     * 
     * @return
     */
    @RequestMapping(value = "/user/{id}/{name}/query")
    public ModelAndView show2(@PathVariable("id") Long id, @PathVariable("name") String name) {
        // 定义了响应的视图页面
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "占位符映射---" + "id = " + id + ",name = " + name);
        return mv;
    }

    /**
     * 限定请求方法的映射
     * 
     * @return
     */
    @RequestMapping(value = "/user/{id}/{name}/find", method = RequestMethod.POST)
    public ModelAndView show3(@PathVariable("id") Long id, @PathVariable("name") String name) {
        // 定义了响应的视图页面
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "限定请求方法的映射---" + "id = " + id + ",name = " + name);
        return mv;
    }

    /**
     * 限制请求参数的映射
     * 
     * 获取请求参数@RequestParam(key-value形式的)
     * 
     */
    @RequestMapping(value = "/show4", params = { "id", "name" })
    public ModelAndView show4(@RequestParam("id") Long id, @RequestParam("name") String name) {
        // 定义了响应的视图页面
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "限制请求参数的映射---" + "id = " + id + ",name = " + name);
        return mv;
    }

    /**
     * 参数绑定 servlet内置对象,spring自动绑定
     * 
     * @return
     */
    @RequestMapping(value = "/show5")
    public ModelAndView show5(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        // 定义了响应的视图页面
        ModelAndView mv = new ModelAndView("hello");
        StringBuilder sb = new StringBuilder();
        sb.append("request = " + request + "<br/>");
        sb.append("response = " + response + "<br/>");
        sb.append("session = " + session + "<br/>");

        request.setAttribute("info", "测试request域中的参数值!!!");

        mv.addObject("msg", sb.toString());

        return mv;
    }

    /**
     * 获取cookie值 @CookieValue
     * 
     * @return
     */
    @RequestMapping(value = "/show6")
    public ModelAndView show6(@CookieValue("JSESSIONID") String sessionId) {
        // 定义了响应的视图页面
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "获取cookie值---sessionId = " + sessionId);
        return mv;
    }

    /**
     * POJO对象绑定
     */
    @RequestMapping(value = "/show7")
    public ModelAndView show7(User user) {
        // 定义了响应的视图页面
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "user = " + user);
        return mv;
    }

    /**
     * springmvc对java基本数据类型的绑定
     * 
     * @param name
     * @param age
     * @param income
     * @param isMarried
     * @param interests
     */
    @RequestMapping("/show8")
    // 无需跳转页面，直接返回200状态
    @ResponseStatus(value = HttpStatus.OK)
    public void show8(@RequestParam("name") String name, @RequestParam("age") Integer age,
            @RequestParam("income") Double income, @RequestParam("isMarried") Boolean isMarried,
            @RequestParam("interests") String[] interests) {
        System.out.println("简单数据类型绑定=========");
        System.out.println("名字:" + name);
        System.out.println("年龄:" + age);
        System.out.println("收入:" + income);
        System.out.println("已结婚:" + isMarried);
        System.out.println("兴趣:");
        for (String interest : interests) {
            System.out.println(interest);
        }
        System.out.println("====================");
    }

    /**
     * list集合绑定
     * 
     * @param userForm
     */
    @RequestMapping(value = "/show9")
    @ResponseStatus(value = HttpStatus.OK)
    public void show9(UserForm userForm) {
        System.out.println(userForm);
    }

    /**
     * 封装集合对象,传递到页面使用jstl <c:forEach>标签进行遍历输出
     * 
     * @return
     */
    @RequestMapping(value = "show10")
    public ModelAndView show10() {
        ModelAndView mv = new ModelAndView("users");
        List<User> users = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setUsername("username_" + i);
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("shanghai_" + i);
            users.add(user);
        }
        mv.addObject("users", users);
        return mv;
    }

    /**
     * springmvc 王牌功能
     * 
     * @ResponseBody 输出json
     * 
     * @return
     */
    @RequestMapping("user/list")
    @ResponseBody
    public List<User> queryUserList() {
        List<User> users = new ArrayList<User>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setId(i);
            user.setUsername("username_" + i);
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("shanghai_" + i);
            users.add(user);
        }
        return users;
    }

    /**
     * @RequestBody 
     * 接收一个json字符串,反序列化为一个pojo对象
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "show11")
    public ModelAndView show11(@RequestBody User user) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "user = " + user);
        return mv;
    }

    /**
     * @RequestBody 
     * 接收一个json字符串
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "show12")
    public ModelAndView show12(@RequestBody String json) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "json = " + json);
        return mv;
    }

}
