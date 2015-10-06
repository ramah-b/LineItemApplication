package Invoice;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

import Invoice.LineItemClass;

public class InvoiceClass {

	private String custName;
	private int invoiceNum;
	private Date invoiceDate;
	private ArrayList<LineItemClass> lineItemsList;
	private double taxRate = 0.05;

	public InvoiceClass(String name, int num) {
		custName = name;
		invoiceNum = num;
		invoiceDate = new Date();
		lineItemsList = new ArrayList<LineItemClass>();
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	// set the Line Items object variables
	public void insertItemList(double qty, String desc, double unitPrice,
			int invoiceNum, boolean taxable, int index) {

		LineItemClass tempLineItem = new LineItemClass();

		tempLineItem.setItemQty(qty);
		tempLineItem.setItemDesc(desc);
		tempLineItem.setUnitPrice(unitPrice);
		tempLineItem.setUnitInvoiceNum(invoiceNum);
		tempLineItem.setTaxable(taxable);

		lineItemsList.add(index, tempLineItem);

	}

	// method to calculate the subtotal for the taxable items
	public double calculateTaxSubtotal() {
		double taxSubtotal = 0;
		LineItemClass tempLineItem = new LineItemClass();
		for (int i = 0; i < lineItemsList.size(); i++) {
			tempLineItem = lineItemsList.get(i);
			if (tempLineItem.isTaxable())
				taxSubtotal = taxSubtotal
						+ (tempLineItem.getItemQty() * tempLineItem
								.getUnitPrice());
		}

		return taxSubtotal;

	}

	// method to calculate the subtotal for the untaxable items
	public double calculateUnTaxSubtotal() {
		double untaxSubtotal = 0;
		LineItemClass tempLineItem = new LineItemClass();
		for (int i = 0; i < lineItemsList.size(); i++) {
			tempLineItem = lineItemsList.get(i);
			if (!tempLineItem.isTaxable())
				untaxSubtotal = untaxSubtotal
						+ (tempLineItem.getItemQty() * tempLineItem
								.getUnitPrice());
		}

		return untaxSubtotal;

	}

	// method to calculate the taxes
	public double calculateTaxTotal() {
		double taxAmount = 0;
		LineItemClass tempLineItem = new LineItemClass();

		for (int i = 0; i < lineItemsList.size(); i++) {
			tempLineItem = lineItemsList.get(i);
			if (tempLineItem.isTaxable())
				taxAmount = (tempLineItem.getUnitPrice() * tempLineItem
						.getItemQty()) * taxRate;

		}
		return taxAmount;
	}

	public void printInvoice() {
		System.out.println("INVOICE PRINT\n");

		// print invoice header
		System.out.println("Customer Name: " + this.getCustName());
		System.out.printf("Invoice Number: %05d", this.getInvoiceNum());
		System.out.println();
		System.out.printf("%tD", this.getInvoiceDate());
		System.out.println("\n");

		System.out.println("Items in this Invoice: ");
		System.out
				.println("Description \t Quntity \tUnit Price \tTotal Amount");

		// print invoice items
		LineItemClass tempLineItem = new LineItemClass();
		for (int i = 0; i < lineItemsList.size(); i++) {
			tempLineItem = lineItemsList.get(i);
			
			//this if statement to check that the item belongs to the invoice we are printing (for future enhancement of the program)
			if (tempLineItem.getUnitInvoiceNum() == this.getInvoiceNum()) {
				System.out.printf(" %s %s %s", tempLineItem.getItemDesc(),
						"\t", "\t");
				System.out.printf(" %.2f %s %s", tempLineItem.getItemQty(),
						"\t", "\t");
				System.out.printf(" %.2f %s %s", tempLineItem.getUnitPrice(),
						"\t", "\t");
				System.out.printf(" %.2f %n",
						(tempLineItem.getItemQty() * tempLineItem
								.getUnitPrice()));
			}
		}
	}

	public String getFormattedPrice(double amount) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(amount);
	}

}
