package Chapter_10;

public class MainClass {
    public static void main(String arg[]){
        takesLambda("Hello", new PrinterInterface1() {
            @Override
            public void printText(String text) {
                System.out.println(text);
            }
        });
    }
    public static void takesLambda(String value, PrinterInterface1 interface1){
        interface1.printText(value);
    }
}
interface PrinterInterface1{
    void printText(String text);
}
