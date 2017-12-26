package com.video.edu.me.controller;

import com.video.edu.me.entity.User;
import com.video.edu.me.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//你好，我是乐宝
//哼，我才是
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@ResponseBody
	private boolean create(User user) throws IllegalArgumentException, IllegalAccessException {
		/**
		 * 这里是创建一个user的方法
		 * 比方说，url请求http://localhost:8080/user/create?loginName=1&password=2&roleId=1&status=0，
		 * 会自动根据url参数的名字和这个create方法中的User的属性对应来赋值
		 * 调用service层的userService的insertSelective方法，这里userService就是一个bean
		 *
		 * 乐宝可以看到上面它的定义是UserService userService，原本只是这样定义的话，userService的值应该就是null，因为没赋值
		 * 但因为spring发现了@Autowired这个注解，就先看看自己容器里有没有叫“userService”的bean，发现有，就注入到这个userService里了，它就不再是null
		 *
		 * 而spring知道自己有这个bean，是因为UserService这个类的脑袋上有个@Service注解，spring看到了这个注解，就实例化了一个UserService的bean在自己容器里
		 *
		 * 这里乐宝可以给代码打断点，用debug的方式运行上面我配好的tomcat，一层一层往里面看
		 * 注意！IDEA的调试快捷键跟eclipse的不一样，F8是单步运行，F7是进入函数，F9是运行到下一个断点。退出是ctrl+F2
		 *
		 * 看代码的时候有几个很好用的快捷键，一个是ctrl+点击，IDEA里这样几乎什么都能看，变量啊配置啊，反正哪里不会点哪里
		 * 然后是ctrl+f，按这个上面会出来一个框框，它是当前页面搜索文本的，很灵活
		 * ctrl+shift+f，全局搜索文本，注意搜索框下面有个路径，表示你在哪个目录下面全局搜索
		 * 连按两下shift，search everywhere，就是到处搜，不过有时候可能不灵
		 * 然后是ctrl+alt+左箭头，可以回到乐宝上一次看的地方，右箭头是相反的
		 *
		 * 现在，用ctrl+点看看这个insertSelective方法吧
		 *
		 * insertSelective和insert方法
		 */
		return userService.insertSelective(user) != 0;
	}

	/**
	 * find 方法
	 * 测试url:http://localhost:8080/user/find?id=1
	 * 前提是库里已经有了id为1的user
	 * @param id
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	private User find(int id) throws IllegalArgumentException, IllegalAccessException {
		return userService.selectByPrimaryKey(id);
	}

	/**
	 * delete 方法
	 * 测试url：http://localhost:8080/user/delete?id=2
	 * 前提是库里有id为2的user
	 * 这个方法service层的返回值是删除了元素则为1，没删除则为0
	 * @param id
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	private boolean delete(int id) throws IllegalArgumentException, IllegalAccessException {
		return userService.deleteByPrimaryKey(id) != 0;
	}
}

