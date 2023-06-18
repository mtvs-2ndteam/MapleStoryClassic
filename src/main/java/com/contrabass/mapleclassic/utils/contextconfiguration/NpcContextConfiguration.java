package com.contrabass.mapleclassic.utils.contextconfiguration;

import com.contrabass.mapleclassic.application.view.NpcView;
import com.contrabass.mapleclassic.domain.entity.JobDTO;
import com.contrabass.mapleclassic.domain.entity.NpcQuestDTO;
import com.contrabass.mapleclassic.domain.service.JobService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
public class NpcContextConfiguration {

    @Bean
    @Scope("prototype")
    public NpcView npcView() {
        return new NpcView(jobService());
    }

    @Bean
    public JobService jobService() {
        JobService jobService = new JobService();

        JobDTO warrior = new JobDTO(1, "전사", "강한 힘을 지닌 전사입니다.");
        jobService.addJob(warrior);

        JobDTO mage = new JobDTO(2, "마법사", "강력한 마법을 사용하는 마법사입니다.");
        jobService.addJob(mage);

        JobDTO thief = new JobDTO(3, "도적", "표창과 단검을 쓰는 도적입니다");
        jobService.addJob(thief);

        JobDTO archer = new JobDTO(4, "궁수", "활을 쏘는 궁수입니다.");
        jobService.addJob(archer);

        return jobService;

    }


//

}
