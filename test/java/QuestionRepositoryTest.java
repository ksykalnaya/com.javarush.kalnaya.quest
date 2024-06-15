import com.example.quest.entity.Question;
import com.example.quest.repository.QuestionRepository;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class QuestionRepositoryTest {
    @Test
    public void getQuestions() throws IOException {
        List<Question> questions1 = QuestionRepository.getQuestions();
        List<Question> questions2 = QuestionRepository.getQuestions();
        List<Question> questions3 = List.of();
        Assert.assertNotNull(questions1);
        Assert.assertNotSame(questions3,questions1);
        Assert.assertEquals(questions2,questions1);
    }
}
