import com.ssm.service.TeacherServiceTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by yang on 16/05/2017.
 */
public class JUnitRunner {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(TeacherServiceTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
