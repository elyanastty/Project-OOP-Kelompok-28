LATAR BELAKANG PEMBUATAN GAME TANGLETREK
Game ini dikembangkan sebagai respons terhadap meningkatnya permintaan untuk game yang tidak hanya menghibur, tetapi juga memberikan pengalaman bermakna kepada pemain. Dunia gaming saat ini telah menjadi lebih dari sekadar hiburan; banyak pemain menginginkan tantangan yang melibatkan kecerdasan, strategi, dan kreativitas.
Latar belakang pengembangan Tangletrek berasal dari ide menciptakan dunia fantasi di mana pemain bisa merasakan tantangan seperti menyelesaikan teka-teki nyata, berstrategi melawan musuh cerdas, dan menjelajahi dunia yang penuh misteri. Inspirasi datang dari berbagai genre, termasuk game petualangan klasik, escape room interaktif, dan RPG modern.Keunikan Tangletrek terletak pada pendekatannya yang fleksibel terhadap gameplay. Dalam permainan ini, tidak ada solusi tunggal untuk setiap masalah; pemain bebas mengeksplorasi berbagai cara untuk mencapai tujuan. Hal ini mencerminkan filosofi bahwa tidak ada batasan pada kreativitas manusia.
Selain itu, Tangletrek juga berupaya menjadi sarana pembelajaran dengan menyisipkan elemen edukasi. Teka-teki yang dirancang dapat membantu melatih keterampilan berpikir kritis, logika, hingga kolaborasi dalam mode multiplayer. Ini menjadikan game ini cocok untuk pemain dari berbagai kalangan usia, mulai dari anak-anak hingga dewasa.Visi pengembang adalah menjadikan Tangletrek sebagai game yang tidak hanya menghibur tetapi juga berkontribusi pada pengembangan kemampuan pemain dalam kehidupan nyata. Dunia Tangletrek adalah tempat di mana pemain dapat merasakan petualangan yang seru, menantang, dan penuh arti.
# DESKRPSI SEMENTARA PROJEK
TangleTrek adalah permainan petualangan seru di mana pemain dapat mengendalikan karakter yang berjuang melewati rintangan sulit seperti duri tajam dan sungai yang menghalangi perjalanan. Disungai terdapat semacam kayu yang bergerak-gerak sehingga diperlukan konsentrasi dari pemain untuk mengendalikan karakter agar bisa berpindah ke kayu dengan selamat dan tidak tercebur ke sungai. Pemain juga harus dapat mengendalikan karakter agar jangan sampai menyentuh duri karena bisa berakibat kekalahan atau game over. Permainan ini rencananya ada dua karakter yang bisa dipilih oleh pemain untuk melakukan perjalanan. Setiap karakter memiliki tampilan yang berbeda untuk memberikan variasi pengalaman bermain. skor setiap karakter juga akan tercatat di leaderboard yang tersimpan dalam database.

## Penjelasan Mengenai Fitur-Fitur yang ada didalam Project

1. Karakter Utama
Salah satu fitur utama dari permainan ini adalah karakter yang dikendalikan oleh pemain, yang dalam hal ini adalah seekor anjing bernama "Doge". Pemain dapat menggerakkan karakter ini di atas papan permainan dengan menggunakan tombol panah pada keyboard.

2. Pengolahan Input Pengguna
Permainan ini memiliki sistem input yang responsif. Permainan dapat merespons setiap penekanan tombol panah (atas, bawah, kiri, kanan) dan mengubah status karakter berdasarkan input tersebut. Ini menciptakan interaksi yang dinamis antara pemain dan permainan.

3. Logika Permainan dan Kematian Karakter
Fitur penting lainnya adalah logika permainan yang mengatur kondisi menang dan kalah. Jika karakter menyentuh air (tanpa item penyelamat) atau tanah dengan item, status karakter akan diubah menjadi mati. Dalam hal ini, permainan akan menampilkan layar "Game Over".

4. Visualisasi Papan Permainan
Panel baru dibuat untuk menampilkan kondisi terkini dari semua elemen permainan, seperti air, log, pohon, dan tanah. Elemen-elemen ini ditambahkan ke panel menggunakan GUI, dengan posisi yang disesuaikan berdasarkan status karakter dan elemen lain di medan yang memberikan visualisasi yang menarik dan membantu pemain memahami kondisi permainan secara lebih baik.

5. Pengacakan Medan dan Elemen Dinamis
Sistem pengacakan medan adalah fitur yang memberikan variasi dalam setiap sesi permainan. Elemen-elemen medan (seperti Water dan Ground) diisi secara acak dengan menggunakan objek Random. Ini menciptakan tantangan yang berbeda setiap kali permainan dimulai, membuat pemain terus tertantang dan terlibat. Setiap elemen juga memiliki properti tertentu, seperti apakah air memiliki item atau tidak, yang memengaruhi interaksi karakter dengan medan.

6. Skor dan GUI
Permainan ini juga mencakup penghitungan skor. GUI untuk skor ditampilkan, yang memungkinkan pemain untuk melacak kemajuan mereka. Ini dapat menjadi fitur yang lebih lanjut dikembangkan untuk memberikan umpan balik lebih kepada pemain mengenai pencapaian mereka selama bermain.

7. Game Over dan Restart
Fitur akhir yang penting adalah penanganan kondisi "Game Over". Setelah karakter mati, akan menampilkan pesan kepada pemain dan memberikan opsi untuk memulai ulang permainan atau keluar. Ini memberi pemain kesempatan untuk mencoba lagi dan memperbaiki kesalahan mereka, yang merupakan aspek penting dari permainan berbasis keterampilan.

8. Antarmuka Grafis Menggunakan Swing
Proyek ini juga menggunakan Swing, sebuah toolkit GUI di Java, untuk membangun antarmuka pengguna. Dengan menggunakan JFrame dan JPanel, permainan dapat menampilkan elemen-elemen grafis dengan cara yang terorganisir. Ini memungkinkan pengembang untuk menambahkan lebih banyak elemen interaktif di masa depan, seperti tombol untuk memulai ulang permainan atau menampilkan menu.
