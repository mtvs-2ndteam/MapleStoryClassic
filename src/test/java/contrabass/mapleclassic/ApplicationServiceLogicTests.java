package contrabass.mapleclassic;

import com.contrabass.mapleclassic.application.controller.GameController;
import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.utils.MainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class ApplicationServiceLogicTests {
    private GameController gameController;
    private MainView mainView;
    private MainException mainException;

    @BeforeEach
    public void setUp() {
        this.gameController = CONTEXT.getBean(
                "gameController", GameController.class);
        this.mainView = CONTEXT.getBean(
                "mainView", MainView.class);
        this.mainException = CONTEXT.getBean(
                "mainException", MainException.class);
    }

    @DisplayName("음수 입력 시 예외 발생 테스트")
    @Test
    public void inputExceptionTest1() {
        String input = "-1";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mainException.validateInputValue(input)
        );
    }

    @DisplayName("문자 입력 시 예외 발생 테스트")
    @Test
    public void inputExceptionTest2() {
        String input = "!@";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mainException.validateInputValue(input)
        );
    }

    @DisplayName("알파벳 입력 시 예외 발생 테스트")
    @Test
    public void inputExceptionTest3() {
        String input = "Ab";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mainException.validateInputValue(input)
        );
    }

    @DisplayName("공백 입력 시 예외 발생 테스트")
    @Test
    public void inputExceptionTest4() {
        String input = " ";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mainException.validateInputValue(input)
        );
    }

    @DisplayName("0을 맨 앞에 사용한 값 입력 시 예외 발생 테스트")
    @Test
    public void inputExceptionTest5() {
        String input = "08";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mainException.validateInputValue(input)
        );
    }

    @DisplayName("실수 입력 시 예외 발생 테스트")
    @Test
    public void inputExceptionTest6() {
        String input = "0.1";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mainException.validateInputValue(input)
        );
    }

    @DisplayName("값을 넣지 않고 엔터를 누를 경우(null) 예외 발생 테스트")
    @Test
    public void inputExceptionTest7() {
        String input = "";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mainException.validateInputValue(input)
        );
    }
}
