<?php
require_once 'Koneksi.php';


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


	$ujidata="SELECT * FROM data_kariawan WHERE nik = '$nik'";

	$validasi=mysqli_query($konek,$ujidata);

	$result=mysqli_num_rows($validasi);

	if ($result == 0) {

		$kueri="INSERT INTO data_kariawan(nik,nama,tempat_lahir,tgl_lahir,alamat,kelamin,agama,status,pendidikan,jabatan) VALUES('$nik','$nama','$tmplahir','$tgllahir','$alamat','$kelamin','$agama','$status','$pdd','$jabatan')";

			$exekueri=mysqli_query($konek,$kueri);

			echo json_encode(array('pesan'=>1,'kode'=>'Data berhasil disimpan.'));
	}else

	{
		
		$kueri="UPDATE data_kariawan SET 	nama='$nama',
											tempat_lahir='$tmplahir',
											tgl_lahir='$tgllahir',
											alamat='$alamat',
											kelamin='$kelamin',
											agama='$agama',
											status='$status',
											pendidikan='$pdd',
											jabatan='$jabatan'
											 WHERE nik='$nik'";
		

			$exekueri=mysqli_query($konek,$kueri);
			
			echo json_encode(array('pesan'=>2,'kode' =>'Data berhasil di-update.'));

	}

}

?>