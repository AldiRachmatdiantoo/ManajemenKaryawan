sealed class Karyawan {
    data class FullTime(
        val name: String,
        val email: String,
        var role: String?,
        val gaji: Int
    ) : Karyawan()

    data class Freelance(
        val name: String,
        val email: String,
        var role: String?,
        val jamKerja: Int,
        val gajiPerJam: Int
    ) : Karyawan()

    data class Manager(
        val name: String,
        val email: String,
        var role: String?
        )
}