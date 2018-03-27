package org.aidas.app.dto;

public class MongoTenantProperties {

	private String hostName;
	private String portNumber;
	private String databaseName;
	private boolean sslEnabled;
	private String userName;
	private String password;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(final String hostName) {
		this.hostName = hostName;
	}

	public String getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(final String portNumber) {
		this.portNumber = portNumber;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(final String databaseName) {
		this.databaseName = databaseName;
	}

	public boolean isSslEnabled() {
		return sslEnabled;
	}

	public void setSslEnabled(final boolean sslEnabled) {
		this.sslEnabled = sslEnabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MongoTenantProperties [hostName=" + hostName + ", portNumber=" + portNumber + ", databaseName="
				+ databaseName + ", sslEnabled=" + sslEnabled + ", userName=" + userName + ", password=" + password
				+ "]";
	}
}
