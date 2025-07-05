package com.eng.transactionapp.app;

import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

@Component
public class FirstProgrammaticApproach {
    PlatformTransactionManager transactionManager;

    public FirstProgrammaticApproach(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void updateUser() {
        // Start a transaction
        TransactionStatus status = transactionManager.getTransaction(null);

        try {
            // Perform some operations, e.g., update user details
            // userRepository.updateUserDetails(user);
            System.out.println("Updating user details...");

            // Commit the transaction
            transactionManager.commit(status);
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            transactionManager.rollback(status);
            throw e; // rethrow the exception after rollback
        }
    }
}
