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
                val stmtSelectCheckRole = conn.prepareStatement("SELECT role FROM users WHERE NAME = ?")
                stmtSelectCheckRole.setString(1, checkUsername)
                val rs = stmtSelectCheckRole.executeQuery()
                if (rs.next()){
                    val userRole = rs.getString("role")
                    when(userRole){
                        "MANAGER" -> {
                            Menu(conn).menu(manager)
                            return
                        }
                        else -> {
                            println("Anda bukan manager!")
                            return
                        }
                    }
                }
                return

            }

        }

    }
    fun checkUsername(): String{
        while (true) {
            val username = checkNullOrBlank("masukkan username: ")
            val stmtSelectUsername = conn.prepareStatement("SELECT * FROM users WHERE name = ?")
            stmtSelectUsername.setString(1, username)
            val whatToCheck = "name"

            val check = checkTableSql(stmtSelectUsername, username, whatToCheck)
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
            stmtSelectPassword.setString(1, username)
            val whatToCheck = "password"

            val check = checkTableSql(stmtSelectPassword, password, whatToCheck)
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