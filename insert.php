<?php
// tất cả các biến sẽ có dấu $
// truy cập thuộc tính của đối tượng dùng dấu ->
// nối chuỗi dùng dấu .
// hàm printf thì đổi thành echo: dùng để in ra màn hình

// 1: khai báo thông tin kết nối csdl
$s="localhost" ; $u="root" ; $p="" ; $db="lab5";

//2. kết nối csdl
$con = new mysqli($s,$u,$p,$db);

//3. viết lệnh insert
$sql = "INSERT into sanpham (MaSp,TenSp,Mota) VALUES ('PH03','san pham 01','mo ta 01')";

//4. thực hiện insert 
if( $con -> query($sql) === TRUE ){
    echo "insert thành công";
}else{
    echo "Lỗi ".$con -> error;
}
// 5 . đóng kết nối
$con->close();
// http://localhost/lab5/insert.php?MaSp=PH03&TenSp=san pham 02&Mota=mo ta 02