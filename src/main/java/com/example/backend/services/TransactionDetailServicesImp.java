package com.example.backend.services;

import com.example.backend.entity.AllProduct;
import com.example.backend.entity.TransactionDetail;
import com.example.backend.repository.TransactionDetailRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDetailServicesImp implements TransactionDetailServices  {

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    @Override
    public List<TransactionDetail> transactionData() {
//        TransactionDetail transactionDetail1 = TransactionDetailRepository.save(transactionDetail);
//        return transactionDetail1;
       List<TransactionDetail> allProduct = transactionDetailRepository.getProductByStatus(true);
        return allProduct;
    }
}
