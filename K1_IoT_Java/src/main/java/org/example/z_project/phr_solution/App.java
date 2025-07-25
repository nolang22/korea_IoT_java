package org.example.z_project.phr_solution;

/*  === PHR (개인 건강 기록, Personal Health Record) 솔루션 ===

    1. 프로젝트 개요
    - 개인 건강 기록(PHR) 솔루션을 위한 간단한 콘솔 기반 응용 프로그램
    - 환자의 기본 정보를 관리, 환자의 건강 기록 등록, 수정, 조회 기능
    - 특정 조건에 맞는 건강 기록을 필터링하고 집계 기능

    2. 주요 기능 & 비즈니스 로직
    - 환자 정보 관리(Patient) : CR(단건/전체)UD
    - 건강 기록 관리 (HealthRecord): CRUD + 필터링 (조회)

    3. 비즈니스 로직 구조
    - controller: 사용자 입력 처리 + 알맞은 서비스 메서드 호출
    - service: 핵심 비즈니스 로직 수행
    - repository: 데이터 저장소 (DB)와의 상호 작용 담당
    = dto: 계층 간 데이터 전송을 위한 객체
    - entity: 데이터 저장소(DB)의 테이블과 매핑(연결)되는 도메인 객체

    4. 실행 및 관리
    - App.java: 프로그램 실행 진입점, 사용자와의 상호작용을 관리하고 전체 흐름을 제어
              >> App.java가 사용자 입력 처리, 메뉴 출력, 흐름 제어 모두 담당 -> SRT 위반( 단일 책임 원칙)
              >> handler + App.java로 구분

 */

import org.example.z_project.phr_solution.controller.HealthRecordController;
import org.example.z_project.phr_solution.controller.PatientController;
import org.example.z_project.phr_solution.dto.health_record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.health_record.response.RecordListResponseDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.handler.InputHandler;
import org.example.z_project.phr_solution.handler.MenuPrinter;
import org.example.z_project.phr_solution.util.DateValidator;

import java.util.List;

public class App {
    private static final PatientController patientController = new PatientController();
    private static final HealthRecordController healthRecordController = new HealthRecordController();

    private static boolean processChoice(int choice) {
        switch (choice) {
            //환자 관련 기능
            case 1 -> {
                PatientCreateRequestDto requestDto = InputHandler.createPatientRequest();

                if (requestDto == null) {
                    System.out.println("필수 입력값을 유효하게 입력해야합니다.");
                    break;
                }
                patientController.registerPatient((requestDto));
            }
            case 2 -> {
                List<PatientListResponseDto> patients = patientController.getAllPatients();
                if (patients.isEmpty()) {
                    // 빈 배열
                    System.out.println("환자 정보가 없습니다.");
                } else {
                    patients.forEach(System.out::println);
                }
            }
            case 3 -> {
                Long id = InputHandler.getIdInput();
                PatientDetailResponseDto patient = patientController.getPatientById(id);

                if (patient == null) {
                    System.out.println("해당 하는 ID의 환자가 없습니다.");
                } else {
                    System.out.println(patient);
                }
            }
            case 4 -> {
                long id = InputHandler.getIdInput();
                PatientUpdateRequestDto requestDto = InputHandler.UpdatePatientRequest();

                if (requestDto == null) {
                    System.out.println("필수 입력값을 유효하게 입력해야합니다.");
                    break;
                }

                patientController.updatePatient(id, requestDto);
            }
            case 5 -> {
                long id = InputHandler.getIdInput();
                patientController.deletePatient(id);
            }

            // 건강 기록 관련 기능

            case 6 -> {
                RecordCreateRequestDto requestDto = InputHandler.createRecordRequestDto();

                if (requestDto == null) {
                    System.out.println("필수 입력값을 유효하게 입력해야합니다.");
                    break;
                }

                healthRecordController.createRecord(requestDto);
            }
            case 7 -> {
                List<RecordListResponseDto> records = healthRecordController.getAllRecords();

                if (records.isEmpty()) {
                    System.out.println("건강 기록이 없습니다.");
                } else {
                    records.forEach(System.out::println);
                }
            }
            case 8 -> {
                String diagnosisFilter = InputHandler.getInput("필터 조건 (진단명)");
                List<RecordListResponseDto> filteredRecords = healthRecordController.filterRecordsByDiagnosis(diagnosisFilter);

                if (filteredRecords.isEmpty()) {
                    System.out.println("검색 결과를 찾을 수 없습니다.");
                } else {
                    filteredRecords.forEach(System.out::println);
                }
            }
            case 9 -> {
                Long id = InputHandler.getIdInput();
                healthRecordController.deleteRecord(id);
            }
            case 10 -> {
                System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
                return false;
            }
            case 11 -> { // 진단별 건강 기록 수 카운팅 (Map<string, Long>)

            }
            case 12 -> { // 특정 연형대 환자의 건강 기록 목록 (예 : 60대 이상)

            }
            case 13 -> { // 특정 기간 내 진료 기록 조회 (날짜 필터링)

            }
            case 14 -> { // 가장 많이 진단 된 질병 Top 3

            }

            default -> System.out.println("잘못된 선택입니다. 유효한 메뉴를 선택해주세요.");

        }
        return true;
    }

    public static void main(String[] args) {
        try {
            while (true) {
                MenuPrinter.displayMune();
                int choice = InputHandler.getChoice();
                if (!processChoice(choice)) break; // processChoice의 반환값이 false면 로직 종료!
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //예외 발생 상관없이 반드시 실행 보장\
            InputHandler.closeScanner();
        }

    }
}
