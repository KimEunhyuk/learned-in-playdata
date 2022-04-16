package com.springmvc.tutorial.controller;

import com.springmvc.tutorial.model.Book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@RestController // ModelAndView를 활용하지 않는 형태
public class MainController {

    // (prefix)/index.(suffix)

    // localhost:8090
    @RequestMapping("/")
    public String init() {
        return "index"; // index.jsp 맵핑(application.properties참고.)
        // prefix(파일의 경로) + "index" + suffix(파일의 확장자)
        // localhost:8090/tutorial/src/main ~ /WEB-INF/index.jsp
    }

    // 2. ModelAndView.class
    // @RequestMapping("/add")
    // public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("/result");
    //     modelAndView.addObject("name", request.getParameter("name"));
    //     modelAndView.addObject("author", request.getParameter("author"));
        
    //     return modelAndView;
    // }

    // 3. ReqiestParam 방식, (HttpServletRequest보다 더 간소화된 형태)
    // @RequestMapping("/add")
    // public ModelAndView add(@RequestParam("name") String name, @RequestParam("author") String author) {

    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("result");

    //     modelAndView.addObject("name", name);
    //     modelAndView.addObject("author", author);

    //     return modelAndView;
    // }

    // 4. JSON 객체 반환 방식, @Controller -> @RestController로 변경.
    // @RestController = @Controller + @ResponseBody
    // method = RequestMethod.GET : defalut라 생략 가능
    @RequestMapping(value="/get", method = RequestMethod.GET)
    public Book getBook(@RequestParam("name") String name, @RequestParam("author") String author){

        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);

        return book;
    }
}