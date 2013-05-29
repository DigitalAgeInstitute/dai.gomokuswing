package dai.gomoku.client;

public class Player {
	// TODO: Replace this with, say an interface then provide a way to tell the
	// player type
	private String userName;
	private String firstName;
	private String lastName;

	public Player(String username, String fName, String lName) {
		this.userName = username;
		this.firstName = fName;
		this.lastName = lName;
	}

	/**
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUserName(String username) {
		this.userName = username;
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

}
