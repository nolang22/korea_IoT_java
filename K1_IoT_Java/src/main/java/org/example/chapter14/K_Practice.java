package org.example.chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*  == 직원 관리 시스템 == //

    직원 데이터 정의
 */
@AllArgsConstructor //@Setter 역할
@Getter
@ToString
class Employee {
    private String department; // 부서
    private String name; // 직원명
    private int salary; // 급여
}

public class K_Practice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("IT", "이승승", 300),
                new Employee("HR", "조승승", 500),
                new Employee("IT", "김준준", 400),
                new Employee("OP", "전예예", 350),
                new Employee("HR", "윤대대", 380)
        );
        // 1. 급여가 400 이상인 직원 '필터링'
        // : filter() - 조건을 검사해서 true인 요소만을 다시 반환
        List<Employee> filterEmployee = employees.stream()
                .filter(employee -> employee.getSalary() >= 400)
                .collect(Collectors.toList());

        System.out.println("\n" + "== 급여가 400 이상");
        filterEmployee.forEach(System.out::println);


        // 2. IT 부서 직원의 이름만 추출
        // 1) 부서(department)가 'IT'인 직원을 필터링 - filter
        // 2) 부서가 'IT'인 직원 목록을 전체 순회하여 이름만 추출 - map

        List<String> itEmployeeNames = employees.stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                // .map(e -> e.getName())
                .map(Employee::getName)
                .collect(Collectors.toList());


        System.out.println("\n" + "== 부서가 'IT'인 직원 ");
//        itEmployeeNames.forEach(System.out::println);
        System.out.println(itEmployeeNames);


        // 3. 특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 필터링
        // 1) 부서가 'HR'인 직원을 필터링 >> equals
        // 2) 위의 목록 중 이름에 '조'가 포함된 직원을 필터링 >> contains

        List<Employee> employeeWithJo  = employees.stream()
                .filter(employee -> employee.getName().contains("조"))
                .filter(employee -> employee.getDepartment().equals("HR"))
                .collect(Collectors.toList());


        System.out.println("\n" + "== 이름에 '조'가 있고, 부서가 'HR'인 직원");
        employeeWithJo .forEach(System.out::println);


        // 4. 부서별 직원 그룹화
        // Collectors 클래스 - groupingBy
        //      >> Map 인터페이스 반환

        Map<String, List<Employee>> employeeByDept = employees.stream()
//                .collect(Collectors.groupingBy(e -> e.getDepartment()));
                .collect(Collectors.groupingBy(Employee::getDepartment));

//        groupedName.forEach((key, group) -> {
//            System.out.println(key + ": " + group);
//        });

        System.out.println("\n" + "== 부서별 직원 그룹화");
        System.out.println(employeeByDept);


        System.out.println("\n" + "== 부서별 직원 그룹화 forEach문");
        for (Map.Entry<String, List<Employee>> entry : employeeByDept.entrySet()) {
            String department = entry.getKey();
            List<Employee> employeeInDept = entry.getValue();

            System.out.print(department + ": ");
            for (Employee employee : employeeInDept) {
                System.out.print(employee.getName() + " ");
            }
            System.out.println();
        }

        System.out.println("\n" + "== 부서별 직원 그룹화 stream");
        employeeByDept.forEach((department, employeeInDept) -> {
            String name = employeeInDept.stream()
                    .map(Employee::getName)
                    .collect(Collectors.joining(" "));
            System.out.println(department + ": " + name);
        });


        // 5. 부서별(그롭화) 평균 급여 계산
        //Collectors 클래스 - groupingBy
        //                 - averaging 타입: 해당 타입의 평균을 계산(averagingInt(각 직원의 급여 전달))
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)
                ));

        System.out.println("부서별 평균 급여");
        System.out.println("\n" + avgSalaryByDept);
    }
}
