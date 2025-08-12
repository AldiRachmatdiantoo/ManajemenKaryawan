package com.manajemenkaryawan.dashboard
import TipeKaryawan
import checkList
import java.sql.Connection

class Menu(conn: Connection) {
    val organize = OrganizeKaryawan(conn)
    val listmenu = mutableListOf(
        "tambah karyawan",
        "list karyawan",
        "pecat karyawan",
        "check profile",
        "keluar"
    )

    fun menu(user: TipeKaryawan.Manager){
        while (true) {
            val inputFromList = checkList("Pilih: ", "menu", listmenu)
            when (inputFromList) {
                listmenu[0] -> {
                    organize.tambahKaryawan()
                    continue
                }
                listmenu[1] -> {
                    organize.listKaryawan()
                    continue
                }
                listmenu[2] -> {
                    organize.hapusKaryawan()
                    continue
                }
                listmenu[3] -> {
                    Profile().checkProfile(user)
                    continue
                }
                listmenu[4] -> {
                    println("\nkeluar...")
                    return
                }

            }
        }
    }
}