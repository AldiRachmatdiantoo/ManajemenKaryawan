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
var chance = 2
fun chance(): Int{
    return chance--
}