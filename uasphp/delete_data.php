<?php
require_once 'Koneksi.php';


if($_SERVER['REQUEST_METHOD']=='POST')
{
	$nik=$_POST['nik'];
	
	$kueri="DELETE FROM data_kariawan WHERE nik = '$nik'";

	$exekueri=mysqli_query($konek,$kueri);

		echo json_encode(array('pesan'=>1,'kode' =>'Data berhasil di-hapus.'));
		

	
}else

{		
		
		json_encode(array('pesan'=>2,'kode'=>'Data gagal dihapus.'));
		//json_encode(array('pesan'=>101,'kode'=>'request tidak valid.'));				
			
}

?>