package com.company;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address shippingAddress;
    private Address billingAddress;
    private boolean isARewardsMember;

    public Customer() {};

    public Customer(String firstName,
                    String lastName,
                    String email,
                    String phoneNumber,
                    Address shippingAddress,
                    Address billingAddress) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public boolean isARewardsMember() {
        return isARewardsMember;
    }

    public void setARewardsMember(boolean ARewardsMember) {
        isARewardsMember = ARewardsMember;
    }
}
