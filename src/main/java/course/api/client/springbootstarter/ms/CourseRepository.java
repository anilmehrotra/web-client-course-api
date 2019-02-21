package course.api.client.springbootstarter.ms;

import java.util.List;

public interface CourseRepository {
   public List<Topic> getAllTopic();
   public Topic getTopic(String id);
}
