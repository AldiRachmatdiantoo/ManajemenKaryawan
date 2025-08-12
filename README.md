# Aplikasi Manajemen Karyawan

Aplikasi web sederhana untuk mengelola data karyawan. Aplikasi ini menyediakan fitur dasar untuk menambah, melihat, mengedit, dan menghapus data karyawan.

## Fitur Utama

- **CRUD Karyawan:** Kemampuan untuk *Create*, *Read*, *Update*, dan *Delete* data karyawan.
- **Tampilan Daftar Karyawan:** Menampilkan semua data karyawan dalam bentuk tabel yang mudah dibaca.
- **Detail Karyawan:** Melihat informasi detail untuk setiap karyawan.
- **Navigasi Sederhana:** Antarmuka yang intuitif dan mudah digunakan.

## Teknologi yang Digunakan

Proyek ini dibangun menggunakan kombinasi teknologi berikut:

- **Back-end:**
  - PHP (versi yang kompatibel)
  - Framework: [Laravel](https://laravel.com/) (asumsi)
- **Front-end:**
  - HTML, CSS, JavaScript
  - Framework CSS: [Bootstrap](https://getbootstrap.com/) atau [Tailwind CSS](https://tailwindcss.com/) (asumsi)
- **Database:**
  - [MySQL](https://www.mysql.com/) atau [MariaDB](https://mariadb.org/)

## Persyaratan Sistem

Pastikan Anda memiliki hal-hal berikut terinstal di komputer Anda:

- PHP (versi yang kompatibel dengan framework yang digunakan)
- [Composer](https://getcomposer.org/)
- Database (MySQL/MariaDB)
- Web server (seperti Apache atau Nginx)

## Langkah-langkah Instalasi

Ikuti langkah-langkah di bawah ini untuk menjalankan proyek secara lokal.

1.  **Clone repositori ini:**

    ```bash
    git clone [https://github.com/AldiRachmatdiantoo/ManajemenKaryawan.git](https://github.com/AldiRachmatdiantoo/ManajemenKaryawan.git)
    cd ManajemenKaryawan
    ```

2.  **Instal dependensi Composer:**

    ```bash
    composer install
    ```

3.  **Salin file `.env`:**
    Jika menggunakan Laravel, salin file `.env.example` dan ubah namanya menjadi `.env`.

    ```bash
    cp .env.example .env
    ```

4.  **Konfigurasi Database:**
    Buka file `.env` dan sesuaikan kredensial database Anda (misalnya, `DB_DATABASE`, `DB_USERNAME`, `DB_PASSWORD`).

5.  **Jalankan migrasi database:**
    Perintah ini akan membuat tabel-tabel yang diperlukan di database Anda.

    ```bash
    php artisan migrate
    ```

    *Opsional: Jika ada seeder, Anda bisa menjalankannya untuk mengisi data awal.*
    ```bash
    php artisan db:seed
    ```

6.  **Jalankan aplikasi:**

    ```bash
    php artisan serve
    ```

    Aplikasi sekarang dapat diakses di `http://127.0.0.1:8000` di browser web Anda.

## Penggunaan

Setelah aplikasi berjalan, Anda dapat:
- Mengakses halaman utama untuk melihat daftar karyawan.
- Mengklik tombol "Tambah Karyawan" untuk menambahkan data baru.
- Menggunakan tombol "Edit" atau "Hapus" pada setiap baris untuk memodifikasi atau menghapus data karyawan.

## Kontributor

Proyek ini dibuat oleh:
- [Aldi Rachmatdiantoo](https://github.com/AldiRachmatdiantoo)

## Lisensi

Proyek ini dilisensikan di bawah [Lisensi MIT](https://opensource.org/licenses/MIT). Silakan lihat file `LICENSE` untuk detail lebih lanjut.

---
**Catatan:** *Dokumentasi ini dibuat berdasarkan asumsi framework yang umum digunakan. Jika proyek Anda menggunakan teknologi atau struktur yang berbeda, silakan sesuaikan langkah-langkah instalasi dan detail lainnya.*
