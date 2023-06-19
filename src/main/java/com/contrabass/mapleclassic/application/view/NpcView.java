package com.contrabass.mapleclassic.application.view;


import com.contrabass.mapleclassic.application.dto.PlayerDTO;
import com.contrabass.mapleclassic.domain.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;

public class NpcView {

    private final JobService jobService;

    @Autowired
    public NpcView(JobService jobService) {
        this.jobService = jobService;
    }

    public void npcSelectView() {
        System.out.println("안녕하세요. 1차 전직관 헬레나 입니다.");
        System.out.println("어떤 직업을 선택하시겠습니까?");
        System.out.println("========= 직업선택 =========");
        System.out.println("1. 전사");
        System.out.println("2. 마법사");
        System.out.println("3. 도적");
        System.out.println("4. 궁수");
        System.out.println("0. 마을 선택으로 돌아가기");
        System.out.print("메뉴 번호 입력: ");
    }

    public void JobSelect(PlayerDTO player, int jobNumber) {
        switch (jobNumber) {
            case 1:
                jobService.changeJob(player, 1); // 전사 직업으로 변경
                System.out.println("========== 직업확인 ==========");
                System.out.println("전사를 선택하셨습니다.");
                System.out.println("0. 마을로 돌아가기");
                break;
            case 2:
                jobService.changeJob(player, 2); // 마법사 직업으로 변경
                System.out.println("========== 직업확인 ==========");
                System.out.println("마법사를 선택하셨습니다.");
                System.out.println("0. 마을로 돌아가기");
                break;
            case 3:
                jobService.changeJob(player, 3); // 도적 직업으로 변경
                System.out.println("========== 직업확인 ==========");
                System.out.println("도적를 선택하셨습니다.");
                System.out.println("0. 마을로 돌아가기");
                break;
            case 4:
                jobService.changeJob(player, 4); // 궁수 직업으로 변경
                System.out.println("========== 직업확인 ==========");
                System.out.println("궁수를 선택하셨습니다.");
                System.out.println("0. 마을로 돌아가기");
                break;
            default:
                System.out.println("유효하지 않은 직업 번호입니다.");
                break;
        }

//        public void printWarriorSelect () {
//            System.out.println("========== 직업확인 ==========");
//            System.out.println("전사를 선택하셨습니다.");
//            System.out.println("0. 마을로 돌아가기");
//            System.out.print("메뉴 번호 입력: ");
//
//        }
//        public void printWizardSelect () {
//            System.out.println("========== 직업확인 ==========");
//            System.out.println("마법사를 선택하셨습니다.");
//            System.out.println("0. 마을로 돌아가기");
//            System.out.print("메뉴 번호 입력: ");
//
//        }
//        public void printAssassinSelect () {
//            System.out.println("========== 직업확인 ==========");
//            System.out.println("도적를 선택하셨습니다.");
//            System.out.println("0. 마을로 돌아가기");
//            System.out.print("메뉴 번호 입력: ");
//
//        }
//        public void printArcherSelect () {
//            System.out.println("========== 직업확인 ==========");
//            System.out.println("궁수를 선택하셨습니다.");
//            System.out.println("0. 마을로 돌아가기");
//            System.out.print("메뉴 번호 입력: ");
//
//        }

    }
}
