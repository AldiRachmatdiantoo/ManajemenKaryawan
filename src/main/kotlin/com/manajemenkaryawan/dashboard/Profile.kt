package com.manajemenkaryawan.dashboard

class Profile {
    fun checkProfile(user: TipeKaryawan.Manager){
        println("\n=====PROFILE=====")
        println("${user.name} | ${user.email}")
        print("\npress any key to continue..")
        readln()
    }
}