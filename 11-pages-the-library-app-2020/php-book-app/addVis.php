<?php


include_once 'db_conn.php';

$sqlId = "SELECT MAX(device.deviceCatalogId) AS id FROM device";
$result = mysqli_query($conn,$sqlId);
$idArray = mysqli_fetch_array($result);
$id = (int)$idArray['id'];

$brand = $_POST['brand'];
$frModel = $_POST['frModel'];
$serial = $_POST['serial'];
$visionType = $_POST['visionType'];
$tint = $_POST['tint'];
$thinness = $_POST['thinness'];



$sql = "INSERT INTO visual_device (`deviceCatalogId`,`frBrand`,`frModel`,`lensSerialNb`,`lensThicknessLevel`,`lensTint`,`lensVisionType`)
VALUES ($id,'$brand','$frModel','$serial','$thinness','$tint','$visionType');";

mysqli_query($conn,$sql);




header("Location: ../DB-web/index.php?Success");
// header('Location: ' . $_SERVER['HTTP_REFERER']);

?>