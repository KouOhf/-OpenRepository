package com.example.constant;

public class Constant {
	public enum CATEGORY_CD {
		gender("00001");
		
		private String value;
		
		private CATEGORY_CD(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}
	}

}
	