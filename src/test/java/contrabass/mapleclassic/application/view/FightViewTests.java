package contrabass.mapleclassic.application.view;

import com.contrabass.mapleclassic.application.controller.FightController;
import com.contrabass.mapleclassic.application.dto.MonsterDTO;
import com.contrabass.mapleclassic.application.view.FightView;
import com.contrabass.mapleclassic.utils.contextconfiguration.MonsterContextConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FightViewTests {

    FightView fightView;
    FightController fightController;

    ApplicationContext context;
    MonsterDTO monster;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(MonsterContextConfiguration.class);
        monster = context.getBean("henesysMonster1", MonsterDTO.class);
        fightView = context.getBean("fightView", FightView.class);
        fightController = context.getBean("fightController", FightController.class);
    }

//    @Test
//    public void fightViewTest1() {
//        fightController.entryFight(monster);
//    }
}
