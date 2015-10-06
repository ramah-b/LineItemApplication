package Invoice;

import java.util.ArrayList;
import java.util.Date;

import Invoice.LineItemClass;

public class InvoiceClass {

	private String custName;
	private double totalAmount;
	private int invoiceNum;
	private Date invoiceDate;
	private ArrayList<LineItemClass> lineItemsList;
	private double taxRate = 0.05;

	public InvoiceClass(String name, double total, int num) {
		custName = name;
		totalAmount = total;
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

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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
	public void insertItemList(int qty, String desc, double unitPrice,
			int invoiceNum, boolean taxable, int index) {

		LineItemClass tempLineItem = new LineItemClass();

		tempLineItem.setItemQty(qty);
		tempLineItem.setItemDesc(desc);
		tempLineItem.setUnitPrice(unitPrice);
		tempLineItem.setUnitInvoiceNum(invoiceNum);
		tempLineItem.setTaxable(taxable);

		lineItemsList.add(index, tempLineItem);

	}

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
	
	public void printInvoice(){
		System.out.println("INVOICE PRINT\n");
		System.out.println("Customer Name: " + this.getCustName());
		System.out.printf("Invoice Number: %05d", this.getInvoiceNum());
		System.out.println();
		System.out.printf("%tD", this.getInvoiceDate());
		System.out.println("\n");
		
		System.out.println("Items in this Invoice: ");
		System.out.println("Description \t Quntity \tUnit Price \tTotal Amount");
	
		LineItemClass tempLineItem = new LineItemClass();
		for (int i=0; i < lineItemsList.size(); i++){
			tempLineItem = lineItemsList.get(i);
			System.out.printf(" %s %s %s", tempLineItem.getItemDesc(), "\t","\t");
			System.out.printf(" %d %s %s", tempLineItem.getItemQty(), "\t", "\t");
			System.out.printf(" %.2f %s %s", tempLineItem.getUnitPrice(), "\t", "\t");
			System.out.printf(" %.2f %n", (tempLineItem.getItemQty() * tempLineItem.getUnitPrice()));
		
		}
	}
}


