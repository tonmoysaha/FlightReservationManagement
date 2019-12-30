package com.flightreservation.dto;

public class ReservationRequest {

	private Long flightId;
	private String passengerfristName;
	private String passengermiddleName;
	private String passengerlastName;
	private String passengerEmail;
	private String passengerphone;
	private String nameOfTheCard;
	private String cardNo;
	private String expirationDate;
	private String securityCode;


	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getPassengerfristName() {
		return passengerfristName;
	}

	public void setPassengerfristName(String passengerfristName) {
		this.passengerfristName = passengerfristName;
	}
	

	public String getPassengermiddleName() {
		return passengermiddleName;
	}

	public void setPassengermiddleName(String passengermiddleName) {
		this.passengermiddleName = passengermiddleName;
	}

	public String getPassengerlastName() {
		return passengerlastName;
	}

	public void setPassengerlastName(String passengerlastName) {
		this.passengerlastName = passengerlastName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public String getPassengerphone() {
		return passengerphone;
	}

	public void setPassengerphone(String passengerphone) {
		this.passengerphone = passengerphone;
	}

	public String getNameOfTheCard() {
		return nameOfTheCard;
	}

	public void setNameOfTheCard(String nameOfTheCard) {
		this.nameOfTheCard = nameOfTheCard;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	@Override
	public String toString() {
		return "ReservationRequest [flightId=" + flightId + ", passengerfristName=" + passengerfristName
				+ ", passengermiddleName=" + passengermiddleName + ", passengerlastName=" + passengerlastName
				+ ", passengerEmail=" + passengerEmail + ", passengerphone=" + passengerphone + ", nameOfTheCard="
				+ nameOfTheCard + ", cardNo=" + cardNo + ", expirationDate=" + expirationDate + ", securityCode="
				+ securityCode + "]";
	}
	
	

}
