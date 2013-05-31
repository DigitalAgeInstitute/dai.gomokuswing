package dai.gomoku.client.swing.requests;

import dai.gomoku.client.swing.ClientController;

public class RegisterRequest implements Request {
	private String type = "REGISTERUSER";
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;

	private ClientController controller;

	public RegisterRequest(ClientController controller) {
		this.controller = controller;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void request() {
		String registerJSON = String
				.format("{ \"type\":\"%s\", \"firstName\":\"%s\", \"lastName\":\"%s\", "
						+ "\"email\":\"%s\", \"contacts\":\"%s\", \"username\":\"%s\", "
						+ "\"password\":\"%s\" }", type, firstName, lastName,
						email, phone, username, password);
		controller.sendToServer(registerJSON);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegisterRequest [type=" + type + ", username=" + username
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}

}
