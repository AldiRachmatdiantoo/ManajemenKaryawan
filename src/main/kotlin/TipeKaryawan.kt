
sealed class TipeKaryawan {
    data class FullTime(
        val name: String,
        val email: String,
        var role: String?,
        val gaji: Int
    ) : TipeKaryawan()

    data class Freelance(
        val name: String,
        val email: String,
        var role: String?,
        val jamKerja: Int,
        val gajiPerJam: Int
    ) : TipeKaryawan()

    data class Manager(
        val name: String,
        val email: String,
        var role: String?
        ) : TipeKaryawan()
}