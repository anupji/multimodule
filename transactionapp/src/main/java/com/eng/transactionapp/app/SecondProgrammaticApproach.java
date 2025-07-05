package com.eng.transactionapp.app;

import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class SecondProgrammaticApproach {
    TransactionTemplate transactionTemplate;

    public SecondProgrammaticApproach(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void updateUser() {
        // Use the transaction template to execute the operation within a transaction
        TransactionCallback<TransactionStatus> doOperationTask = (TransactionStatus status) -> {
            System.out.println("Updating user details...");
            return status;
        };
        transactionTemplate.execute(doOperationTask);
    }
}
