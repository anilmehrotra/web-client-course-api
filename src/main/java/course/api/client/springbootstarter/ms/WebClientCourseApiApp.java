package course.api.client.springbootstarter.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author anil.mehrotra
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WebClientCourseApiApp {
  
  public static final String courseServiceUrl = "http://COURSE-API-MICROSERVICE";
  
  public static void main(String[] args) {
        SpringApplication.run(WebClientCourseApiApp.class, args);
  }
  
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }
  
  @Bean
  public RemoteCourseRepository courseRepository(){
    return new RemoteCourseRepository(courseServiceUrl);
    
  }
}