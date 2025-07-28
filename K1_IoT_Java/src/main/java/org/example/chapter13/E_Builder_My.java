package org.example.chapter13;

/*  === 빌더(Builder) 패턴 === //
    : 소프트웨어 설계 패턴 중 하나
    - 객체 생성 방법
    - 복잡한 객체를 단계별로 만들 때 사용
    - 필드(속성)가 많거나, 필드에 필수값과 선택값이 섞여 있을 떄 유용

    1. 사용 목적
        : 생성자가 너무 많아질 떄
        : 코드가 복잡하고 읽기 어려울 떄

    2. 장던점
        1) 장점: 가독성 향상, 유연성 증가, 확장성 용이
        2) 단점: 구현 복잡성 증가, 작은객체 부적합

    3. 동작 원리
        1) 객체 생성 시 필요한 데이터를 저장하는 Builder 클래스를 생성
        2) Builder 클래스는 원하는 속성을 단께별로 설정할 수 있는 메서드를 제공
        3) builder() 메서드 호출하여 객체 생성

    4. 빌더 사용 방법 */

class MyPizza {
    // 필수 사항
    private final String menu; // 종류
    private final String size; // 크기

    // 선택 사항
    private final String cheese;
    private final String mushroom;
    private final String pepperoni;

//    public Pizza(String menu, String size) {
//        this.menu = menu;
//        this.size = size;
//
//        this.cheese = false;
//        this.mushroom = false;
//        this.pepperoni = false;
//    }
//
//    public Pizza(String menu, String size, boolean cheese, boolean mushroom, boolean pepperoni) {
//        this.menu = menu;
//        this.size = size;
//        this.cheese = cheese;
//        this.mushroom = mushroom;
//        this.pepperoni = pepperoni;
//    }


    // 1) Builder 클래스 정의 (Pizza 클래스 내부의 클래스)
    public static class Builder {
        // static: Pizza 클래스가 인스턴스화 되지 않을 때 내부 Builder 클래스로 인스턴스화 진행
        // 외부클래스명.내부클래스명();

        // 필수 필드: 반드시 초기화
        private final String menu;
        private final String size;

        // 선택 필드: 기본값 설정 (추가하지 않으면 해당 값으로 입력)
        private String cheese =  null;
        private String mushroom = null;
        private String pepperoni = null;

        //필드값 초기화
        public Builder(String menu, String size) {
            this.menu = menu;
            this.size = size;
        }

        //선택 값 지정 메서드
        public Builder addCheese(String str) {
            this.cheese =  str;
            return this; // this는 해당 클래스 타입의 객체 그자체!
        }

        public Builder addMushroom(String str) {
            this.mushroom = str;
            return this;
        }

        public Builder addPepperoni(String str) {
            this.pepperoni = str;
            return this;
        }

        // Builder 객체를 생성하는 Build 메서드
        // : 인스턴스 메서드 - 인스턴스.메서드명();
        public MyPizza build() {
            return new MyPizza(this);
        }

    }

    private MyPizza(Builder builder) {
        this.menu = builder.menu;
        this.size = builder.size;

        // add~() 메서드 호출 하지 않더라도 기본값 false 지정
        this.cheese = builder.cheese;
        this.mushroom = builder.mushroom;
        this.pepperoni = builder.pepperoni;
    }
    @Override
    public String toString() {
        return "피자 메뉴: " + menu + ", 사이즈: " + size + ", 치즈: " + cheese
                + ", 버섯: " + mushroom + ", 페페로니: " +  pepperoni;
    }
}

public class E_Builder_My {
    public static void main(String[] args) {
        // Pizza noBuilderPizza = new Pizza("파인애플 피자", "L", false, false, false;

        MyPizza builderPizza12 = new MyPizza.Builder("고구마 피자", "M").build();

        MyPizza optionalPizza12 = new MyPizza.Builder("포테이토 피자", "S") // Builder 인스턴스 생성
                .addCheese("많이") // Builder 인스턴스 메서드 - 반환 Builder 객체
                .addMushroom("많이") // Builder 인스턴스 메서드 - 반환 Builder 객체
                .build(); // Builder 인스턴스 메서드 - 반환 Pizza 객체

        MyPizza optionalPizza22 = new MyPizza.Builder("쉬림프 피자", "L")
                .addPepperoni("조금")
                .build();

        System.out.println(builderPizza12);
        System.out.println(optionalPizza12);
        System.out.println(optionalPizza22);


        // cf) 메서드 체이닝
        //      : 메서드 호출 뒤 반환되는 데이터에 곧바로 추가 메서드를 호출
        //      : 객체를 연결고리로 메서드(함수)를 지속적으로 호출
    }
}
