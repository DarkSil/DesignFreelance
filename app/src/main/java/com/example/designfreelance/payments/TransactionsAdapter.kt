package com.example.designfreelance.payments

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.designfreelance.R

class TransactionsAdapter(private val arrayList: ArrayList<TransactionItem>) : Adapter<TransactionsAdapter.ServicesViewHolder>() {

    class ServicesViewHolder(view: View) : ViewHolder(view) {
        val textTransactionName: TextView = view.findViewById(R.id.textTransactionName)
        val textTransactionDescription: TextView = view.findViewById(R.id.textTransactionDescription)
        val textTransactionAmount: TextView = view.findViewById(R.id.textTransactionAmount)
        val textTransactionDate: TextView = view.findViewById(R.id.textTransactionDate)
        val imageTransaction: ImageView = view.findViewById(R.id.imageTransaction)
        val transactionDivider: View = view.findViewById(R.id.transactionDivider)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        return ServicesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.textTransactionName.text = arrayList[position].name
        holder.textTransactionDescription.text = arrayList[position].description
        holder.textTransactionAmount.text = arrayList[position].price
        holder.textTransactionDate.text = arrayList[position].date
        when (arrayList[position].type) {
            TransactionItem.TransactionType.DEPOSIT -> {
                holder.imageTransaction.setColorFilter(
                    ContextCompat.getColor(holder.itemView.context, R.color.black)
                )
                holder.textTransactionAmount.setTextColor(ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.transaction_green
                ))
            }
            TransactionItem.TransactionType.PAYMENT -> {
                holder.imageTransaction.setColorFilter(
                    ContextCompat.getColor(holder.itemView.context, R.color.transaction_red)
                )
                holder.textTransactionAmount.setTextColor(ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.transaction_red
                ))
            }
        }
        holder.textTransactionDescription.isVisible = arrayList[position].description != null
        holder.transactionDivider.isVisible = position != arrayList.size-1
    }

}