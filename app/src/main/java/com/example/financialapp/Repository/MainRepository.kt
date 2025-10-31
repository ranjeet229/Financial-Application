package com.example.financialapp.Repository

import com.example.financialapp.Domain.ExpenseDomain


class MainRepository{
    val items= mutableListOf(
        ExpenseDomain("Resturant", 573.12, "resturant", "20 jun 2025 20:20"),
        ExpenseDomain("KFC", 600.1, "mcdonald", "18 jul 2025 10:23"),
        ExpenseDomain("McDonald", 73.13, "cinema", "30 aug 2025 2:26"),
        ExpenseDomain("Cinema", 57.12, "resturant", "30 oct 2025 17:18"),
    )
}