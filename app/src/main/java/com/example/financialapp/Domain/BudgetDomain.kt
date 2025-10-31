package com.example.financialapp.Domain

import java.io.Serializable

data class BudgetDomain(
    val title:String,
    val price: Double=0.0,
    val percent: Double=0.0
): Serializable
