package xyz.rix1.iot_gateway.helpers;

/**
 * Created by rikardeide on 15/03/16.
 */
public class Endpoint {

    private String address;
    private int port;
    private String name;
    private String description;

    public Endpoint() {
        address = "10.20.106.181";      // DEFAULT ADDRESS
        port = 3000;                    // DEFAULT PORT
    }

    public Endpoint(String address, int port, String name) {
        this();
        this.address = address;
        this.port = port;
        this.name = name;
    }

    public String getURL(){
        return address + ":" + port;
    }

    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public String toString() {
        return name;
    }
}
