package course.api.client.springbootstarter.ms;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
  
  @Autowired
  public CourseRepository courseRepository;
  
  @GetMapping("/topics")
  public List<Topic> getTopics(){
    return courseRepository.getAllTopic();
  }
  
  @GetMapping("/topics/{id}")
  public Topic getTopic(@PathVariable("id") String id){
    return courseRepository.getTopic(id);
  }
  
}
