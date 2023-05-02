public class VendingMachineMainMain {
    public static void main(String[] args){
        VendingMachine vn1 = new VendingMachine();
        VendingMachine vn2 = new VendingMachine();

        String product = vn1.pushProductButton(100);
        System.out.println(product);
    }
}
