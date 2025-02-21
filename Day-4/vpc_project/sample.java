import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
@RequestMapping("/")
class MyController {
    @GetMapping
    public String home() {
        return "<html>" +
                "<head><title>Welcome Page</title></head>" +
                "<body style='text-align:center; font-family:Arial, sans-serif;'>" +
                "<h1 style='color:blue;'>Welcome to My Java Web Application!</h1>" +
                "<p>This application is running on an AWS EC2 instance.</p>" +
                "<p>Enjoy exploring DevOps and Cloud Computing!</p>" +
                "</body></html>";
    }
}

