package com.manajemenkaryawan.dashboard

import checkList
import java.sql.Connection
import TipeKaryawan
import com.manajemenkaryawan.karyawan.FreelanceSort
import com.manajemenkaryawan.karyawan.FullTimeSort

class OrganizeKaryawan(parameterConn: Connection) {
    val conn = parameterConn
    val tipeKaryawanType = mutableListOf(
        TipeKaryawan.FullTime::class.simpleName?.lowercase(),
        TipeKaryawan.Freelance::class.simpleName?.lowercase()
    )
    fun tambahKaryawan(){
        val whichTypeOfKaryawan = checkList("Pilih: ", "tambah karyawan", tipeKaryawanType)
        when(whichTypeOfKaryawan){
            tipeKaryawanType[0] -> FullTimeSort(conn).tambahKaryawanFullTime()
            tipeKaryawanType[1] -> FreelanceSort(conn).tambahKaryawanFreelance()
        }
    }
    fun listKaryawan(){
        val whichTypeOfKaryawan = checkList("Pilih: ", "list karyawan", tipeKaryawanType)

        when(whichTypeOfKaryawan){
            tipeKaryawanType[0] -> FullTimeSort(conn).listKaryawanFullTime()
            tipeKaryawanType[1] -> FreelanceSort(conn).listKaryawanFreelance()
        }
        println("\npress any key to continue..")
        readln()
    }
    fun hapusKaryawan(){
        val whichTypeOfKaryawan = checkList("Pilih: ", "hapus karyawan", tipeKaryawanType)
        when(whichTypeOfKaryawan){
            tipeKaryawanType[0] -> FullTimeSort(conn).hapusKaryawanFullTime()
            tipeKaryawanType[1] -> FreelanceSort(conn).hapusKaryawanFreelance()
        }

    }
}