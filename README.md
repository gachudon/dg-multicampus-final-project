# Project DeukGeun

## 소개: 
헬스장들과 운동을하고자 하는 일반인들을 연결해주는 플랫폼

## 목적: 
헬스장에 대한 수요가 늘어남에 따른 *문제점*을 보완하기 위해 제작

### 문제 1) 내방 상담을 통해 헬스장에 대한 상세 정보와 결제를 해야하는 불편함
- HTTPS인증을 받아 카카오맵의 GeoCoder를 활용한 이용자의 현재 위치 기반 데이터를 활용해 헬스장 추천
- 실시간 채팅 기능으로 빠르게 헬스장과 일반인이 상담 진행 가능
- 포트원 결제 API를 활용해 다양한 결제 방법으로 회원권/PT를 온라인으로 결제 가능

### 문제 2) 개인 운동 또는 PT에 대한 기록이 어려움
- 실제 헬스장에서는 종이에 기록하거나 Excel을 사용해 PT 내용을 기록
- 이를 보완하기 위해 PT 트레이너가 기록할 수 있는 PT 캘린더와 일반인이 개인운동을 기록할 수 있는 운동일지 기능 구현

### 문제 3) 개인정보를 노출 하면서 트레이너와 대화하기 꺼려하는 일반인들의 고민
- 개인적인 사유로 연락이 오거나 개인정보를 노출하고 싶지 않아하는 운동자들이 많음
- 실시간 채팅 기능을 통해 PT 일정, 식단 관리, PT 트레이너의 일정 조회 등 유용한 기능 구현

### 문제 4) 헬스장 이용자들의 급증에 따른 데이터 관리의 어려움, 그리고 급증하는 헬스장 공급에 의해 새로운 회원의 유입이 어려움
- 회원 데이터를 ChartJS를 활용해 시각화 하여 헬스장 운영자들에게 유용한 인사이트를 제공
- '득근'의 헬스장 상세정보, 실시간 채팅 등을 활용해 온라인 마케팅 수단으로 사용 가능

## 주기능: 
- 헬스장 조회 (카카오 맵 API)
- 실시간 채팅 (RabbitMQ, STOMP)
- 회원권/PT 온라인 결제 (포트원 API)
- 운동 캘린더 (FullCalendar)
- 회원 데이터를 활용한 데이터 시각화 및 인사이트 제공 (ChartJS)
