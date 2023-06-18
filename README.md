# MapleStoryClassic

## 기존에 존재하는 메이플스토리라는 게임의 컨셉을 따와 텍스트 RPG를 제작해본다.

## 역할
- 조만제 - 메인구조 / 맵
- 박현섭 - 전투 / 보스 / 몬스터
- 이유열 - 플레이어
- 김대철 - 회원가입 / 로그인
- 김지수 - NPC(예: 퀘스트)

## 요구사항
- 오로지 콘솔창에서만 동작하게 만들 것
- 입력은 Scanner 클래스를 사용하여 만들 것
- 기능을 제작할때는 꼭 branche를 만들어서 제작할 것
- branche의 이름은 꼭 feature/OOOOOO 로 제작할 것

## 게임의 기본 구조
- 플레이어의 기본 직업은 마법사이다. 
- 플레이어는 게임에 진입하고 첫번째 마을인 헤네시스에 도착하게 된다. 
- 플레이어는 여러가지 선택을 할 수 있다(예 : 1. 전투하기, 2. 마을 이동하기)
- 게임에는 총 4종류의 마을이 존재한다(순서대로 헤네시스, 커닝시티, 엘리니아, 페리온)
- 첫번째 마을인 헤네시스에서 다음 맵으로 이동하기 위해서는 각각의 맵마다 존재하는 보스를 격파하여야 다음 맵으로 이동할 수 있다.(예 : 헤네시스에 존재하는 자쿰이라는 보스를 격파해야 다음 맵으로 이동 가능) 이후에도 동일
- 각각의 마을마다는 총 4종류의 사냥터가 존재하고 사냥터마다 1종류씩의 몬스터가 존재한다.

## 회원가입
- ID, PW, 닉네임 3가지 값을 받아 회원가입 한다.
- 나중에 로그인 할때 사용

## 플레이어 
- 직업 : 마법사
- 레벨 : 1
- 경험치 : 기본값 100으로 레벨당 경험치 총량이 2배씩 늘어난다.
- HP : 기본값 1000
- MP : 기본값 100
- 메소 : 기본값 1000
- 스킬 : 메이플스토리 오마쥬
- 스탯 : 공격력(기본 공격에 영향을 받는다), 마력(스킬 공격에 영향을 받는다), 방어력, 크리티컬 확률, 크리티컬 데미지

## 플레이어 스탯
- 공격력 : 플레이어의 기본공격 데미지와 연관이 있다.
- 마력 : 플레이어의 스킬 공격 데미지와 연관이 있다.
- 방어력 : 플레이어가 몬스터에게 데미지를 받을 때 데미지 감소와 연관이 있다.
- 크리티컬 확률 : 플레이어의 기본 공격과 스킬 공격의 크리티컬 데미지 발생 확률과 연관이 있다.
- 크리티컬 데미지 : 플레이어가 확률적으로 크리티컬 공격을 행할때 추가되는 데미지와 연관이 있다.

## 게임에 존재하는 맵

### 헤네시스
- 보스 몬스터명 : 자쿰

### 커닝시티
- 보스 몬스터명 : 핑크빈

### 페리온
- 보스 몬스터명 : 루시드

### 엘리니아
- 보스 몬스터명 : 검은 마법사

## 맵에서 할 수 있는 것
- HP, MP 포션 구매/판매 (레벨에 따라 포션 가격 다름)
- 샤냥터 선택(각 맵마다 4가지의 샤낭터가 존재 각각 몬스터의 레벨이 다름)
- 전직 퀘스트 구현 (헤네시스 1차, 커닝시티 2차, 페리온 3차, 엘리니아 4차)
- 사우나(HP와 MP를 회복할 수 있는 지역, 프리미엄 5초/일반 10초, 레벨에 따라 가격 다름)

## 몬스터
- 메소와 경험치를 드랍한다.
- 몬스터명은 메이플스토리에서 따온다.

## 보스
- 일반 몬스터와 다르게 보스만의 전용 스킬을 사용하여 플레이어를 공격한다.
- 순서상 이전에 있는 맵에 존재하는 보스를 클리어 해야 다음 맵으로 진행이 가능하다.

## 기타
- 훈장 
- 장비(강화)

