package math.modal;

public class DataAccessories {
	
	private Double[] list;
	
	public DataAccessories() {
	}
	
	public Double [] convertToList(String input) {
		 String [] temp = input.split(",");
		 list = new Double[temp.length];
		 for(int i=0;i<list.length;i++) 
			 list[i] = Double.parseDouble(temp[i]);
		 return list;
	}
	
	public double convertToQ(String input) {
		return Double.parseDouble(input);
	}
	
}
