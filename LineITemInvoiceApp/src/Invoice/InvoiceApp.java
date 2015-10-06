package Invoice;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Invoice.InvoiceClass;

public class InvoiceApp {
	
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int tempInvoiceNum, tempItemQty, indexCounter = 0;
		String tempCustName,tempItemDesc, moreList = "";
		double tempItemUnitPrice, taxAmount, taxableSub, untaxableSub;
		boolean tempTaxable;
		
		//ArrayLists to hold the Line Item inputs temporarily 
		ArrayList<Integer> tempQtyList = new ArrayList<Integer>();
		ArrayList<String> tempDescList = new ArrayList<String>();
		ArrayList<Double> tempPriceList = new ArrayList<Double>();
		ArrayList<Boolean> tempTaxableList = new ArrayList<Boolean>();
		
		System.out.println("Line Item Invoice\n\n");

		System.out.print("Customer name: ");
		tempCustName = keyboard.next();

		System.out.print("Invoice number: ");
		tempInvoiceNum = keyboard.nextInt();
		
		//loop for Lines Items; user may enter many items until he/she quits 
		do {
			System.out.println("\nLine item " + (indexCounter + 1));

			System.out.print("Item quantity: ");
			tempItemQty = keyboard.nextInt();

			System.out.print("Item description: ");
			tempItemDesc = keyboard.next();

			System.out.print("Item unit price: ");
			tempItemUnitPrice = keyboard.nextDouble();
			
			System.out.print("Is taxable? (true or false) ");
			tempTaxable = keyboard.nextBoolean();

			tempQtyList.add(tempItemQty);
			tempDescList.add(tempItemDesc);
			tempPriceList.add(tempItemUnitPrice);
			tempTaxableList.add(tempTaxable);
			
			//counter for the number of Line Items entered
			indexCounter++;

			System.out.print("\nQuit? ");
			moreList= keyboard.next();
			
			System.out.println("----------------------");
			
		} while (!moreList.equals("yes") && !moreList.equals("YES"));
		keyboard.close();
		
		//create an invoice object 
		InvoiceClass myInvoice = new InvoiceClass(tempCustName, 0, tempInvoiceNum);

		//set the line items array of objects to the user's entries 
		for (int j=0; j<tempQtyList.size(); j++){
	
		myInvoice.insertItemList(tempQtyList.get(j), tempDescList.get(j),
				tempPriceList.get(j),  tempInvoiceNum, tempTaxableList.get(j), j);
		}
		
		
		myInvoice.printInvoice();
		
		System.out.println("\n");
		//all required calculations 
		
		taxableSub = myInvoice.calculateTaxSubtotal(); 
		if (taxableSub != 0)
			System.out.println("Taxable Subtotal: " + getFormattedPrice(taxableSub));
		else 
			System.out.println("No taxable amounts for this invoice.");
		
		untaxableSub = myInvoice.calculateUnTaxSubtotal(); 
		if (untaxableSub != 0)
			System.out.println("Taxable Subtotal: " + getFormattedPrice(untaxableSub));
		else 
			System.out.println("No untaxable amounts for this invoice.");
		
		taxAmount = myInvoice.calculateTaxTotal();
		System.out.println("Tax: " + getFormattedPrice(taxAmount ));
		
		System.out.println("Grand Total: " + getFormattedPrice((taxableSub + untaxableSub +  taxAmount)));
		
		
	

	}
	
	
	public static String getFormattedPrice(double amount) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(amount);
	}


}
