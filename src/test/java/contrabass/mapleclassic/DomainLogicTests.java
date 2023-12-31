package contrabass.mapleclassic;

import com.contrabass.mapleclassic.application.dto.PlayerDTO;
import com.contrabass.mapleclassic.application.dto.SaunaDTO;
import com.contrabass.mapleclassic.domain.service.GameDomainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DomainLogicTests {
    private GameDomainService gameDomainService;
    private PlayerDTO player;

    private SaunaDTO saunaDTO;

    @BeforeEach
    public void setUp() {
        this.gameDomainService = new GameDomainService();
        this.player = new PlayerDTO();
        this.saunaDTO = new SaunaDTO();
    }

    @DisplayName("1~10까지 레벨 판단 테스트")
    @Test
    public void levelTest1() {
        int level = 10;

        Assertions.assertEquals("헤네시스",
                gameDomainService.judgeLevel(level));
    }

    @DisplayName("11~20까지 레벨 판단 테스트")
    @Test
    public void levelTest2() {
        int level = 14;

        Assertions.assertEquals("커닝시티",
                gameDomainService.judgeLevel(level));
    }

    @DisplayName("21~30까지 레벨 판단 테스트")
    @Test
    public void levelTest3() {
        int level = 23;

        Assertions.assertEquals("페리온",
                gameDomainService.judgeLevel(level));
    }

    @DisplayName("31이상 레벨 판단 테스트")
    @Test
    public void levelTest4() {
        int level = 35;

        Assertions.assertEquals("엘리니아",
                gameDomainService.judgeLevel(level));
    }

    @DisplayName("메소 부족 테스트")
    @Test
    public void lessMesoTest() {
        int meso = 3500;
        int standard = 4000;

        Assertions.assertEquals("실패",
                gameDomainService.judgeMeso(meso, standard));
    }

    @DisplayName("사우나 종류에 따른 회복 시간 테스트")
    @Test
    public void recoverTest() {
        saunaDTO.setPlayer(player);
        saunaDTO.setType("프리미엄");
        int time = 5;
        int time2 = 10;

        Assertions.assertEquals("성공",
                gameDomainService.recover(saunaDTO, time, 4000));

        saunaDTO.setType("일반");
        Assertions.assertEquals("성공",
                gameDomainService.recover(saunaDTO, time2, 2000));
    }
}
