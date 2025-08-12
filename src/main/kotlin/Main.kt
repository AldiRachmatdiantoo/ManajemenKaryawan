import java.sql.*

fun main() {
    val toProgram = checkYesOrNo("masuk ke program manajemen karyawan? ")
    if (!toProgram) return println("terima kasih")

    Start().start()
}
fun checkYesOrNo(text: String): Boolean{
    print(text)
    var choice = readln()
    while (!choice.equals("y", true) && !choice.equals("n", true)){
        println("error! tolong input dengan benar!")
        choice = readln()
    }
    return choice.equals("y", true)
}
fun checkNullOrBlank(text: String): String{
    while (true){
        print(text)
        val input = readln()
        if (input.isBlank()){
            println("input tidak boleh kosong!")
            continue
        }
        return input
    }
}
fun checkTableSql(stmt: PreparedStatement, input: String, whatToCheck: String, whereInput: String): Boolean{
    stmt.setString(1, whereInput)
    val rs = stmt.executeQuery()
    if (rs.next()){
        val dataFromTable = rs.getString(whatToCheck)
        if (dataFromTable == input){
            return true
        }
    }
        return false
}
fun <T>checkList(text: String, judul: String, list: MutableList<T>): String{
    while (true){
        println("\n=====${judul.uppercase()}=====")
        list.forEachIndexed { index, value ->
            println("${index+1}.$value")
        }
        print(text)
        val input = readln().lowercase()
        if (list.any { it == input }) return input
        println("Error! tolong pilih sesuai list!")
        continue
    }
}
var chance = 2
fun chance(): Int{
    return chance--
}