package org.example;

public class SwitchWithJDK17Test {

    public void switchCharTest(char c) {
        switch (c) {
            case 'A':
                System.out.println("优秀");
                break;

            case 'B':
                System.out.println("良好");
                break;
            case 'C':
                System.out.println("中");
                break;
            case 'D':
                System.out.println("及格");
                break;
            case 'F':
                System.out.println("不及格");
                break;
            default:
                System.out.println("成绩输入错误");
        }
    }

    public void switchStringTest(String s) {
        switch (s) {
            case "春天":
                System.out.println("春天");
                break;

            case "夏天":
                System.out.println("夏天");
                break;
            case "秋天":
                System.out.println("秋天");
                break;
            case "冬天":
                System.out.println("冬天");
                break;
            default:
                System.out.println("季节输入错误");
        }
    }

    public void switchStringWithJDK17Test0(String s) {
            switch (s) {
                case "春天", "夏天" :
                    System.out.println("春天 或者 夏天");
                    break;
                case "秋天" :
                    System.out.println("秋天");
                    break;
                case "冬天" :
                    System.out.println("冬天");
                    break;
                default:
                    System.out.println("季节输入错误");
            }
    }

    public void switchStringWithJDK17Test1(String s) {
        switch (s) {
            case "春天", "夏天" ->
                System.out.println("春天 或者 夏天");
            case "秋天" ->
                System.out.println("秋天");
            case "冬天" ->
                System.out.println("冬天");
            default ->
                System.out.println("季节输入错误");
        }
    }

    public String switchStringWithJDK17Test2(String s) {
        var result = switch (s) {
            case "春天", "夏天" -> "春天 或者 夏天";
            case "秋天" -> "秋天";
            case "冬天" -> "冬天";
            default -> "季节输入错误";
        };
        return result;
    }

    public String switchStringWithJDK17Test3(String s) {
        var result = switch (s) {
            case "春天", "夏天" -> {
                    System.out.println("春天 或者 夏天");
                    yield "春天 或者 夏天";
            }
            case "秋天" -> {
                    System.out.println("秋天");
                    yield "秋天";
            }
            case "冬天" -> {
                    System.out.println("冬天");
                    yield "冬天";
            }
            default -> "季节输入错误";
        };
        return result;
    }

    public String switchStringWithJDK17Test4(String s) {
        var result = switch (s) {
            case "春天", "夏天":
                System.out.println("春天 或者 夏天");
                yield "春天 或者 夏天";
            case "秋天":
                System.out.println("秋天");
                yield "秋天";
            case "冬天":
                System.out.println("冬天");
                yield "冬天";
            default :
                System.out.println("季节输入错误");
                yield "季节输入错误";
        };
        return result;
    }

//    public static void main(String[] args) {
//        var score = 'C';
//        switch (score) {
//            case 'A':
//                System.out.println("优秀");
//                break;
//
//            case 'B':
//                System.out.println("良好");
//                break;
//            case 'C':
//                System.out.println("中");
//                break;
//            case 'D':
//                System.out.println("及格");
//                break;
//            case 'F':
//                System.out.println("不及格");
//                break;
//            default:
//                System.out.println("成绩输入错误");
//        }
//    }
}
