import org.example.engine.KeywordEngine;
import org.testng.annotations.Test;

public class LoginTest {
    KeywordEngine keywordEngine;

    @Test 
    public void LinkedinLoginTest(){
        keywordEngine = new KeywordEngine();
        keywordEngine.starExecution("LinkedinLogin");
    }
}
