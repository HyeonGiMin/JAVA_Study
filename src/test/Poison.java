package test;

public class Poison extends Product {
    int damage;

    public Poison(String pname, int price, int damage){
        this.pname=pname;
        this.price=price;
        this.damage=damage;
    }

    @Override
    public void printExtra() {
        System.out.println("효과 "+damage+ "만큼 악화");
    }
}
