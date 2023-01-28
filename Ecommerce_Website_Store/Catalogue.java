package EcommerceWebsite;

public class Catalogue {
	private Product[] listofAllProducts;

	public Product[] getListofAllProducts() {
		Product product1 = new Product();
		product1.setProductId("1");
		product1.setProductName("Daawat Basmati Rice");
		product1.setCost("350");
		Product product2 = new Product();
		product2.setProductId("2");
		product2.setProductName("Daawat BrownBasmati Rice");
		product2.setCost("450");

		listofAllProducts = new Product[2];
		listofAllProducts[0] = product1;
		listofAllProducts[1] = product2;
		return listofAllProducts;
	}

	public void setListofAllProducts(Product[] listofAllProducts) {
		this.listofAllProducts = listofAllProducts;
	}
	public Product[] getListofAllProducts1() {
		Product product1 = new Product();
		product1.setProductId("1");
		product1.setProductName("Seller 1");
		product1.setCost(" ");
		Product product2 = new Product();
		product2.setProductId("2");
		product2.setProductName("Seller 2");
		product2.setCost(" ");
		listofAllProducts = new Product[2];
		listofAllProducts[0] = product1;
		listofAllProducts[1] = product2;
		return listofAllProducts;
	}
	public Product[] getSellerProducts() {
		Product product1 = new Product();
		product1.setProductId("1");
		product1.setProductName(" ");
		product1.setCost(" ");
		Product product2 = new Product();
		product2.setProductId("2");
		product2.setProductName("  ");
		product2.setCost("  ");
		listofAllProducts = new Product[2];
		listofAllProducts[0] = product1;
		listofAllProducts[1] = product2;
		return listofAllProducts;
	}


	public void setListofAllProducts1(Product[] listofAllProducts) {
		this.listofAllProducts = listofAllProducts;
	}
}
