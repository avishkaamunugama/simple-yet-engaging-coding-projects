<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <link rel="stylesheet" href="./style.css" />
  <title>Home</title>
</head>

<body>
  <br>
  <h1 id="main_h1">The Pages</h1>
  <h5 id="main_h1">A library beyond a normal library</h5>
  <br>
  <br>
  <h2 id="main_h1">Library book management system</h2>
 
  <div class="container">
    <div class="add_comp">
      <button id="add_btn" onclick="switchView('sect1')">ADD</button>
      <div id="data_form">

        <div id="sect1">
          <h2>Add new Book/AudioBook</h2>
          <form action="addDevice.php" method="POST" id="form1">
            <label for="catalogName">Title</label>
            <input type="text" name="catalogName" placeholder="Book / AudioBook Title " required><br>

            <label for="descrip">Author</label>
            <input type="text" name="descrip" placeholder="Authored by"><br>

            <label for="availability">Category</label>
            <input type="text" name="availability" placeholder="Category / Genre"><br>

            <button type="submit" id="dSubmit">Submit</button>

          </form>

          <button id="moreBtn" onclick="switchView('chooseDevice')">Add more details</button>

        </div>


        <div id="chooseDevice" style="display: none;">

          <h2 id="cdH2">
            Choose type to proceed
          </h2>
          <div id="chooseBtns">
            <button id="visBtn" onclick="switchView('sect2')">Audio Book</button>
            <button id="hearBtn" onclick="switchView('sect3')">Hard-copy Book</button>
          </div>
          <button type="button" onclick="switchView('sect1')" id="backBtn1" class="backBtn">Go Back</button>

        </div>


        <div id="sect2" style="display: none;">
          <div class="centerItems">
            <h2>Add more audio-book details</h2>
            <br>
            <form action="addVis.php" method="POST" id="form2">
              <label for="brand">Narrator</label>
              <input type="text" name="brand" placeholder="Narrated by"><br>

              <label for="frModel">Format</label>
              <input type="text" name="frModel" placeholder="Audiobook format"><br>

              <label for="serial">Duration</label>
              <input type="text" name="serial" placeholder="AudioBook duration"><br>

              <label for="visionType">Year of narration</label>
              <input type="text" name="visionType" placeholder="First narrated on"><br>

              <label for="tint">Target audience</label>
              <input type="text" name="tint" placeholder="Targetted audience of the narrator"><br>

              <label for="thinness">Publisher Organization</label>
              <input type="text" name="thinness" placeholder="Organization published the audiobook"><br>
              <br>

              <button type="submit" id="vaSubmit">Add Audio-Book</button>
              <button type="button" onclick="switchView('chooseDevice')" class="backBtn">Go Back</button>
            </form>
          </div>

        </div>

        <div id="sect3" style="display: none;">
          <div class="centerItems">
            <h2>Add more book details</h2>
            <br>
            <form action="addHear.php" method="POST" id="form3">

              <label for="make">ISBN</label>
              <input type="text" name="make" placeholder="ISBN"><br>

              <label for="hdModel">Year</label>
              <input type="text" name="hdModel" placeholder="Year of the first issue"><br>
              <br>

              <button type="submit" id="haSubmit">Add Book</button>
              <button type="button" onclick="switchView('chooseDevice')" class="backBtn">Go Back</button>
            </form>
          </div>


        </div>


      </div>
    </div>
    <div class="view_comp">
      <button id="view_btn" onclick="switchView('view_area')">VIEW</button>
      <div id="view_area" style="display: none;">

<?php
include_once 'db_conn.php';

$sql = "SELECT * FROM device;";
$sqlHe = "SELECT * FROM hearing_device;";
$sqlVi = "SELECT * FROM visual_device;";

$result = mysqli_query($conn,$sql);
$resultHe = mysqli_query($conn,$sqlHe);
$resultVi = mysqli_query($conn,$sqlVi);


$resultCheck = mysqli_num_rows($result);
$resultCheckHe = mysqli_num_rows($resultHe);
$resultCheckVi = mysqli_num_rows($resultVi);


// availablityStatus 
// deviceDescrip

// hdMake
// hdModel

      // frBrand
// frModel
// lensSerialNb
// lensThicknessLevel
// lensTint
// lensVisionType
      


$arrayHe = array();

if($resultCheckHe>0){
  while($rowHe = mysqli_fetch_assoc($resultHe)){
    $arrayHe[$rowHe['deviceCatalogId']]=array($rowHe['hdMake'],$rowHe['hdModel']);
  }
}




$arrayVi = array();

if($resultCheckVi>0){
  while($rowVi = mysqli_fetch_assoc($resultVi)){
    $arrayVi[$rowVi['deviceCatalogId']]=array($rowVi['frBrand'],$rowVi['frModel'],$rowVi['lensSerialNb'],$rowVi['lensThicknessLevel'],$rowVi['lensTint'],$rowVi['lensVisionType']);
  }
}




if($resultCheck > 0){
  echo "<h1>Books & Audiobooks</h1><br><br>";
  while ($row = mysqli_fetch_assoc($result)){
 
    if(array_key_exists($row['deviceCatalogId'],$arrayVi))
    {
      echo "<h4>Audio Books</h4><br>";
      print_r("Title"." :-  ".
      $row['deviceCatalogName']."<br>".
      "Author"." :-  ".
      $row['deviceDescrip']. "<br>".
      "Category"." :-  ".
      $row['availablityStatus']."<br>");

      print_r(($arrayVi[$row['deviceCatalogId']][0]==NULL)?(""):("Narrator"." :-  ".$arrayVi[$row['deviceCatalogId']][0]. "<br>"));
      print_r(($arrayVi[$row['deviceCatalogId']][1]==NULL)?(""):("Format"." :-  ".$arrayVi[$row['deviceCatalogId']][1]. "<br>"));
      print_r(($arrayVi[$row['deviceCatalogId']][2]==NULL)?(""):("Duration"." :-  ".$arrayVi[$row['deviceCatalogId']][2]. "<br>"));
      print_r(($arrayVi[$row['deviceCatalogId']][3]==NULL)?(""):("Year of narration"." :-  ".$arrayVi[$row['deviceCatalogId']][3]. "<br>"));
      print_r(($arrayVi[$row['deviceCatalogId']][4]==NULL)?(""):("Target audience"." :-  ".$arrayVi[$row['deviceCatalogId']][4]. "<br>"));
      print_r(($arrayVi[$row['deviceCatalogId']][5]==NULL)?(""):("Publisher Organization"." :-  ".$arrayVi[$row['deviceCatalogId']][5]. "<br>"));
      print_r("<br><br><hr><br>");
    }
    else if(array_key_exists($row['deviceCatalogId'],$arrayHe))
    {
      echo "<h4>Hard-Copy Books</h4><br>";
      print_r("Title"." :-  ".
      $row['deviceCatalogName']."<br>".
      "Author"." :-  ".
      $row['deviceDescrip']. "<br>".
      "Category"." :-  ".
      $row['availablityStatus']."<br>");
      print_r(($arrayHe[$row['deviceCatalogId']][0]==NULL)?(""):("ISBN"." :-  ".$arrayHe[$row['deviceCatalogId']][0]. "<br>"));
      print_r(($arrayHe[$row['deviceCatalogId']][1]==NULL)?(""):("Year"." :-  ".$arrayHe[$row['deviceCatalogId']][1]. "<br>"));
      print_r("<br><br><hr><br>");
    }
  }
}


// print_r("Catalog Name"." :-  ".$row['deviceCatalogName']."<br>"."Description"." :-  ".$row['deviceDescrip']. "<br>"."Availability "." :-  ".$row['availablityStatus'].$arrayHe[(int)$row['deviceCatalogId']]."<br><br><hr><br>");
// print_r($arrayHe[$row['deviceCatalogId']][1]);

?>
        
      </div>
    </div>
  </div>




  <script src="./script.js"></script>
</body>

</html>