# Aplikasi Manajemen Karyawan

Aplikasi ini adalah program berbasis **Command-Line Interface (CLI)** yang dibuat dengan **Kotlin** untuk mengelola data karyawan.  
Mendukung fitur login, dashboard interaktif, serta pengelolaan karyawan berdasarkan tipe (Full-Time & Freelance).

---

## Fitur Utama
- **Login & Autentikasi** menggunakan database MySQL.
- **CRUD Data Karyawan** (tambah, lihat, edit, hapus).
- **Pengelompokan Karyawan** berdasarkan tipe:
  - Full-Time
  - Freelance
- **Sorting** data karyawan berdasarkan tipe.
- **Menu navigasi interaktif** di terminal.

---

### Struktur Proyek

* src/main/kotlin/
    * Main.kt
    * Start.kt
    * TipeKaryawan.kt
    * com/manajemenkaryawan/
        * auth/
            * Login.kt
        * connection/
            * DatabaseConnection.kt
        * dashboard/
            * Menu.kt
            * OrganizeKaryawan.kt
            * Profile.kt
        * karyawan/
            * FreelanceSort.kt
            * FullTimeSort.kt

---

## Teknologi yang Digunakan
- **Bahasa**: Kotlin
- **Build Tool**: Gradle (Kotlin DSL)
- **Database**: MySQL
- **Driver JDBC** untuk koneksi database.

---

## Persyaratan Sistem
Pastikan Anda sudah menginstal:
- [JDK 17+](https://adoptium.net/)
- [Gradle](https://gradle.org/) (opsional, bisa pakai wrapper)
- MySQL Server

---

## Cara Instalasi & Menjalankan
1. **Clone repository**:
    ```bash
    git clone https://github.com/AldiRachmatdiantoo/ManajemenKaryawan.git
    cd ManajemenKaryawan
    ```

2. **Konfigurasi Database**:
   - Buat database MySQL baru.
   - Sesuaikan username, password, dan nama database di:
     ```
     src/main/kotlin/com/manajemenkaryawan/connection/DatabaseConnection.kt
     ```

3. **Build dan Jalankan Aplikasi**:
    ```bash
    ./gradlew run
    ```

4. **Login**:
   - Masukkan username & password sesuai data yang ada di tabel `user` pada database.

---

## Contoh Struktur Database

**Tabel `user`**
| id_user | username   | password   | nama_lengkap     |
|---------|-----------|------------|------------------|
| 1       | admin     | admin123   | Administrator    |

**Tabel `karyawan`**
| id_karyawan | nama       | tipe       | jabatan         | gaji    |
|-------------|------------|------------|-----------------|---------|
| 1           | Budi       | Full-Time  | Manager         | 8000000 |
| 2           | Sinta      | Freelance  | Designer        | 4000000 |

---

## Penggunaan
Setelah aplikasi berjalan:
- Pilih menu sesuai kebutuhan (lihat data, tambah karyawan, edit, hapus).
- Gunakan fitur sorting untuk mengelompokkan karyawan berdasarkan tipe.

---

## Kontributor
- [Aldi Rachmatdiantoo](https://github.com/AldiRachmatdiantoo)

---

## Lisensi
Proyek ini dilisensikan di bawah [MIT License](https://opensource.org/licenses/MIT).