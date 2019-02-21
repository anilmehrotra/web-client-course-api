package course.api.client.springbootstarter.ms;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RemoteCourseRepository implements CourseRepository {

  @Autowired
  public RestTemplate restTemplate;
  
  protected String serviceUrl;

  public RemoteCourseRepository(String serviceUrl) {
    this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
  }

  @Override
  public List<Topic> getAllTopic() {
    List<Topic> listOfTopics = restTemplate.getForObject(serviceUrl+"/topics",List.class);
    return listOfTopics;
  }

  @Override
  public Topic getTopic(String id) {
    return restTemplate.getForObject(serviceUrl+"/topics/{id}", Topic.class, id);
  }

}
