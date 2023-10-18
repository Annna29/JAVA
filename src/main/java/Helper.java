

public class Helper {
    int number;

    public Helper() {
    }

    public Helper(int number) {
        this.number = number;
    }

    public void printnumber(int number){
        System.out.println(number);
    }


    public static void printMessage(Integer integer){
        System.out.println("heiii");
    }

    @Override
    public String toString() {
        return "Helper{" +
                "number=" + number +
                '}';
    }



}
