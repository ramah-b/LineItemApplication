package Invoice;

public class LineItemClass {

	private int itemQty;
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

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
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

}
