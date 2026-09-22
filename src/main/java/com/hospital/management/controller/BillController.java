package com.hospital.management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.entity.Bill;
import com.hospital.management.service.BillService;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public ResponseEntity<Bill> createBill(
            @RequestBody Bill bill) {

        Bill savedBill = billService.createBill(bill);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedBill);
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {

        List<Bill> bills = billService.getAllBills();

        return ResponseEntity.ok(bills);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(
            @PathVariable Long id) {

        Bill bill = billService.getBillById(id);

        return ResponseEntity.ok(bill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(
            @PathVariable Long id,
            @RequestBody Bill bill) {

        Bill updatedBill = billService.updateBill(id, bill);

        return ResponseEntity.ok(updatedBill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(
            @PathVariable Long id) {

        billService.deleteBill(id);

        return ResponseEntity.noContent().build();
    }
}