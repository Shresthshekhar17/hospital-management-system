package com.hospital.management.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.hospital.management.entity.Bill;
import com.hospital.management.repository.BillRepository;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Bill not found with id: " + id));
    }

    public Bill updateBill(Long id, Bill bill) {

        Bill existingBill = billRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Bill not found with id: " + id));

        existingBill.setBillDate(bill.getBillDate());
        existingBill.setConsultationFee(bill.getConsultationFee());
        existingBill.setMedicineCharges(bill.getMedicineCharges());
        existingBill.setOtherCharges(bill.getOtherCharges());
        existingBill.setTotalAmount(bill.getTotalAmount());
        existingBill.setPaymentStatus(bill.getPaymentStatus());
        existingBill.setPatient(bill.getPatient());

        return billRepository.save(existingBill);
    }

    public void deleteBill(Long id) {

        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Bill not found with id: " + id));

        billRepository.delete(bill);
    }
}
