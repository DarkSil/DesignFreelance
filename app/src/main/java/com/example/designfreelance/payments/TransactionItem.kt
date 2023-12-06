package com.example.designfreelance.payments

data class TransactionItem(
    val name: String,
    val description: String?,
    val date: String,
    val price: String,
    val type: TransactionType
) {
    enum class TransactionType(){
        DEPOSIT,
        PAYMENT
    }
}
