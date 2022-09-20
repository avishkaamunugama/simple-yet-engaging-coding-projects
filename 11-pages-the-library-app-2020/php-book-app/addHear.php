<?php

include_once 'db_conn.php';

$sqlId = "SELECT MAX(device.deviceCatalogId) AS id FROM device";
$result = mysqli_query($conn,$sqlId);
$idArray = mysqli_fetch_array($result);
$id = (int)$idArray['id'];

$make = $_POST['make'];
$hdModel = $_POST['hdModel'];



$sql = "INSERT INTO hearing_device (`deviceCatalogId`,`hdMake`,`hdModel`)
VALUES ($id,'$make','$hdModel');";

mysqli_query($conn,$sql);




header("Location: ../DB-web/index.php?Success");
// header('Location: ' . $_SERVER['HTTP_REFERER']);

?>