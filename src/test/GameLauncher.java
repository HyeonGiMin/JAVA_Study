package test;



public class GameLauncher {

	public static void main(String[] args) {

		PShop shop = new MyShop();
		shop.setTitle("MyShop");
		shop.genUser();
		shop.genProduct();

		shop.start();
	}

}
