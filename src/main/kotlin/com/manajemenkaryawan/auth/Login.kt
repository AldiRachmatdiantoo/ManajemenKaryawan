package com.manajemenkaryawan.auth

import com.manajemenkaryawan.connection.DatabaseConnection
import checkNullOrBlank
import checkTableSql
import chance
import kotlin.system.exitProcess
import com.manajemenkaryawan.dashboard.Menu

class Login {

    //connection
    val db = DatabaseConnection(
        "jdbc:mysql://localhost:3306/manajemen_karyawan",
        "root",
        ""
    )
    val conn = db.getConnection()
    fun loginAcc(){
        while (true) {
            val checkUsername = checkUsername()
            if (checkPassword(checkUsername)){

                val checkEmail = checkEmail(checkUsername)
                val manager = TipeKaryawan.Manager(checkUsername, checkEmail, null)
                manager.role = manager::class.simpleName?.uppercase()
                Menu(db, conn).menu(manager)
                return

            }

        }

    }
    fun checkUsername(): String{
        while (true) {
            val username = checkNullOrBlank("masukkan username: ")
            val stmtSelectUsername = conn.prepareStatement("SELECT * FROM users WHERE name = ?")
            val whatToCheck = "name"

            val check = checkTableSql(stmtSelectUsername, username, whatToCheck, username)
            if (!check) {
                println("username tidak ada!")
                continue
            } else {
                return username
            }
        }
    }
    fun checkPassword(username: String): Boolean {
        while (true) {
            val password = checkNullOrBlank("masukkan password: ")
            val stmtSelectPassword = conn.prepareStatement("SELECT password FROM users WHERE name = ?")
            val whatToCheck = "password"

            val check = checkTableSql(stmtSelectPassword, password, whatToCheck, username)
            if (!check) {
                val remainingChance = chance()
                println("password salah! sisa kesempatan login: $remainingChance")
                if (remainingChance == 0){
                    println("\nkesempatan habis! keluar dari program..")
                    conn.close()
                    stmtSelectPassword.close()
                    exitProcess(0)
                }
                continue
            }
            return true
        }
    }
    fun checkEmail(username: String): String{
        val stmtSelectEmail = conn.prepareStatement("SELECT email from users WHERE NAME = ?")
        stmtSelectEmail.setString(1, username)
        val rs = stmtSelectEmail.executeQuery()
        if (rs.next()){
            val email = rs.getString("email")
            return email

        }
        return "email not found"
    }
}