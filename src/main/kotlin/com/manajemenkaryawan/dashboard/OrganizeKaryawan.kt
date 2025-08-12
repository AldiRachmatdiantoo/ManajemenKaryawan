package com.manajemenkaryawan.dashboard

import checkList
import com.manajemenkaryawan.connection.DatabaseConnection
import java.sql.Connection
import TipeKaryawan
import com.manajemenkaryawan.karyawan.FreelanceSort
import com.manajemenkaryawan.karyawan.FullTimeSort

class OrganizeKaryawan(parameterDb: DatabaseConnection, parameterConn: Connection) {
    val db = parameterDb
    val conn = parameterConn
    val tipeKaryawanType = mutableListOf(
        TipeKaryawan.FullTime::class.simpleName?.lowercase(),
        TipeKaryawan.Freelance::class.simpleName?.lowercase()
    )
    fun tambahKaryawan(){
        val whichTypeOfKaryawan = checkList("Pilih: ", "tambah karyawan", tipeKaryawanType)
        when(whichTypeOfKaryawan){
            tipeKaryawanType[0] -> FullTimeSort(db, conn).tambahKaryawanFullTime()
            tipeKaryawanType[1] -> FreelanceSort(db, conn).tambahKaryawanFreelance()
        }
    }
    fun listKaryawan(user: TipeKaryawan.Manager){
        val whichTypeOfKaryawan = checkList("Pilih: ", "list karyawan", tipeKaryawanType)
        when(whichTypeOfKaryawan){
            tipeKaryawanType[0] -> FullTimeSort(db, conn).listKaryawanFullTime()
            tipeKaryawanType[1] -> FreelanceSort(db, conn).listKaryawanFreelance()
        }
    }
    fun hapusKaryawan(){
        val whichTypeOfKaryawan = checkList("Pilih: ", "hapus karyawan", tipeKaryawanType)
        when(whichTypeOfKaryawan){
            tipeKaryawanType[0] -> FullTimeSort().hapusKaryawanFullTime()
            tipeKaryawanType[1] -> FreelanceSort(db, conn).hapusKaryawanFreelance()
        }

    }
}