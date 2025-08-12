package com.manajemenkaryawan.dashboard
import TipeKaryawan
import checkList
import com.manajemenkaryawan.connection.DatabaseConnection
import java.sql.Connection

class Menu(db: DatabaseConnection, conn: Connection) {
    val organize = OrganizeKaryawan(db, conn)
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
                    organize.listKaryawan(user)
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