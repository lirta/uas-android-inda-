<?php
require 'koneksi.php';

if($_SERVER['REQUEST_METHOD']=='POST')
{
	$nik=$_POST['nik'];
	$nama=$_POST['nama'];
	$tempat_lahir=$_POST['tempat_lahir'];
	$tgl_lahir=$_POST['tgl_lahir'];

		$test="SELECT * FROM data_kariawan WHERE nik = '$nik' ";

		$validasi=mysqli_query($konek,$test);

		$result=mysqli_num_rows($validasi);


		if ($result ==0) {
			
			$simpan="INSERT INTO data_kariawan(nik,nama,tempat_lahir,tgl_lahir) VALUES('$nik','$nama','$tempat_lahir','$tgl_lahir')";

			$exesimpan=mysqli_query($konek,$simpan);

			echo json_encode(array('kode'=>1,'pesan'=>'Data Berhasil disimpan.'));
		}
		else
		{
			echo json_encode(array('kode'=>2,'pesan'=>'Data sudah ada.'));
		}

}

?>
