package contrabass.mapleclassic;

import com.contrabass.mapleclassic.application.controller.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class ApplicationServiceLogicTests {
    private GameController gameController;

    @BeforeEach
    public void setUp() {
        this.gameController = CONTEXT.getBean("gameController",
                GameController.class);
    }

    @DisplayName("게임을 실행하는 테스트")
    @Test
    public void executeGameTest() {
        
    }
}
