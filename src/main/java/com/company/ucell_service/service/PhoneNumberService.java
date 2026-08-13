package com.company.ucell_service.service;

import com.company.ucell_service.entity.PhoneNumbers;

import java.util.List;

public class PhoneNumberService {
    // todo: PhoneNumber CRUD

    public boolean create(PhoneNumbers number) {
        String num = number.getNumber();
        checkRegex(num);
        return true;
    }

    private void checkRegex(String num) {

    }

    public PhoneNumbers getById(String id) {
        return null;
    }

    public PhoneNumbers getByNumber(String id) {
        return null;
    }

    public List<PhoneNumbers> getByStatus(String status) {
        return null;
    }

    public boolean update(Long id, PhoneNumbers phoneNumbers) {
        if (phoneNumbers.getNumber() != null) {
            checkRegex(phoneNumbers.getNumber());
        }
        return true;
    }

    public boolean delete(Long id) {
        return true;
    }


}
