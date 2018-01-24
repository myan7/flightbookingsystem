package com.bean;

public class Flight {
		private int flight_id;
		private String	flightNO;
		private int		seatsNO;
		private	String	departureTime;
		private String	departurePort;
		private String  departureCity;
		private String	arrivalTime;
		private String	arrivalPort;
		private String  arrivalCity;
		
		public Flight() {

		}
		public Flight(int flight_id, String flightNO, int seatsNO, String departureTime, String departurePort,
				String departureCity, String arrivalTime, String arrivalPort, String arrivalCity) {
			super();
			this.flight_id = flight_id;
			this.flightNO = flightNO;
			this.seatsNO = seatsNO;
			this.departureTime = departureTime;
			this.departurePort = departurePort;
			this.departureCity = departureCity;
			this.arrivalTime = arrivalTime;
			this.arrivalPort = arrivalPort;
			this.arrivalCity = arrivalCity;
		}
		public int getFlight_id() {
			return flight_id;
		}
		public void setFlight_id(int flight_id) {
			this.flight_id = flight_id;
		}
		public String getFlightNO() {
			return flightNO;
		}
		public void setFlightNO(String flightNO) {
			this.flightNO = flightNO;
		}
		public int getSeatsNO() {
			return seatsNO;
		}
		public void setSeatsNO(int seatsNO) {
			this.seatsNO = seatsNO;
		}
		public String getDepartureTime() {
			return departureTime;
		}
		public void setDepartureTime(String departureTime) {
			this.departureTime = departureTime.replace('T', ' ');
		}
		public String getDeparturePort() {
			return departurePort;
		}
		public void setDeparturePort(String departurePort) {
			this.departurePort = departurePort;
		}
		public String getDepartureCity() {
			return departureCity;
		}
		public void setDepartureCity(String departureCity) {
			this.departureCity = departureCity;
		}
		public String getArrivalTime() {
			return arrivalTime;
		}
		public void setArrivalTime(String arrivalTime) {
			this.arrivalTime = arrivalTime.replace('T', ' ');
		}
		public String getArrivalPort() {
			return arrivalPort;
		}
		public void setArrivalPort(String arrivalPort) {
			this.arrivalPort = arrivalPort;
		}
		public String getArrivalCity() {
			return arrivalCity;
		}
		public void setArrivalCity(String arrivalCity) {
			this.arrivalCity = arrivalCity;
		}
		
//		public String getDate(String date)
//		{
//			String[] dnt = date.split(" ");
//			return dnt[0];
//		}
//		
//		public String getTime(String date)
//		{
//			String[] dnt = date.split(" ");
//			return dnt[1];
//		}
		
		
}
