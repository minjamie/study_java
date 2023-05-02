public class MathBeanTest {
    public static void main(String[] args){
        MathBean math = new MathBean(); // Heap 메모리에 올라감
        int x = math.getOne();
        System.out.println(x);
        math.printNumber(5000);
        int sum = math.plus(1,2);
        System.out.println(sum);
        math.printClassName();
    }
}
