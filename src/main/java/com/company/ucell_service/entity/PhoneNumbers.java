package com.company.ucell_service.entity;

import com.company.ucell_service.entity.enums.PhoneNumberStatus;

public class PhoneNumbers {
    private Long id;
    private String number;
    private Long ownerId;
    private Double price;
    private PhoneNumberStatus status;

    public PhoneNumbers(Long id,
                        String number,
                        Long ownerId,
                        Double price,
                        PhoneNumberStatus status) {
        this.id = id;
        this.number = number;
        this.ownerId = ownerId;
        this.price = price;
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PhoneNumberStatus getStatus() {
        return status;
    }

    public void setStatus(PhoneNumberStatus status) {
        this.status = status;
    }
}
