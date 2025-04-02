/*

    -------------ANNOTATIONS---------------------

    1. @SpringBootApplication
    This annotation is used at the entry point of a Spring Boot application.
    
    Example:
   ------------------------------------------------------------------------------
   |  import org.springframework.boot.SpringApplication;                        |
   |  import org.springframework.boot.autoconfigure.SpringBootApplication;      |
   |  @SpringBootApplication                                                    |
   |  public class MySpringBootApplication {                                    |
   |    public static void main(String[] args) {                                |
   |        SpringApplication.run(MySpringBootApplication.class, args);         |
   |    }                                                                       |
   |  }                                                                         |
   |                                                                            |
   ------------------------------------------------------------------------------
   This class serves as the main entry point for a Spring Boot application.


    2. @Controller
    This annotation is used to define a Spring MVC controller. It is a specialization of @Component, meaning Spring will detect and manage this class.
    Example:
   __________________________________________________________________________________
   |   import org.springframework.stereotype.Controller;                             |
   |   import org.springframework.ui.Model;                                          |
   |   import org.springframework.web.bind.annotation.GetMapping;                    |
   |   @Controller                                                                   |
   |   public class MyController {                                                   |
   |         public String sayHello() {                                              |
   |             model.addAttribute("message", "Hello, World!");                     |
   |             return "hello"; // This refers to a view (hello.html or hello.jsp)  |
   |         }                                                                       |
   |   }                                                                             |
   |                                                                                 |
   ___________________________________________________________________________________
   This method handles requests for /hello and returns a view named hello.


   3. @RequestMapping
    This annotation is used to map web requests to specific handler methods or classes. It can be applied at the class level (to set a base path) or at the method level (to handle specific requests)
    Example:

    ________________________________________________________________________
    |    import org.springframework.web.bind.annotation.RequestMapping;    |
    |    import org.springframework.web.bind.annotation.RestController;    |
    |                                                                      |
    |    @Controller                                                       |
    |    public class ApiController {                                      |
    |        @RequestMapping("/greet")                                     |
    |        public String greet() {                                       |
    |            return "Hello from API!";                                 |
    |        }                                                             |
    |   }                                                                  |
    |                                                                      |
    ________________________________________________________________________
    The endpoint /api/greet will return "Hello from API!".

    4. @ResponseBody
    This annotation is used when we want the method’s return value to be directly written as the HTTP response (instead of rendering a view). It is typically used in REST APIs.
    Example:

    _________________________________________________________________________
    |    import org.springframework.web.bind.annotation.GetMapping;        |
    |    import org.springframework.web.bind.annotation.RequestParam;      |
    |   import org.springframework.web.bind.annotation.ResponseBody;       |
    |    import org.springframework.web.bind.annotation.RestController;    |
    |                                                                      |
    |    @Controller                                                       |
    |    public class MyRestController {                                   |
    |                                                                      |
    |        @GetMapping("/welcome")                                       |
    |        @ResponseBody                                                 |
    |        public String welcome() {                                     |
    |            return "Welcome, Veer!";                                  |
    |        }                                                             |
    |    }                                                                 |
    |                                                                      |
    ________________________________________________________________________
    When you hit http://localhost:8080/welcome, it returns:
    "Welcome, Veer!" as plain text (instead of a view).
    
*/
