<?php
$res=array();
$s="localhost"; $u="root"; $p=""; $db="lab5";
$con=new mysqli($s,$u,$p,$db);
$MaSP=$_POST['MaSp'];//truyen tham so cho bien MaSP
$TenSP=$_POST['TenSp'];
$MoTa=$_POST['Mota'];
$sql="INSERT into SanPham (MaSp,TenSp,Mota) VALUES ('$MaSP','$TenSP','$MoTa')";
if($con->query($sql)===TRUE){
    $res['success']=1;
    $res['message']="insert thanh cong";
    echo json_encode($res);
}
else{
    $res['success']=0;
    $res['message']="insert that bai";
    echo json_encode($res);
}
$con->close();
