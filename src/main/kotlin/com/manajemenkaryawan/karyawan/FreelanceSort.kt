package com.manajemenkaryawan.karyawan

import java.sql.Connection
import TipeKaryawan
import checkNullOrBlank
import checkTableSql

class FreelanceSort(parameterConn: Connection) {
    val listFreelance = mutableListOf<TipeKaryawan.Freelance>()
    val gajiPerJam = 5000000
    val jamKerja = 6
    val conn = parameterConn
    val role = "FREELANCE"

    fun tambahKaryawanFreelance(){
        val stmtInsert = conn.prepareStatement("INSERT INTO users (name, email, role, password ) VALUES (?,?,?,?)")
        println("\n=====TAMBAH KARYAWAN FREELANCE=====")
        val username = checkNullOrBlank("Masukkan username: ")
        val password = checkNullOrBlank("Masukkan password: ")
        val email = checkNullOrBlank("Masukkan email: ")

        stmtInsert.setString(1, username)
        stmtInsert.setString(2, email)
        stmtInsert.setString(3, role)
        stmtInsert.setString(4, password)
        stmtInsert.executeUpdate()
        TipeKaryawan.Freelance(username, email, role, jamKerja ,gajiPerJam)
        println("\nBerhasil menambahkan karyawan freelance baru!")
        return
    }
    fun listKaryawanFreelance(){
        val stmtSelect = conn.prepareStatement("SELECT * FROM users WHERE role = ?")
        stmtSelect.setString(1, role)
        val rs = stmtSelect.executeQuery()
        while (rs.next()){
            val username = rs.getString("name")
            val email = rs.getString("email")
            listFreelance.add(TipeKaryawan.Freelance(username, email, role, jamKerja, gajiPerJam))
        }
        println("\n=====LIST KARYAWAN FREELANCE=====")
        listFreelance.forEachIndexed { index, value ->
            println("${index+1}.${value.name} | ${value.email}")
        }
        return
    }
    fun hapusKaryawanFreelance(){
        val stmtDeleteSelectFreelance = conn.prepareStatement("SELECT name FROM users WHERE role = ?")
        val stmtDelete = conn.prepareStatement("DELETE FROM users WHERE name = ?")
        listKaryawanFreelance()
        print("Siapa yang ingin anda pecat? ")
        val pecatWho = readln()
        val checkName = checkTableSql(stmtDeleteSelectFreelance, pecatWho, "name", role)
        if (!checkName) return println("\nNama tidak ada!")

        //jika ada
        stmtDelete.setString(1, pecatWho)
        stmtDelete.executeUpdate()
        stmtDelete.close()
        stmtDeleteSelectFreelance.close()
        println("\nBerhasil memecat!")
        return
    }
}