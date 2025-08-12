fun main() {
    val toProgram = checkYesOrNo("masuk ke program manajemen karyawan? ")
    if (!toProgram) return println("terima kasih")

    Start().start()
}
fun checkYesOrNo(text: String): Boolean{
    print(text)
    val choice = readln()
    while (!choice.equals("y", true) && !choice.equals("n", true)){
        println("error! tolong input dengan benar!")
        continue
    }
    return choice.equals("y", true)
}