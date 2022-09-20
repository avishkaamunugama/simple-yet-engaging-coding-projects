<?php

include_once 'db_conn.php';


$catalogName = $_POST['catalogName'];
$descrip = $_POST['descrip'];
$availability = $_POST['availability'];


$sql = "INSERT INTO device (`deviceCatalogName`,`deviceDescrip`,`availablityStatus`) 
VALUES ('$catalogName','$descrip','$availability');";

mysqli_query($conn,$sql);




header("Location: ../DB-web/index.php?Success");
// header('Location: ' . $_SERVER['HTTP_REFERER']);

?>
