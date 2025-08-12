package com.manajemenkaryawan.karyawan

import TipeKaryawan
import java.sql.Connection
import checkTableSql
import checkNullOrBlank

class FullTimeSort(parameterConn: Connection) {
    val listFullTime = mutableListOf<TipeKaryawan.FullTime>()
    val gaji = 5000000
    val conn = parameterConn
    val role = "FULLTIME"

    fun tambahKaryawanFullTime(){
        val stmtInsert = conn.prepareStatement("INSERT INTO users (name, email, role, password ) VALUES (?,?,?,?)")
        println("\n=====TAMBAH KARYAWAN FULLTIME=====")
        val username = checkNullOrBlank("Masukkan username: ")
        val password = checkNullOrBlank("Masukkan password: ")
        val email = checkNullOrBlank("Masukkan email: ")

        stmtInsert.setString(1, username)
        stmtInsert.setString(2, email)
        stmtInsert.setString(3, role)
        stmtInsert.setString(4, password)
        stmtInsert.executeUpdate()
        TipeKaryawan.FullTime(username, email, role, gaji)
        println("\nBerhasil menambahkan karyawan full time baru!")
        return
    }
    fun listKaryawanFullTime(){
        val stmtSelect = conn.prepareStatement("SELECT * FROM users WHERE role = ?")
        stmtSelect.setString(1, role)
        val rs = stmtSelect.executeQuery()
        while (rs.next()){
            val username = rs.getString("name")
            val email = rs.getString("email")
            listFullTime.add(TipeKaryawan.FullTime(username, email, role, gaji))
        }
        println("\n=====LIST KARYAWAN FULLTIME=====")
        listFullTime.forEachIndexed { index, value ->
            println("${index+1}.${value.name} | ${value.email}")
        }
        return
    }
    fun hapusKaryawanFullTime() {
        val stmtDeleteSelect = conn.prepareStatement("SELECT name FROM users WHERE role = ?")
        stmtDeleteSelect.setString(1, role)
        val stmtDelete = conn.prepareStatement("DELETE FROM users WHERE name = ?")
        listKaryawanFullTime()
        print("Siapa yang ingin anda pecat? ")
        val pecatWho = readln()
        val checkName = checkTableSql(stmtDeleteSelect, pecatWho, "name")
        if (!checkName) return println("\nNama tidak ada!")

        //jika ada
        stmtDelete.setString(1, pecatWho)
        stmtDelete.executeUpdate()
        stmtDelete.close()
        stmtDeleteSelect.close()
        println("\nBerhasil memecat!")
        return
    }
}