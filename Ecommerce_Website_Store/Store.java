package EcommerceWebsite;

import java.util.Scanner;

/*
 * Ask which type of user are you? Customer, Seller, Administrator
 * User- Customer, Seller, Admin
 * Customer- View products, View cart, Contact Us.
 * View products- Add the product to the cart, View cart- Checkout.
 * Seller- View your products, Add a product, Contact Us
 * View your products- delete this product. Add a product- Submit details of the product.
 * Administrator- ...
 * Product
 * Category
 * Cart
 * Order
 */
public class Store {
	public static void main(String[] args) {
		System.out.println("Welcome to the Ecommerce store!");
		System.out.println("Which User are you? 1. Customer 2. Seller 3. Admin");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		String typeOfUser;
		if (choice == 1) {
			typeOfUser = "Customer";
			Customer current = new Customer();
			System.out.println("What is your userId?");
			sc.nextLine();
			current.setUserId(sc.nextLine());
			System.out.println("What is your passWord?");
			sc.nextLine();
			if (current.verifyUser() == true) {
				System.out.println("User verified!");
				while (true) {

					System.out.println("Do you want to- 1. View products 2. View Cart 3. Contact Us 4. Exit");
					choice = sc.nextInt();
					if (choice == 1) {
						Catalogue catalogue = new Catalogue();
						Product[] allProducts = catalogue.getListofAllProducts();
						for (int i = 0; i < allProducts.length; i++) {
							System.out.println(allProducts[i].getProductId() + " " + allProducts[i].getProductName()
									+ " " + allProducts[i].getCost());
						}
						System.out.println("Do you want to add any product to the cart? Y/N");
						sc.nextLine();
						String addToCart = sc.nextLine();
						if (addToCart.equals("Y")) {
							System.out.println("Input the product id of the product which you want to add to cart.");
							String productId = sc.nextLine();
							Product[] cartProducts = new Product[1];
							for (int i = 0; i < allProducts.length; i++) {
								if (allProducts[i].getProductId().equals(productId))
									cartProducts[0] = allProducts[i];
							}

							Cart cart = new Cart();
							cart.setCartId("1");
							cart.setListOfProducts(cartProducts);
							current.setCart(cart);
							System.out.println("The product is successfully added to the cart");
						}
					} else if (choice == 2) {
						Product[] cartProducts = current.getCart().getListOfProducts();
						System.out.println(current.getCart().getCartId());
						for (int i = 0; i < cartProducts.length; i++) {
							System.out.println(cartProducts[i].getProductId() + " " + cartProducts[i].getProductName()
									+ " " + cartProducts[i].getCost());
						}
						System.out.println("Do you want to checkout? Y/N");
						sc.nextLine();
						String checkout = sc.nextLine();
						if (checkout.equals("Y"))
							if (current.getCart().checkOut())
								// Create an order object and assign this user to the order with an order id
								System.out.println("Your order is placed successfully");

					} else if (choice == 3) {
						System.out.println("To contact us, please email on store@ecommerce.com");
					} else if (choice == 4) {
						System.out.println("Thank You For Visit!");
						break;
					} else {
						System.out.println("Invalid input! Please try again");
					}
				}
			}
		} else if (choice == 2) {
			Seller currentSeller = new Seller();
			System.out.println("Enter your Seller id");
			sc.nextLine();
			currentSeller.setUserId(sc.nextLine());
			System.out.println("What is your passWord?");
			sc.nextLine();
			if (currentSeller.verifyUser() == true) {
				System.out.println("Seller Verified");
				while (true) {
					System.out.println(
							"Do you want to -  1. Add a Product 2.Contact ECom Company 3.View Addded Products 4.Exit");
					int Sellerchoice = sc.nextInt();
					if (Sellerchoice == 1) {
						System.out.println(
								"Choose category you want to add product to : 1. Glocery  2. Electronics  3. Books");
						int sellerCatgchoice = sc.nextInt();
						if (sellerCatgchoice == 1) {
							System.out.println(
									"Choose sub-category you want to add product to : 1. Atta  2. Rice  3. Oil");
							int sellerSubCatgchoice = sc.nextInt();
							if ((sellerSubCatgchoice == 1) || (sellerSubCatgchoice == 2)
									|| (sellerSubCatgchoice == 3)) {
								addSellerProducts();
							}
						} else if (sellerCatgchoice == 2) {
							System.out.println(
									"Choose sub-category you want to add product to : 1. Mobiles  2. Laptops  3. TVs");
							int sellerSubCatgchoice = sc.nextInt();
							if ((sellerSubCatgchoice == 1) || (sellerSubCatgchoice == 2)
									|| (sellerSubCatgchoice == 3)) {
								addSellerProducts();
							}
						} else if (sellerCatgchoice == 3) {
							System.out.println(
									"Choose sub-category you want to add product to : 1. Adventure  2. Mythology  3. Fiction");
							int sellerSubCatgchoice = sc.nextInt();
							if ((sellerSubCatgchoice == 1) || (sellerSubCatgchoice == 2)
									|| (sellerSubCatgchoice == 3)) {
								addSellerProducts();

							}

						} else {
							System.out.println("Invalid input! Please try again!");
						}
					}

					else if (Sellerchoice == 2) {
						System.out.println(
								"Please contact us by mail for any seller related queries : EcomSellerhelpdesk@estore.com");
					} else if (Sellerchoice == 4) {
						System.out.println("Thank You For Visit!");
						break;
					} else {
						System.out.println("Invalid input! Please try again");
					}
				}
			}
		}
		// if User is Administrator
		else if (choice == 3) {
			Admin currentAdmin = new Admin();
			System.out.println("Enter your Admin UserId?");
			sc.nextLine();
			currentAdmin.setUserId(sc.nextLine());
			System.out.println("What is your passWord?");
			sc.nextLine();
			if (currentAdmin.verifyUser() == true) {
				System.out.println("Admin verified!");
				while (true) {
					System.out.println(
							"Do you want to- 1. View products  2. Contact to Seller 3.Contact to Customer 4. Exit");
					int Adminchoice = sc.nextInt();
					if (Adminchoice == 1) {
						Catalogue catalogue = new Catalogue();
						Product[] allProducts = catalogue.getListofAllProducts();
						for (int i = 0; i < allProducts.length; i++) {
							System.out.println(allProducts[i].getProductId() + " " + allProducts[i].getProductName()
									+ " " + allProducts[i].getCost());
						}
					}

					else if (Adminchoice == 2) {
						System.out.println("To contact Seller, please email on sellerService@product.com");
					} else if (Adminchoice == 3) {
						System.out.println("To Contact Customer- Customer Data on this Portal: CustomerDataStore.Org ");
					} else if (Adminchoice == 4) {
						System.out.println("Thank you !!");
						break;
					} else
						System.out.println("Invalid choice, please try again.");
				}
			}
		} else {
			System.out.println("Invalid input. Try again");
		}
	}

	// Add Seller Products
	private static void addSellerProducts() {
		System.out.println("Enter the id of the new product");
		Scanner sc = new Scanner(System.in);
		String newProductId = sc.nextLine();
		System.out.println("Enter the name of the new product");
		String newProductName = sc.nextLine();
		System.out.println("Enter the cost of the new product");
		String newProductCost = sc.nextLine();
		Product newProduct = new Product();
		newProduct.setProductId(newProductId);
		newProduct.setProductName(newProductName);
		newProduct.setCost(newProductCost);
		System.out.println("Your new added product is " + newProduct.getProductId() + " " + newProduct.getProductName()
				+ " " + newProduct.getCost());
	}

}