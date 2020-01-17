<?php
require 'koneksi.php';

if($_SERVER['REQUEST_METHOD']=='POST')
{
	$nik=$_POST['nik'];
	$nama=$_POST['nama'];
	$tmplahir=$_POST['tempat_lahir'];
	$tgllahir=$_POST['tgl_lahir'];
	$alamat=$_POST['alamat'];
	$kelamin=$_POST['kelamin'];
	$agama=$_POST['agama'];
	$status=$_POST['status'];
	$pdd=$_POST['pendidikan'];
	$jabatan=$_POST['jabatan'];

		$test="SELECT * FROM data_kariawan WHERE nik = '$nik' OR nama='$nama'";

		$validasi=mysqli_query($konek,$test);

		$result=mysqli_num_rows($validasi);


		if ($result ==0) {
			
			$simpan="INSERT INTO data_kariawan(nik,nama,tempat_lahir,tgl_lahir,alamat,kelamin,agama,status,pendidikan,jabatan) VALUES('$nik','$nama','$tmplahir','$tgllahir','$alamat','$kelamin','$agama','$status','$pdd','$jabatan')";

			$exesimpan=mysqli_query($konek,$simpan);

			echo json_encode(array('kode'=>1,'pesan'=>'Data Berhasil disimpan.'));
		}
		else
		{
			echo json_encode(array('kode'=>2,'pesan'=>'Data sudah ada.'));
		}

}

?>
