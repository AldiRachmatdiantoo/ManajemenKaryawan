package com.manajemenkaryawan.connection

import java.sql.*

data class DatabaseConnection(
    val url: String,
    val user: String,
    val password: String
) {
    fun getConnection(): Connection {
        return DriverManager.getConnection(url, user, password)
    }
}