package entity;

import java.util.Hashtable;
import java.util.Map;

public class Return {
	private String code;
	private String cause;
	private String message;
	Map<String, String[]> errorTable = new Hashtable<>();
	
	public Return() {
		createErrorTable();
		setCode("99");
	}
	
	private void createErrorTable() {
		errorTable.put("00", new String[] {"OK", "Operation successful"});
		errorTable.put("01", new String[] {"Agent username nof found", "Invalid username or password"});
		errorTable.put("02", new String[] {"Agent password incorrect", "Invalid username or password"});
		errorTable.put("03", new String[] {"Duplicate email address", "User email already registered"});
		errorTable.put("04", new String[] {"Customer has open accounts", "Cannot delete a customer with open accounts"});
		errorTable.put("05", new String[] {"Account balance is not 0", "Account balance must be 0 to be deleted"});
		errorTable.put("99", new String[] {"Unknown error", "Try again or contact system administrator"});
	}
	
	public void setCode(String code) {
		this.code = code;
		this.cause = errorTable.get(code)[0];
		this.message = errorTable.get(code)[1];
	}
	
	public String getCode() {
		return code;
	}
	
	public String getCause() {
		return cause;
	}
	
	public String getMessage() {
		return message;
	}
}
