package org.example.enumtest;

public enum SeasonEnum implements SeasonInterface{

    SPRING("Chun") {
        public void info() {
            System.out.println("Chun");
        }
    },
    SUMMER("Xia") {
        public void info() {
            System.out.println("Xia");
        }
    },
    FALL("Qiu") {
        public void info() {
            System.out.println("Qiu");
        }
    },
    WINTER("Dong") {
        public void info() {
            System.out.println("Dong");
        }
    };

    private SeasonEnum(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return this.name;
    }


    public static void main(String[] args) {
        for (var  s : SeasonEnum.values() ) {
            s.info();
            System.out.println(s.name);;
            System.out.println(s.toString());
            System.out.println(s.name());
            System.out.println(s.ordinal());
        }
    }
//    normally, we will not provide same logic for all instances
//    @Override
//    public void info() {
//        System.out.println("info method");
//    }
}

interface SeasonInterface {
    void info();
}




