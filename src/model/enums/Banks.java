package model.enums;

public enum Banks {
	BRASIL("Banco do Brasil S.A","001"), SANTANDER("Banco Santander (Brasil) S.A.","033"), CAIXA("Caixa Econômica Federal","104"),
	BRADESCO("Banco Bradesco S.A.","237"), ITAU("Banco Itaú BBA S.A.","184");

	private String desc,number;

	Banks(String desc, String number) {
		this.desc = desc;
		this.number = number;
	}

	public String getBankDescription() {
		return desc;
	}
	
	public String getBankNumber() {
		return number;
	}
}
