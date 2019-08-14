package test;



public class GameLauncher {

	public static void main(String[] args) {

		pGame shop = new MyGame();
		shop.setTitle("MyShop");
		shop.genUser();
		shop.genProduct();
		shop.start();
	}

}
