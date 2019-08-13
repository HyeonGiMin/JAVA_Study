package Example;

public class ShopLuncher {

	public static void main(String[] args) {
		Management shop=new MyCredit();
		shop.setTitle("MyWinterClass");
		shop.genUser();
		shop.genProduct();
		shop.start();
	}

}
