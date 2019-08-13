package test;

public class Portion extends Product {
    int heal;

    public Portion(String pname, int price, int heal){
        this.pname=pname;
        this.price=price;
        this.heal=heal;
    }

    @Override
    public void printExtra() {
        System.out.println("효과 "+heal+ "만큼 회복");
    }
}
