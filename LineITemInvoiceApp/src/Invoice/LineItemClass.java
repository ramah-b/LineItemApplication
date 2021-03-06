package Invoice;

import java.text.NumberFormat;

public class LineItemClass {

	private double itemQty;
	private String itemDesc;
	private double unitPrice;
	private int unitInvoiceNum;
	private boolean taxable;

	public LineItemClass() {
		itemQty = 0;
		itemDesc = "";
		unitPrice = 0;
		unitInvoiceNum = 0;
		setTaxable(false);
	}

	public double getItemQty() {
		return itemQty;
	}

	public void setItemQty(double itemQty) {
		this.itemQty = itemQty;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitInvoiceNum() {
		return unitInvoiceNum;
	}

	public void setUnitInvoiceNum(int unitInvoiceNum) {
		this.unitInvoiceNum = unitInvoiceNum;
	}

	public boolean isTaxable() {
		return taxable;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}

	public String getFormattedPrice(double amount) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String amountStr = String.format("%.2f", amount);
		amount = Double.parseDouble(amountStr);
		return  currency.format(amount);
		
	}

}
