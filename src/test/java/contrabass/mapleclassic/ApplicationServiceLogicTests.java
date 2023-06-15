package contrabass.mapleclassic;

import com.contrabass.mapleclassic.application.controller.GameController;
import com.contrabass.mapleclassic.utils.MainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class ApplicationServiceLogicTests {
    private GameController gameController;
    private MainException mainException;

    @BeforeEach
    public void setUp() {
        this.gameController = CONTEXT.getBean("gameController",
                GameController.class);
        this.mainException = CONTEXT.getBean("mainException",
                MainException.class);
    }

    @DisplayName("게임을 실행하는 테스트")
    @Test
    public void executeGameTest() {
        
    }

    @DisplayName("0~9 정수 이외의 값 입력 시 예외 발생하는 테스트")
    @Test
    public void inputExceptionTest() {
        String input = "98";
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mainException.validateInputValue(input)
        );
    }
}
